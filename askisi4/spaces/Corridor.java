package askisi4.spaces;
import askisi4.people.*;
public class Corridor extends Non_operating {
    public Corridor() {
        super();
        System.out.println("A New Corridor has been created!");
    }

    public void enter(Student student) {
        super.enter(student);
        System.out.println(student.getName() + " enters Corridor!");
    }

    public Student exit(Student student) {
        System.out.println(student.getName() + " exits Corridor!");
        return super.exit(student);
    }
}
