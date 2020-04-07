package Uppgift3;

public class Bil extends Fordon {
    protected int amountOfGears;
    protected boolean changeGear;

    public Bil(int speed, boolean changeSpeed){
        super(speed, changeSpeed);
        this.amountOfGears = 6;
        this.changeGear = false;
    }

    public Bil(int speed, boolean changeSpeed, int amountOfGears, boolean changeGear){
        super(speed, changeSpeed);
        this.amountOfGears = amountOfGears;
        this.changeGear = changeGear;
    }

    public int getAmountOfGears(){
        return amountOfGears;
    }
    public boolean isChangeGear(){
        return changeGear;
    }
    public void setChangeGear(boolean changeGear){
        this.changeGear = changeGear;
    }

    public  void setAmountOfGears(int amountOfGears){
        this.amountOfGears = amountOfGears;
    }

}
