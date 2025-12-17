package java_core_hw_8;

public final class Man extends Human {

    public Man(String name, String surname, long birthDate) {
        super(name, surname, birthDate);
    }

    public void lieOnTheCouchAndDoNothing() {
        System.out.println(this.getFamily().getMother().getName() + ", don't touch me now!...");
    }

    @Override
    public void greetPet() {
        System.out.println("Come to Daddy...");

    }
}
