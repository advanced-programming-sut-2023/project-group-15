package org.example.model.building;


import org.example.model.Person;

public class EducationAndEmployment extends Building{
    private final int costForEachPerson;
    private final Person personType;
    public EducationAndEmployment(int hp, int width, int height, int buildingCost,int cost,Person type) {
        super(hp, width, height, buildingCost);
        this.costForEachPerson = cost;
        this.personType = type;
    }

    public int getCostForEachPerson() {
        return costForEachPerson;
    }

    public Person getPersonType() {
        return personType;
    }
}
