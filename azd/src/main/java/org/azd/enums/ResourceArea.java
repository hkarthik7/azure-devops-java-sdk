package org.azd.enums;

public enum ResourceArea {
    ACCOUNT("0d55247a-1c47-4462-9b1f-5e2125590ee6", "Account"),
    AUDIT("94ff054d-5ee1-413d-9341-3f4a7827de2e", "audit"),
    BOARDS("11635d5f-a4f9-43ea-a48b-d56be43fee0f", "boards"),
    BUILD("5d6898bb-45ec-463f-95f9-54d49c71752e", "build"),
    COLLECTION("79bea8f8-c898-4965-8c51-8bbc3966faa8", "Collection"),
    CORE("79134c72-4a58-4b42-976c-04e7115f32bf", "core"),
    DASHBOARD("31c84e0a-3ece-48fd-a29d-100849af99ba", "Dashboard"),
    DISTRIBUTED_TASK("a85b8835-c1a1-4aac-ae97-1c3d0ba72dbd", "distributedTask"),
    EXTENSION_MANAGEMENT("6c2b0933-3600-42ae-bf8b-93d4f7e83594", "ExtensionManagement"),
    FAVORITE("67349c8b-6425-42f2-97b6-0843cb037473", "Favorite"),
    FEED_TOKEN("cdeb6c7d-6b25-4d6f-b664-c2e3ede202e8", "FeedToken"),
    GIT("4e080c62-fa21-4fbc-8fef-2a10a2b38049", "git"),

    GRAPH("bb1e7ec9-e901-4b68-999a-de7012b920f8", "Graph"),
    HEALTH("a5099f91-129c-4d51-a066-a96f6b31cf00", "Health"),
    IDENTITY("8a3d49b8-91f0-46ef-b33d-dda338c25db3", "IMS"),
    MAVEN("6f7f8c07-ff36-473c-bcf3-bd6cc9b6c066", "maven"),
    MEMBER_ENTITLEMENT_MANAGEMENT("68ddce18-2501-45f1-a17b-7931a9922690", "MemberEntitlementManagement"),
    NPM("4c83cfc1-f33a-477e-a789-29d38ffca52e", "npm"),
    NUGET("b3be7473-68ea-4a81-bfc7-9530baaa19ad", "nuget"),
    ORGANIZATION_JOIN("469b435e-3cdd-454e-957e-75afde947380", "organizationJoin"),
    ORGANIZATION_SETTINGS("358aec7a-9414-4096-8b6a-4505d8c6a68b", "OrganizationSettings"),
    ORGANIZATION_TOKEN_OIDC("d65b01c1-a9d1-40dc-b28a-1b04d47629bb", "OrganizationTokenOidc"),
    PACKAGE("45fb9450-a28d-476d-9b0f-fb4aedddff73", "Package"),
    PACKAGING("7ab4e64e-c4d8-4f50-ae73-5ef2e21642a5", "Packaging"),
    PERMISSIONS_REPORT("f3e9b8f5-7c1f-46e4-819b-e8a44ab105b8", "PermissionsReport"),
    PIPELINE_PERMISSIONS("a81a0441-de52-4000-aa15-ff0e07bfbbaa", "pipelinePermissions"),
    PIPELINE_POLICY("4abcfc63-2cbd-4c86-853d-185c0398ad91", "pipelinePolicy"),
    PIPELINES("2e0bf237-8973-4ec9-a581-9c3d679d1776", "pipelines"),
    PIPELINES_CHECKS("4a933897-0488-45af-bd82-6fd3ad33f46a", "PipelinesChecks"),
    POLICY("fb13a388-40dd-4a04-b530-013a739c72ef", "policy"),
    PROJECT_ANALYSIS("7658fa33-b1bf-4580-990f-fac5896773d3", "projectAnalysis"),
    PROJECT_SETTINGS("bc93db6f-a647-4d80-a3af-efa394e4baa7", "ProjectSettings"),
    PROVENANCE("b40c1171-807a-493a-8f3f-5c26d5e2f5aa", "Provenance"),
    PYPI("92f0314b-06c5-46e0-abe7-15fd9d13276a", "pypi"),
    RELEASE("efc2f575-36ef-48e9-b672-0c6fb4a48ac5", "Release"),
    REPORTING("57731fdf-7d72-4678-83de-f8b31266e429", "Reporting"),
    SEARCH("ea48a0a1-269c-42d8-b8ad-ddc8fcdcf578", "search"),
    SERVICE_ENDPOINT("1814ab31-2f4f-4a9f-8761-f4d77dc5a5d7", "serviceEndpoint"),
    SUBSCRIPTION("ac02550f-721a-4913-8ea5-cadae535b03f", "Subscription"),
    SYMBOL("af607f94-69ba-4821-8159-f04e37b66350", "Symbol"),
    TAGGING("1f131d7f-cfbb-4ec9-b358-fb4e8341ce59", "Tagging"),

    TEST("3b95fb80-fdda-4218-b60e-1052d070ae6b", "Test"),
    TEST_PLAN("e4c27205-9d23-4c98-b958-d798bc3f9cd4", "testPlan"),
    TEST_RESULTS("c83eaf52-edf3-4034-ae11-17d38f25404c", "testResults"),
    TFVC("8aa40520-446d-40e6-89f6-9c9f9ce44c48", "tfvc"),
    TOKEN_ADMIN("af68438b-ed04-4407-9eb6-f1dbae3f922e", "TokenAdmin"),
    U_PACK("d397749b-f115-4027-b6dd-77a65dd10d21", "uPack"),
    WIKI("bf7d82a0-8aa5-4613-94ef-6172a5ea01f3", "wiki"),
    WIT("5264459e-e5e0-4bd8-b118-0985e68a4ec5", "wit"),
    WORK("1d4f49f9-02b9-4e26-b826-2cdb6195f2a9", "work"),
    WORK_TRACKING("85f8c7b6-92fe-4ba6-8b6d-fbb67c809341", "workTracking");
    private final String id;
    private final String area;

    ResourceArea(String id, String area) {
        this.id = id;
        this.area = area;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return area;
    }
}
