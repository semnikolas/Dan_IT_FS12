package java_core_hw_6;

import java_core_hw_6.Species;

import java.util.Arrays;

public class Dog extends Pet implements Foulable{

    public String size;

    public Dog(String petName, int age, String size) {
        super(petName, age);
        this.size = size;

    }

    public final Species species = Species.DOG;

    @Override
    public Species getSpecies(){
        return this.species;
    }
    @Override
    public void respond() {
        System.out.println("Gav-Gav-Gav!!!");
    }

    @Override
    public void foul() {
        System.out.println("Dog makes pipi in the room and looking at you with shame in eyes");

    }
    @Override
    public String toString() {
        String trickLevelString = (getTrickLevel() <= 50) ? "Very tricky" : "Not very tricky";
        return species +
                "\n-nickName = " + getNickName() +
                "\n-age = " + getAge() +
                "\n-trickLevel = " + trickLevelString +
                "\n-habits = " + Arrays.toString(getHabits()) +
                "\n-specie = " + species;
    }
}
