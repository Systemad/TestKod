package interfacedemo;

public class Student extends Person implements IPartyAnimal {

    private String kurs;

    public  Student(String name, String kurs){
        super(name);
        this.kurs = kurs;
    }

    public String getFavoriteSnack(){
        return "popcorn";
    }

}
