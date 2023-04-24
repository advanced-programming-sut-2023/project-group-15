package org.example.model.building;


import org.example.model.MBC.Person;
import org.example.model.enums.Products;

public class EducationAndEmployment extends Building{
    private final int costForEachPerson;
    private final Person personType;

    public EducationAndEmployment(String name, int hp, int xCoordiante, int yCoordiante, Products material1, Products material2,
                                  int numberOfMaterial1, int numberOfMaterial2, int numberOfWorkers,
                                  int costForEachPerson, Person personType) {
        super(name, hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfMaterial2, numberOfWorkers);
        this.costForEachPerson = costForEachPerson;
        this.personType = personType;
    }

    public int getCostForEachPerson() {
        return costForEachPerson;
    }

    public Person getPersonType() {
        return personType;
    }
}
