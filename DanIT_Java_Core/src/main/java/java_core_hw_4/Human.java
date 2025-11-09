package java_core_hw_4;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private Pet pet;
    private int iq;
    private Family family;
    private String[][] scheduler;

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        generateScheduler();
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        generateScheduler();
    }

    public Human(String name, String surname, int year, Human mother, Human father, int iq, Pet pet) {
        this.name = name;
        this.surname = surname;
        this.year = year;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public String[][] getScheduler() {
        return scheduler;
    }

    public void setScheduler(String[][] scheduler) {
        this.scheduler = scheduler;
    }

    public void greetPet() {
        System.out.println("Hello" + pet.getNickName());
    }

    public void describePet() {
        String describetrickLevelString = (pet.getTrickLevel() <= 50) ? "Very tricky" : "Not very tricky";
        System.out.println("I have " + pet.getSpecie() + ", " + "it's " + pet.getAge() + ((pet.getAge() == 1) ? " year old" : " years old") + ", it's " + describetrickLevelString);
    }

    private void generateScheduler() {
        SchedulerDays[] days = SchedulerDays.values();
        this.scheduler = new String[days.length][2];
        for (int i = 0; i < SchedulerDays.values().length; i++) {
            this.scheduler[i][0] = days[i].getTitle();
            this.scheduler[i][1] = "Put some text here";
        }
    }

    public void showScheduler() {
        System.out.println("Scheduler of: " + this.name);
        for (int i = 0; i < this.scheduler.length; i++) {
            for (int j = 0; j < this.scheduler[i].length; j++) {
                System.out.print(this.scheduler[i][j] + " ");
            }
            System.out.println();
        }
    }

    private String getSchedulerString() {
        StringBuilder stringSchedule = new StringBuilder();
        for (int i = 0; i < this.scheduler.length; i++) {
            stringSchedule.append(Arrays.toString(this.scheduler[i])).append('\n');
        }
        return stringSchedule.toString();
    }

    @Override
    public String toString() {
        String scheduleInfo = (this.scheduler != null) ? getSchedulerString() : " Has no Schedule";

        return "Human:" +
                "\n-name=" + " " + name +
                "\n-surname=" + " " + surname + '\'' +
                "\n-year of birthday=" + " " + year +
                "\n-iq=" + " " + iq +
                "\n-schedule= " + scheduleInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, family);
    }
}
