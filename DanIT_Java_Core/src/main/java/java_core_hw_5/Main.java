package java_core_hw_5;

public class Main {
    public static void main(String[] args) {

        Pet dog01 = new Pet("Max", Species.DOG, 2);
        String[] dog01Habits = new String[3];
        Pet cat01 = new Pet("Vasya", Species.CAT, 1);
        String[] cat01Habits = new String[3];
        Pet cat02 = new Pet("Elsa", Species.CAT, 1);
        String[] cat02Habits = new String[3];
        Human ruslan = new Human();
        Human olga = new Human();
        Human artem = new Human("Artem", "Pydoprugora", 1985);
        Human alina = new Human("Alina", "Skalka", 1987);
        Family artemAlinaPydoprugora = new Family(artem, alina, "Podoprygiry");
        Family ruslanOlgaTopor = new Family(ruslan, olga, "Topor");
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











    }
}
