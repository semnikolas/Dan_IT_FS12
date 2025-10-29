package java_core_hw_4;

public class Main {
    public static void main(String[] args) {
        Human ruslan = new Human("Ruslan", "Topor", 1965);
        Human olga = new Human("Olga", "Topor", 1966);
        Human artem = new Human("Artem", "Pydoprugora", 1961);
        Human alina = new Human("Alina", "Skalka", 1962);
        Family artemAlinaPydoprugora = new Family(artem, alina, "Podoprygiry");
        Human veraChild = new Human("Vera", "Pydoprugora", 2001);
        Human lenaChild = new Human("Lena", "Pydoprugora", 2002);

        Human petr = new Human ("Petr", "Topor", 1990, ruslan, olga);
        Human lesya = new Human ("Lesya", "Topor", 1987, artem, alina);
        Family petrLesyaTopor = new Family(petr, lesya, "Topor");


        Pet cat01 = new Pet("Vasya", "cat Maine Coon", 1);
        String[] cat01Habits = new String[3];
        veraChild.setPet(cat01);
        artemAlinaPydoprugora.addChild(veraChild);







    }
}
