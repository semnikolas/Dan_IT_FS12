package java_core_hw_8;

public enum SchedulerDays {

    MON("Monday"),
    TUE("Tuesday"),
    WED("Wednesday"),
    THU("Thursday"),
    FRI("Friday"),
    SAT("Saturday"),
    SUN("Sunday");

    private final String title;

    SchedulerDays(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
