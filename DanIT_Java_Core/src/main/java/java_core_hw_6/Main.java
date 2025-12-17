package java_core_hw_6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Pet dog01 = new Dog("Max", 2, "big");
        String[] dog01Habits = {"Eat", "Pipi", "Kaka"};
        dog01.setHabits(dog01Habits);
        Pet cat01 = new DomesticCat("Vasya", 1, "Very insane");
        Pet cat02 = new DomesticCat("Elsa", 1, "Not insane");

        Man artem = new Man("Artem", "Pydoprugora", 1985);
        Woman alina = new Woman("Alina", "Skalka", 1987);
        Family artemAlinaPydoprugora = new Family(artem, alina, "Podoprygiry");

        Human veraChild = new Human("Vera", "Pydoprugora", 2001, artem, alina);
        Human lenaChild = new Human("Lena", "Pydoprugora", 2002, artem, alina, 88, dog01);
        Human igorChild = new Human("Igor", "Pydoprygora", 2013);
        veraChild.setPet(cat01);

        System.out.println(veraChild.getPet() + "\n________________________");
        System.out.println(lenaChild.getPet() + "\n________________________");

        artem.setPet(cat02);
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
        alina.lookingAtHusbant();
        artem.lieOnTheCouchAndDoNothing();
        System.out.println(cat02 + "\n________________________");

        artemAlinaPydoprugora.bornChild();
    }
}
