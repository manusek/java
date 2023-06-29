package Projekt;

public class OgloszenieZwierze extends Ogloszenie{
    private String speciesOfAnimal;

    private int age;

    public OgloszenieZwierze(){};

    public String getSpeciesOfAnimal() {
        return speciesOfAnimal;
    }

    public void setSpeciesOfAnimal(String speciesOfAnimal) {
        this.speciesOfAnimal = speciesOfAnimal;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
