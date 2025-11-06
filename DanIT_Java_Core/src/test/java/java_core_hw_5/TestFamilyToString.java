package java_core_hw_5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestFamilyToString {
    public Human testFather = new Human("John", "Testovich", 1985);
    public Human testMother = new Human("Jane", "Testovna", 1986);
    public Pet fatherPet = new Pet("Buddy", Species.CAT, 1);
    public Pet motherPet = new Pet("Whiskers", Species.DOG, 1);
    public int testFamilyContainsOf = 2;
    public Integer testChildrenQuantity = 0;
    public Human testChild = new Human("Ben", "Testovich", 2005);
    public Human[] testChildren= new Human[1];
    Family testFamily = new Family(testFather, testMother, "Testovichy");



    @Test
    public void testTestToString() {

        testFather.setPet(fatherPet);

        String petFatherInfo = (testFather.getPet() != null) ? " Fathers pet is " + testFather.getPet().getSpecie() + " " + testFather.getPet().getNickName() : " Father has no pet.";
        String petMotherInfo = (testMother.getPet() != null) ? " Mothers pet is " + testMother.getPet().getSpecie() + " " + testMother.getPet().getNickName() : " Mother has no pet.";
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
    public void testAddChildLegal() {
        Human[] expectedChildArea = new Human[2];
        expectedChildArea[0] = testChild;
        Human[] tempChildren = new Human[testChildren.length];
        System.arraycopy(testChildren, 0, tempChildren, 0, tempChildren.length);
        for (int i = 0; i < testChildren.length; i++) {
            if (testChildren[i] == null) {
                tempChildren[i] = testChild;
                testChildren = new Human[tempChildren.length + 1];
                System.arraycopy(tempChildren, 0, testChildren, 0, tempChildren.length);
                break;
            }
        }
        assertEquals(expectedChildArea[0], testChildren[0], "Something wrong!");
    }


        @Test
    public void testDeleteChild() {
        Human[] expectedChildArea = new Human[2];
        testChildren[0] = testChild;
        for (int i = 0; i < testChildren.length; i++) {
            if (Objects.equals(testChild, testChildren[i])) {
                testChildren[i] = null;
                break;
            }
        }
        assertEquals(expectedChildArea[0], testChildren[0], "Something wrong!");
    }
    @Test
    public void testDeleteChildIllegal() {
        Human[] expectedChildArea = new Human[2];
        expectedChildArea[0] = testChild;
        Human[] testChildren= new Human[2];
        testChildren[0] = testChild;
        for (int i = 0; i < testChildren.length; i++) {
            if (Objects.equals(testFather, testChildren[i])) {
                testChildren[i] = null;
                break;
            }
        }
        assertEquals(expectedChildArea[0], testChildren[0], "Something wrong!");
    }

    @Test
    public void testDeleteChildIndex() {
        Human[] expectedChildArea = new Human[2];
       // expectedChildArea[0] = testChild;
        Human[] testChildren= new Human[2];
        testChildren[0] = testChild;
        int index = 0;
        for (int i = 0; i < testChildren.length; i++) {
            if (Objects.equals(index, i)) {
                testChildren[i] = null;
                break;
            }
        }
        assertEquals(expectedChildArea[0], testChildren[0], "Something wrong!");
    }

    @Test
    public void testDeleteChildIndexIllegal() {
        Human[] expectedChildArea = new Human[2];
        expectedChildArea[0] = testChild;
        Human[] testChildren= new Human[2];
        testChildren[0] = testChild;
        int index = 2;
        for (int i = 0; i < testChildren.length; i++) {
            if (Objects.equals(index, i)) {
                testChildren[i] = null;
                break;
            }
        }
        assertEquals(expectedChildArea[0], testChildren[0], "Something wrong!");
    }


}

