package org.example.model.MBC;


public class LauncherUnit extends Soldier {
    private int throwRange;

    public LauncherUnit(int speed, int attackingPower, int defense, int x, int y, int unitHp, int maxMove,
                        String name,String type, String state, int range) {
        super(speed, attackingPower, defense, x, y, unitHp, maxMove, name,type, state);
        this.throwRange = range;
    }

    public void setThrowRange(int throwRange) {
        this.throwRange = throwRange;
    }

    public int getThrowRageForCharging() {
        return this.throwRange;
    }

}
