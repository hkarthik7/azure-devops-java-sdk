FROM mcr.microsoft.com/devcontainers/java:11-bullseye

# Install Python 3 and Maven via apt to avoid SDKMAN internet dependency
RUN apt-get update && apt-get install -y --no-install-recommends \
    python3 \
    python3-pip \
    python3-venv \
    maven \
    ca-certificates \
    && update-ca-certificates \
    && apt-get clean && rm -rf /var/lib/apt/lists/*
