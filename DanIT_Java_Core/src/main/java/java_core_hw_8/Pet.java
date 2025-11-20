package java_core_hw_8;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Pet {
    private String nickName;
    private int age;
    private int trickLevel;
    private Set<String> habits;

    public Pet(String petName, int age) {
        this.nickName = petName;
        this.age = age;
        this.habits = new HashSet<>();
    }

    public abstract Species getSpecies();

    public String getNickName() {
        return nickName;
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setTrickLevel(int trickLevel) {
        if (trickLevel >= 0 && trickLevel <= 100) {
            this.trickLevel = trickLevel;
        }
    }

    public String getHabits() {
        if(this.habits.isEmpty()){
            return "Has no habits";
        }

        return this.habits.stream()
                .collect(Collectors.joining(", "));
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public void eat() {
        System.out.println("I'm eating!");
    }

    public abstract void respond();


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && Objects.equals(nickName, pet.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName, age);
    }

    @Override
    public abstract String toString();
}
