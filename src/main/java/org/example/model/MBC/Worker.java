package org.example.model.MBC;

public class Worker extends Person{
    public int numberOfWorker;

    private void addWorker(int number){
        this.numberOfWorker += number;
    }

    private void setNumberOfWorker(int number){
        this.numberOfWorker = number;
    }

    private void removeWorker(int number){
        this.numberOfWorker -= number;
    }

    private int getWorkerNumber(){
        return this.numberOfWorker;
    }
}
