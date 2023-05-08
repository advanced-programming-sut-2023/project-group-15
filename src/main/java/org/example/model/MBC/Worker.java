package org.example.model.MBC;
// changed
public class Worker extends Person{
    private int numberOfWorker;
    private int randaman;

    public void addWorker(int number){
        this.numberOfWorker += number;
    }

    public void setNumberOfWorker(int number){
        this.numberOfWorker = number;
    }

    public void removeWorker(int number){
        this.numberOfWorker -= number;
    }

    public int getWorkerNumber(){
        return this.numberOfWorker;
    }
    public int getRandaman(){
        return this.randaman;
    }
    public void setRandaman(int randaman){
        this.randaman = randaman;
    }

}
