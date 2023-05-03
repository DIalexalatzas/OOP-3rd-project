package askisi4.spaces;
import askisi4.people.*;
public class Yard extends Non_operating {
    public Yard() {
        super();
        System.out.println("A New Yard has been created!");
    }

    public void enter(Student student) {
        super.enter(student);
        System.out.println(student.getName() + " enters Yard!");
    }

    public Student exit(Student student) {
        System.out.println(student.getName() + " exits Yard!");
        return super.exit(student);
    }
}
