package ru.zhyldyz.enums;

public enum OrangeEndpoint {
    LOGIN("/auth/login", "Login"),
    ADMIN("/admin/viewSystemUsers", "Admin"),
    PIM("/pim/viewEmployeeList", "PIM"),
    LEAVE("/leave/viewLeaveList", "Leave"),
    TIME("/time/viewEmployeeTimesheet","Time"),
    RECRUITMENT("/recruitment/viewCandidates", "Recruitment"),
    MYINFO("/pim/viewPersonalDetails/empNumber/7", "My Info"),
    PERFORMANCE("/performance/searchEvaluatePerformanceReview", "Performance"),
    DASHBOARD("/dashboard/index", "Dashboard"),
    DIRECTORY("/directory/viewDirectory",   "Directory"),
    MAINTENANCE("/maintenance/purgeEmployee", "Maintenance"),
    CLAIM("/claim/viewAssignClaim", "Claim"),
    BUZZ("/buzz/viewBuzz", "Buzz");

    private final String endpoint;
    private final String pageTitle;

    OrangeEndpoint(String endpoint, String pageTitle) {
        this.endpoint = endpoint;
        this.pageTitle = pageTitle;
    }

    public String getEndpoint() {
        return endpoint;
    }
    public String getPageTitle() {

        return pageTitle;

    }

}


