package askisi4.spaces;
import askisi4.people.*;
public class Stairs extends Non_operating {
    public Stairs() {
        super();
        System.out.println("New Stairs have been created!");
    }

    public void enter(Student student) {
        super.enter(student);
        System.out.println(student.getName() + " enters Stairs!");
    }

    public Student exit(Student student) {
        System.out.println(student.getName() + " exits Stairs!");
        return super.exit(student);
    }
}
