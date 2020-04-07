package Uppgift3;

public class Boat extends Fordon {
    protected int deadWeight;
    protected boolean turn;

    public Boat(int speed, boolean changeSpeed){
        super(speed, changeSpeed);
        this.deadWeight = 10;
        this.turn = false;
    }

    public Boat(int speed, boolean changeSpeed, int deadWeight, boolean turn){
        super(speed, changeSpeed);
        this.deadWeight = deadWeight;
        this.turn = turn;
    }

    public void setDeadWeight(int deadWeight){
        this.deadWeight =  deadWeight;
    }
    public int getDeadWeight(){
        return deadWeight;
    }


    public void setTurn(boolean turn){
        this.turn = turn;
    }

    public boolean getTurn(){
        return turn;
    }
}
