package Uppgift3;

public class Demo {

    public static void main(String[] args){
        Bil bil = new Bil(50, false, 6, false);

        System.out.println("Bil Gears are " + bil.getAmountOfGears() + bil.isChangeGear() + bil.getSpeed() + bil.getChangeSpeed());

        Boat boat = new Boat(50, false, 50, true);
        System.out.println("Boat: Dead weight: " + boat.getDeadWeight() + " - Turn? "
                + boat.getTurn() + " - Change speed? "
                + boat.getChangeSpeed() + " - Speed: " + boat.getSpeed());

    }
}
