package java_core_hw_8;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;
import java.time.ZoneOffset;

public class Main {
    public static void main(String[] args) {

        Pet dog01 = new Dog("Max", 2, "big");
        Set<String> dog01Habits = new HashSet<>();
        dog01Habits.add("Eat");
        dog01Habits.add("Pipi");
        dog01Habits.add("Kaka");
        dog01.setHabits(dog01Habits);
        Pet cat01 = new DomesticCat("Vasya", 1, "Very insane");
        Pet cat02 = new DomesticCat("Elsa", 1, "Not insane");

        LocalDateTime artemBirth = LocalDateTime.of(1985,7, 2, 0, 0, 0);
        long artemUnixBirthDate = artemBirth.toInstant(ZoneOffset.UTC).toEpochMilli();
        Man artem = new Man("Artem", "Pydoprugora", artemUnixBirthDate);

        LocalDateTime alinaBirth = LocalDateTime.of(1989,2, 28, 0, 0, 0);
        long alinaUnixBirthDate = alinaBirth.toInstant(ZoneOffset.UTC).toEpochMilli();
        Woman alina = new Woman("Alina", "Skalka", alinaUnixBirthDate);

        Family artemAlinaPydoprugora = new Family(artem, alina, "Podoprygiry");


        LocalDateTime veraBirth = LocalDateTime.of(2001,7, 2, 0, 0, 0);
        long veraUnixBirthDate = veraBirth.toInstant(ZoneOffset.UTC).toEpochMilli();
        Human veraChild = new Human("Vera", "Pydoprugora", veraUnixBirthDate);

        LocalDateTime lenaBirth = LocalDateTime.of(2002,7, 2, 0, 0, 0);
        long lenaUnixBirthDate = lenaBirth.toInstant(ZoneOffset.UTC).toEpochMilli();
        Human lenaChild = new Human("Lena", "Pydoprugora", lenaUnixBirthDate, 88, dog01);

        LocalDateTime igorBirth = LocalDateTime.of(2013,7, 2, 0, 0, 0);
        long igorUnixBirthDate = artemBirth.toInstant(ZoneOffset.UTC).toEpochMilli();
        Human igorChild = new Human("Igor", "Pydoprygora", igorUnixBirthDate);
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
        System.out.println(dog01 + "\n________________________");

        System.out.println(artemAlinaPydoprugora);
        alina.lookingAtHusbant();
        artem.lieOnTheCouchAndDoNothing();
        System.out.println(cat02 + "\n________________________");

        artemAlinaPydoprugora.bornChild();
        System.out.println(cat02 + "\n________________________");

        System.out.println(artemAlinaPydoprugora);
        artem.describeAge();
    }
}
