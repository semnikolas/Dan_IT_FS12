package java_core_hw_7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;


public class TestFamilyToString {
    public Human testFather = new Human("John", "Testovich", 1985);
    public Human testMother = new Human("Jane", "Testovna", 1986);
    public Dog fatherPet = new Dog("Buddy", 1, "Big");
    public int testFamilyContainsOf = 2;
    public Integer testChildrenQuantity = 0;
    public Human testChild = new Human("Ben", "Testovich", 2005);
    public List<Human> testChildren = new ArrayList<>();
    Family testFamily = new Family(testFather, testMother, "Testovichy");


    @Test
    public void testTestToString() {

        testFather.setPet(fatherPet);

        String petFatherInfo = (testFather.getPet() != null) ? " Fathers pet is " + testFather.getPet().getSpecies() + " " + testFather.getPet().getNickName() : " Father has no pet.";
        String petMotherInfo = (testMother.getPet() != null) ? " Mothers pet is " + testMother.getPet().getSpecies() + " " + testMother.getPet().getNickName() : " Mother has no pet.";
        String childInfo = (testFamily.getChildren() != null) ? " Family has " + testChildrenQuantity + ((testChildrenQuantity == 1) ? " child" : " children") : " Family has no children";

        String expected = "Family contains of:" +
                "\n-father= " + testFather +
                "\n-mother= " + testMother +
                "\n-fathers pet= " + petFatherInfo +
                "\n-mothers pet= " + petMotherInfo +
                "\n-family contains of " + testFamilyContainsOf + " people." + childInfo;
        assertEquals(expected, testFamily.toString(), "Something wrong!");
        System.out.println("_____________");

    }

    @Test
    public void testDeleteChild() {
        List<Human> expectedChildArea = new ArrayList<>();
        testChildren.add(testChild);
        for (Human human : testChildren) {
            if (human.equals(testChild)) {
                testChildren.remove(testChild);
                break;
            }
        }
        assertEquals(expectedChildArea.toString(), testChildren.toString(), "Something wrong!");
    }

    @Test
    public void testDeleteChildIllegal() {
        List<Human> expectedChildArea = new ArrayList<>();
        expectedChildArea.add(testChild);
        testChildren.add(testChild);
        for (Human human : testChildren) {
            if (human.equals(testFather)) {
                testChildren.remove(testChild);
                break;
            }
        }
        assertEquals(expectedChildArea.toString(), testChildren.toString(), "Something wrong!");
    }

    @Test
    public void testDeleteChildIndex() {
        List<Human> expectedChildArea = new ArrayList<>();
        testChildren.add(testChild);
        testChildren.remove(0);
        assertEquals(expectedChildArea.toString(), testChildren.toString(), "Something wrong!");
    }

    @Test
    public void testDeleteChildIndexIllegal() {
        List<Human> expectedChildArea = new ArrayList<>();
        expectedChildArea.add(testChild);
        testChildren.add(testChild);
        testChildren.remove(1);
        assertEquals(expectedChildArea.toString(), testChildren.toString(), "Something wrong!");
    }

    @Test
    public void testAddChildLegal() {
        List<Human> expectedChildArea = new ArrayList<>();
        expectedChildArea.add(testChild);
        testChildren.add(testChild);
        assertEquals(expectedChildArea.toString(), testChildren.toString(), "Something wrong!");
    }
}

