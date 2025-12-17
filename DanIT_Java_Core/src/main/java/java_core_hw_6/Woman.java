package java_core_hw_6;

public final class Woman extends Human{

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public void lookingAtHusbant(){
        System.out.println("I'm looking at you, my dear " + this.getFamily().getFather().getName() + ", and see that you do nothing...");
    }

    @Override
    public void greetPet(){
        System.out.println("Hello! Yours mummy backs home!!!");

    }
}
