public class Student {
    public int rollno;
    public String name;
    public String email;

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
