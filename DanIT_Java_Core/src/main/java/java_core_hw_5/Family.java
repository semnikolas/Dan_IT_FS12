package java_core_hw_5;

import java.util.Arrays;
import java.util.Objects;

public class Family {

    private Human father;
    private Human mother;
    private Human[] children;
    private String familyTitle;

    public Family(Human father, Human mother, String familyTitle) {
        this.father = father;
        this.mother = mother;
        this.familyTitle = familyTitle;
        this.children = new Human[0];
        father.setFamily(this);
        mother.setFamily(this);
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

    public void addChild(Human child) {
        if (this.children.length == 0) {
            children = new Human[1];
            children[0] = child;
        } else {
            Human[] tempChildren = Arrays.copyOf(this.children, this.children.length + 1);
            tempChildren[tempChildren.length - 1] = child;
            this.children = tempChildren;
            child.setFamily(this);
        }
    }

    public void deleteChild(Human child) {
        for (int i = 0; i < this.children.length; i++) {
            if (Objects.equals(child, this.children[i])) {
                child.setFamily(null);
                Human[] tempChildren = Arrays.copyOf(this.children, this.children.length - 1);
                this.children = tempChildren;
                break;
            }
        }
    }

    public Integer countFamily() {
        return children.length + 2;
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
        String childInfo = (this.getChildren() != null) ? " Family has " + this.children.length + ((this.children.length == 1) ? " child" : " children") : " Family has no children";

        return "Family contains of:" +
                "\n-father= " + father +
                "\n-mother= " + mother +
                "\n-fathers pet= " + petFatherInfo +
                "\n-mothers pet= " + petMotherInfo +
                "\n-family contains of " + this.countFamily() + " people." + childInfo;
    }
}
