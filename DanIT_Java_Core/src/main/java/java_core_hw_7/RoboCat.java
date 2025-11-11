package java_core_hw_7;

import java.util.Arrays;

public class RoboCat extends Pet{
    public String batteryCapacity;
    public RoboCat(String petName, int age, String batteryCapacity) {
        super (petName, age);
        this.batteryCapacity = batteryCapacity;
    }
    public final Species species = Species.ROBOCAT;

    @Override
    public Species getSpecies(){
        return this.species;
    }

    @Override
    public void respond() {
        System.out.println("Bip-bip-biiiiip!");

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
