package model;

public class ToyDemo {
    public static String sayHello() {
        return "Hello";
    }

    public static void sayAnything(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        //System.out.println("Hello, World!");
        //System.out.println(sayHello());
        //sayAnything("Hej");



        Toy nc3;
        nc3 = new Toy();

        Toy nc = new Toy();
        System.out.println(nc.getToyName());

        Toy nc2 = new Toy("TestToy", 5);
        System.out.println(nc2.getToyName());
        System.out.println(nc2.getToyAge());

    }
}