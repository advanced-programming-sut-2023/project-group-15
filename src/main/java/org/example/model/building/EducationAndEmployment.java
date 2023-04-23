package org.example.model.building;


import org.example.model.MBC.Person;
import org.example.model.enums.products;

public class EducationAndEmployment extends Building{
    private final int costForEachPerson;
    private final Person personType;

    public EducationAndEmployment(int hp, int xCoordiante, int yCoordiante, products material1, products material2,
                                  int numberOfMaterial1, int numberOfWorkers, int costForEachPerson, Person personType) {
        super(hp, xCoordiante, yCoordiante, material1, material2, numberOfMaterial1, numberOfWorkers);
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
