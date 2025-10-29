package java_core_hw_4;

import java.util.Arrays;
import java.util.Objects;

public class Family {

    private Human father;
    private Human mother;
    private Human[] children;
    private String familyTitle;
    private int childrenQuantity;
    private int familyContainsOf;

    public Family(Human father, Human mother, String familyTitle) {
        this.father = father;
        this.mother = mother;
        this.familyTitle = familyTitle;
        this.children = new Human[1];
        father.setFamily(this);
        mother.setFamily(this);
        this.familyContainsOf = 2;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public String getFamilyTitle() {
        return familyTitle;
    }

    public void setFamilyTitle(String familyTitle) {
        this.familyTitle = familyTitle;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public void addChild(Human name) {
        Human[] tempChildren = new Human[this.children.length];
        System.arraycopy(this.children, 0, tempChildren, 0, tempChildren.length);
        for (int i = 0; i < this.children.length; i++) {
            if (children[i] == null) {
                name.setFamily(this);
                ++this.childrenQuantity;
                ++this.familyContainsOf;
                tempChildren[i] = name;
                this.children = new Human[tempChildren.length + 1];
                System.arraycopy(tempChildren, 0, this.children, 0, tempChildren.length);
                break;
            }
        }
    }

    public void deleteChild(Human name) {
        for (int i = 0; i < this.children.length; i++) {
            if (Objects.equals(name, this.children[i])) {
                name.setFamily(null);
                --this.childrenQuantity;
                --this.familyContainsOf;
                this.children[i] = null;
                break;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(father, family.father) && Objects.equals(mother, family.mother) && Objects.deepEquals(children, family.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(father, mother, Arrays.hashCode(children));
    }

    @Override
    public String toString() {
        String petFatherInfo = (father.getPet() != null) ? " Fathers pet is " + father.getPet().getNickName() : " Father has no pet.";
        String petMotherInfo = (mother.getPet() != null) ? " Mothers pet is " + mother.getPet().getNickName() : " Mother has no pet.";
        String childInfo = (this.getChildren() != null) ? " Family has " + this.childrenQuantity + ((this.childrenQuantity == 1) ? " child" : " children") : " Family has no children";
        return "Family contains of:" +
                "\n-father= " + father +
                "\n-mother= " + mother +
                "\n-fathers pet= " + petFatherInfo +
                "\n-mothers pet= " + petMotherInfo +
                "\n-family contains of " + this.familyContainsOf + " people." + childInfo;
    }
}
