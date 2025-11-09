package java_core_hw_4;

public class Main {
    public static void main(String[] args) {

        Pet dog01 = new Pet("Max", "dog Dog", 2);
        String[] dog01Habits = {"Eat", "Pipi", "Kaka"};
        dog01.setHabits(dog01Habits);
        Pet cat01 = new Pet("Vasya", "cat Maine Coon", 1);
        Pet cat02 = new Pet("Elsa", "cat", 1);

        Human ruslan = new Human();
        Human olga = new Human();
        Human artem = new Human("Artem", "Pydoprugora", 1985);
        Human alina = new Human("Alina", "Skalka", 1987);

        Family artemAlinaPydoprugora = new Family(artem, alina, "Podoprygiry");

        Human veraChild = new Human("Vera", "Pydoprugora", 2001, artem, alina);
        Human lenaChild = new Human("Lena", "Pydoprugora", 2002, artem, alina, 88, dog01);
        Human igorChild = new Human("Igor", "Pydoprygora", 2013);
        veraChild.setPet(dog01);

        System.out.println(veraChild.getPet() + "\n________________________");
        System.out.println(lenaChild.getPet() + "\n________________________");

        artem.setPet(cat01);
        artem.setIq(123);
        alina.setIq(99);

        artemAlinaPydoprugora.addChild(veraChild);
        artemAlinaPydoprugora.addChild(lenaChild);
        artemAlinaPydoprugora.addChild(igorChild);
        artemAlinaPydoprugora.deleteChild(veraChild);
        artem.showScheduler();

        System.out.println("\n________________________");
        System.out.println(alina + "\n________________________");
        System.out.println(cat02 + "\n________________________");

        System.out.println(artemAlinaPydoprugora);

        veraChild.describePet();
        System.out.println(dog01);
    }
}
