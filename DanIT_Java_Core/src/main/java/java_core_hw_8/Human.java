package java_core_hw_8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private Pet pet;
    private int iq;
    private Family family;
    private Map<String, String> scheduler;

    public Human(String name, String surname, long birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        generateScheduler();
    }
    public Human(String name, String surname, long birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        generateScheduler();
    }

    public Human(String name, String surname, long birthDate, int iq, Pet pet) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.pet = pet;
        generateScheduler();
    }

    public Human() {
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getYear() {
        return birthDate;
    }

    public void setYear(long birthDate) {
        this.birthDate = birthDate;
    }

    public void describeAge(){
        LocalDate dateOfBirth = Instant.ofEpochMilli(this.birthDate)
                .atZone(ZoneOffset.UTC)
                .toLocalDate();
        LocalDate dateOfNow = LocalDate.now();
        Period humanAge = Period.between(dateOfBirth, dateOfNow);
        String ageCalculation =  String.format(
                "%d years, %d months, %d days",
                humanAge.getYears(),
                humanAge.getMonths(),
                humanAge.getDays()
        );
        System.out.println(this.getName() + " age is:");
        System.out.println(ageCalculation);
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        if (iq >= 0 && iq <= 100) {
            this.iq = iq;
        }
    }

    public Map<String, String> getScheduler() {
        return scheduler;
    }

    public void setScheduler(Map<String, String> scheduler) {
        this.scheduler = scheduler;
    }

    public void greetPet() {
        System.out.println("Hello" + pet.getNickName());
    }

    public void describePet() {
        String describetrickLevelString = (pet.getTrickLevel() <= 50) ? "Very tricky" : "Not very tricky";
        System.out.println("I have " + pet.getSpecies() + ", " + "it's " + pet.getAge() + ((pet.getAge() == 1) ? " year old" : " years old") + ", it's " + describetrickLevelString);
    }

    private void generateScheduler() {
        SchedulerDays[] days = SchedulerDays.values();
        this.scheduler = new HashMap<>();
        for (int i = 0; i < SchedulerDays.values().length; i++) {
            this.scheduler.put(days[i].getTitle(), "Put some text here");
        }

    }

    public void showScheduler() {
        System.out.println("Scheduler of: " + this.name);
        this.scheduler.forEach((key, value) -> System.out.println(key + " " + value));
    }


    private StringBuilder getSchedulerString() {
        StringBuilder stringSchedule = new StringBuilder();
        stringSchedule.append("\n");
        for (Map.Entry<String, String> entry : this.scheduler.entrySet()) {
            stringSchedule.append(entry.getKey());
            stringSchedule.append(": ");
            stringSchedule.append(entry.getValue());
            stringSchedule.append("\n");
        }
        return stringSchedule;
    }

    @Override
    public String toString() {
        String scheduleInfo = (this.scheduler != null) ? getSchedulerString().toString() : " Has no Schedule";
        LocalDate humanAge = Instant.ofEpochMilli(this.birthDate)
                .atZone(ZoneOffset.UTC)
                .toLocalDate();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = humanAge.format(format);

        return "Human:" +
                "\n-name= " + name +
                "\n-surname= " + surname + '\'' +
                "\n-year of birthday= " + birthDate +
                "\n-iq= " + iq +
                "\n-age= " + formattedDate +
                "\n-schedule= " + scheduleInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, family);
    }
}

