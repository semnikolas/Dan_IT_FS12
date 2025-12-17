package java_core_hw_8;

public class Fish extends Pet {
    public String aquariumDimensions;

    public Fish(String petName, int age, String aquariumDimensions) {
        super(petName, age);
        this.aquariumDimensions = aquariumDimensions;
    }

    public final Species species = Species.FISH;

    @Override
    public Species getSpecies() {
        return this.species;
    }

    @Override
    public void respond() {
        System.out.println("... ... ...");

    }

    @Override
    public String toString() {
        String trickLevelString = (getTrickLevel() <= 50) ? "Very tricky" : "Not very tricky";
        return species +
                "\n-nickName = " + getNickName() +
                "\n-age = " + getAge() +
                "\n-trickLevel = " + trickLevelString +
                "\n-habits = " + getHabits() +
                "\n-specie = " + species;
    }
}
