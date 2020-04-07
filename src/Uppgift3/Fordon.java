package Uppgift3;

public class Fordon {
    protected int speed;
    protected boolean changeSpeed;

    public Fordon(){}

    public Fordon(int speed, boolean changeSpeed){
        this.speed = speed;
        this.changeSpeed = changeSpeed;
    }

    public void setChangeSpeed(boolean changeSpeed) {
        this.changeSpeed = changeSpeed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean getChangeSpeed(){
        return changeSpeed;
    }
}
