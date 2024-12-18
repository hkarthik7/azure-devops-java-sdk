package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Attachment type By Default it will be GeneralAttachment. Used in test attachment.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TestAttachmentType {
    @JsonProperty("generalAttachment")
    GENERAL_ATTACHMENT,
    @JsonProperty("afnStrip")
    AFN_STRIP,
    @JsonProperty("bugFilingData")
    BUG_FILING_DATA,
    @JsonProperty("codeCoverage")
    CODE_COVERAGE,
    @JsonProperty("intermediateCollectorData")
    INTERMEDIATE_COLLECTOR_DATA,
    @JsonProperty("runConfig")
    RUN_CONFIG,
    @JsonProperty("testImpactDetails")
    TEST_IMPACT_DETAILS,
    @JsonProperty("tmiTestRunDeploymentFiles")
    TMI_TEST_RUN_DEPLOYMENT_FILES,
    @JsonProperty("tmiTestRunReverseDeploymentFiles")
    TMI_TEST_RUN_REVERSE_DEPLOYMENT_FILES,
    @JsonProperty("tmiTestResultDetail")
    TMI_TEST_RESULT_DETAIL,
    @JsonProperty("tmiTestRunSummary")
    TMI_TEST_RUN_SUMMARY
}
