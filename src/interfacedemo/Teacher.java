package interfacedemo;

public class Teacher extends Person implements IPartyAnimal {

    public  Teacher(String name){
        super(name);
    }

    public String getFavoriteSnack(){
        return "Kale chips";
    }

    public String getFavoriteDrink(){
        return "Wine";
    }
}
