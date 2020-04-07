package interfacedemo;

public interface IPartyAnimal {
    public String getFavoriteSnack();

    default String getFavoriteDrink(){
        return "beer";
    }

}
