package abstracttest;

public class Person {
    private String name;
    private String gender;
    private boolean student;

    public Person(){}

    public Person(String name, String gender, boolean student){
        this.name = name;
        this.gender = gender;
        this.student = student;
    }


    public String getName(){
        return name;
    }

    public String getGender() {
        return gender;
    }

    public boolean getStudent() {
        return student;
    }

    public void printMe(){

        System.out.println("Is student: " + getStudent());
    }
}
