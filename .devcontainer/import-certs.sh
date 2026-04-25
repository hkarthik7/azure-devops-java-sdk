#!/bin/bash
# Import SSL certificates for Azure DevOps into the Java truststore.
# This is needed in devcontainers where the default Java cacerts may not
# include the intermediate/root CAs used by dev.azure.com.
#
# This script is designed to be non-blocking: hosts that are unreachable
# (e.g. on restricted corporate networks) are skipped with a warning.
# The devcontainer setup will succeed regardless of whether cert import works.

JAVA_CACERTS="$(dirname $(dirname $(readlink -f $(which java))))/lib/security/cacerts"

if [ ! -f "$JAVA_CACERTS" ]; then
  echo "Java cacerts not found at $JAVA_CACERTS, skipping cert import."
  exit 0
fi

HOSTS="dev.azure.com vssps.dev.azure.com vsaex.dev.azure.com app.vssps.visualstudio.com feeds.dev.azure.com vsrm.dev.azure.com"

for host in $HOSTS; do
  echo "Importing certs for $host..."
  certs=$(timeout 10 bash -c "echo | openssl s_client -showcerts -connect \"$host:443\" -servername \"$host\" 2>/dev/null") || {
    echo "  Skipped $host (network unreachable or timed out)."
    continue
  }
  echo "$certs" | awk -v h="$host" '/BEGIN CERTIFICATE/,/END CERTIFICATE/{if(/BEGIN/)n++;print > "/tmp/"h"-cert"n".crt"}'
  for f in /tmp/${host}-cert*.crt; do
    [ -f "$f" ] || continue
    alias="$(basename "$f" .crt)"
    sudo keytool -importcert -noprompt -trustcacerts \
      -alias "$alias" -file "$f" \
      -keystore "$JAVA_CACERTS" -storepass changeit 2>/dev/null || true
    rm -f "$f"
  done
done

echo "SSL certificate import completed."
