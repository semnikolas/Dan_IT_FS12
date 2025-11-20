package java_core_hw_8;

import java.time.LocalDate;
import java.util.*;

public class Family implements HumanCreator {

    private Human father;
    private Human mother;
    private List<Human> children;
    private String familyTitle;
    private Set<Pet> familyPets;
    private final String[] childNames = {
            "Olena",
            "Anna",
            "Yulia",
            "Mariya",
            "Viktoriya",
            "Kateryna",
            "Iryna",
            "Khrystyna",
            "Solomiya",
            "Zlata",
            "Yana",
            "Oleksandr",
            "Andriy",
            "Dmytro",
            "Maksym",
            "Volodymyr",
            "Yaroslav",
            "Artem",
            "Mykhailo",
            "Ivan",
            "Kyrylo"
    };

    public Family(Human father, Human mother, String familyTitle) {
        this.father = father;
        this.mother = mother;
        this.familyTitle = familyTitle;
        this.children = new ArrayList<>();
        father.setFamily(this);
        mother.setFamily(this);
        this.familyPets = new HashSet<>();
        this.familyPets.add(father.getPet());
        this.familyPets.add(mother.getPet());
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

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    public void addChild(Human child) {

        this.children.add(child);
    }

    public void deleteChild(Human child) {
        for (Human human : this.children) {
            if (human.equals(child)) {
                this.children.remove(child);
                break;
            }
        }
    }

    public Integer countFamily() {
        return children.size() + 2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(father, family.father) && Objects.equals(mother, family.mother) && Objects.deepEquals(children, family.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(father, mother, children, familyTitle);
    }

    @Override
    public String toString() {
        String petFatherInfo = (father.getPet() != null) ? " Fathers pet is " + father.getPet().getSpecies() + " " + father.getPet().getNickName() : " Father has no pet.";
        String petMotherInfo = (mother.getPet() != null) ? " Mothers pet is " + mother.getPet().getSpecies() + " " + mother.getPet().getNickName() : " Mother has no pet.";
        String childInfo = (this.getChildren() != null) ? " Family has " + this.children.size() + ((this.children.size() == 1) ? " child" : " children") : " Family has no children";

        return "Family contains of:" +
                "\n-father= " + father +
                "\n-mother= " + mother +
                "\n-fathers pet= " + petFatherInfo +
                "\n-mothers pet= " + petMotherInfo +
                "\n-family contains of " + this.countFamily() + " people." + childInfo;
    }

    @Override
    public void bornChild() {
        int keyName = (int) (Math.random() * 19) + 1;
        Random randomSex = new Random();
        int bornDate = LocalDate.now().getYear();
        if (keyName <= 10) {
            String tempName = childNames[keyName];
            Woman childWoman = new Woman(tempName, this.getFamilyTitle(), bornDate);
            childWoman.setIq((this.father.getIq() + this.mother.getIq()) / 2);
            addChild(childWoman);
        } else {
            String tempName = childNames[keyName];
            Man childMan = new Man(tempName, this.getFamilyTitle(), bornDate);
            childMan.setIq((this.father.getIq() + this.mother.getIq()) / 2);
            addChild(childMan);
        }
    }
}
