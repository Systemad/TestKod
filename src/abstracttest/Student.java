package abstracttest;

public class Student extends Person{
    private String school;
    private String subject;

    public Student(String name, String gender, boolean student, String school, String subject){
        super(name, gender, student);
        this.school = school;
        this.subject = subject;
    }


}
