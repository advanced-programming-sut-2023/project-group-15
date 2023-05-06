package org.example.model.MBC;

public class People extends Person{
    public int numberOfPeople;

    private void addPeople(int number){
        this.numberOfPeople += number;
    }

    public void setNumberOfPeople(int number){
        this.numberOfPeople = number;
    }

    public void removerPeople(int number){
        this.numberOfPeople -= number;
    }

    public int getPeopleNumber(){
        return numberOfPeople;
    }
}
