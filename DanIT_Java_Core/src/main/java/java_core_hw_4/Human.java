package java_core_hw_4;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int year;
    private Pet pet;
    private int iq;
    private Human hasMother;
    private Human hasFather;
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
        this.hasMother = mother;
        this.hasFather = father;
        generateScheduler();
    }

    public Human(String name, String surname, int year, Human mother, Human father, int iq, Pet pet) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.hasMother = mother;
        this.hasFather = father;
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

    public Human getHasMother() {
        return hasMother;
    }

    public void setHasMother(Human hasMother) {
        this.hasMother = hasMother;
    }

    public Human getHasFather() {
        return hasFather;
    }

    public void setHasFather(Human hasFather) {
        this.hasFather = hasFather;
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
        System.out.println(pet.toString());
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
        //String familyInfo = (family != null) ? " In family " + family.getFamilyTitle() : " Not in family";
        //String motherInfo = (this.hasMother != null) ? " Name of mother " + this.hasMother.name : " Has no mother";
        //String fatherInfo = (this.hasFather != null) ? " Name of mother " + this.hasFather.name : " Has no father";
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
        return year == human.year && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(hasMother, human.hasMother) && Objects.equals(hasFather, human.hasFather) && Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, hasMother, hasFather, family);
    }
}
