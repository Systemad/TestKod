package Scannertest;

import java.util.Scanner;

public class scanner {
    scanner() {
        Scanner sc = new Scanner(System.in);
        int kostnad = 0;
        int betalning = 0;
        int vaxel = 0;

        System.out.println("How much did it cost?: " );

        boolean gettingKonstnad = false;

        while (!gettingKonstnad){
            try{
                if(sc.hasNextInt()){
                    kostnad = sc.nextInt();
                    gettingKonstnad = true;

                }
                else if (sc.hasNext()){
                    System.out.println("Invalid kostand (else)");
                    sc.next();
                }
            }
            catch(Exception e){
                System.out.println("Invalid kostand (exception)");
            }
        }

        System.out.println("kostnad " + kostnad);

    }
    public static void main(String[] args){
        scanner sc = new scanner();
    }
}




        /*
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.println("Enter text: ");
        s = sc.nextLine();
        System.out.println(s);
        */