package model;

public class Toy {
    private String ToyName = "Random Toy";
    private int ToyAge = 8;

    public Toy(String toyName, int toyAge){
        ToyName = toyName;
        ToyAge = toyAge;
    }

    public Toy() {};

    public String getToyName(){
        return ToyName;
    }

    public int getToyAge(){
        return ToyAge;
    }

}