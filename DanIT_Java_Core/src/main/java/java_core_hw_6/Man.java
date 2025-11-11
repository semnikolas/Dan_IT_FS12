package java_core_hw_6;

public final class Man extends Human{

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public void lieOnTheCouchAndDoNothing(){
        System.out.println(this.getFamily().getMother().getName() +   ", don't touch me now!...");
    }
    @Override
    public void greetPet(){
        System.out.println("Come to Daddy...");

    }
}
