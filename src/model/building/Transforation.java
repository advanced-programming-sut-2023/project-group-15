package model.building;


public class Transforation extends Building{
    private final int amount;

    public Transforation(int hp, int width, int height, int buildingCost, int amount) {
        super(hp, width, height, buildingCost);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
