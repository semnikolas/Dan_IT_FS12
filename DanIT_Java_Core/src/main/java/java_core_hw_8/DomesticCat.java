package java_core_hw_8;

public class DomesticCat extends Pet implements Foulable {
    public String insane;

    public DomesticCat(String petName, int age, String insane) {
        super(petName, age);
        this.insane = insane;
    }

    public final Species species = Species.DOMESTICCAT;

    @Override
    public Species getSpecies() {
        return this.species;
    }

    @Override
    public void foul() {
        System.out.println("Cat make kaka under the table and pretends the dog did it...");
    }

    @Override
    public void respond() {
        System.out.println("Meow-meow....mrrrrr...mrrrr...mrrrr...");
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
