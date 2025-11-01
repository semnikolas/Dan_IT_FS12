package java_core_hw_4;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Pet {
    private String nickName;
    private String specie;
    private int age;
    private int trickLevel;
    private String[] habits;
    private Human owner;

    public Pet(String petName, String specie) {
        this.nickName = petName;
        this.specie = specie;
    }

    public Pet(String petName, String specie, int age) {
        this.nickName = petName;
        this.specie = specie;
        this.age = age;
    }

    public Pet() {

    }

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }

    public String getNickName() {
        return nickName;
    }

    public String getSpecie() {
        return specie;
    }

    public int getAge() {
        return age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTrickLevel(int trickLevel) {
        if (trickLevel >= 0 && trickLevel <= 100) {
            this.trickLevel = trickLevel;
        }
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = new String[3];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < this.habits.length; i++) {
            int number = i + 1;
            System.out.println("Enter habit number " + number);
            this.habits[i] = scan.nextLine();
        }
    }

    public void eat() {
        System.out.println("I'm eating!");
    }

    public void respond() {
        System.out.println("I'm" + " " + nickName + ". I'm boring!");
    }

    public void foul() {
        System.out.println("You need to cover your tracks well...");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && Objects.equals(nickName, pet.nickName) && Objects.equals(specie, pet.specie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName, specie, age);
    }

    @Override
    public String toString() {
        String trickLevelString = (trickLevel <= 50) ? "Very tricky" : "Not very tricky";
        String ownerInfo = (this.owner != null) ? this.owner.getName() : "Has no owner!";
        return specie +
                "\n-nickName = " + nickName +
                "\n-age = " + age +
                "\n-trickLevel = " + trickLevelString +
                "\n-habits = " + Arrays.toString(habits) +
                "\n-specie = " + specie +
                "\n-owner = " + ownerInfo;


    }
}
