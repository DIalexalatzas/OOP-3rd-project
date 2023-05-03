package askisi4.spaces;
import askisi4.people.*;
import java.util.Vector;

public abstract class Non_operating extends Space {
    protected Vector<Student> students = new Vector<>();

    protected Non_operating() {
        super();
    }

    public void enter(Student student) {
        students.add(student);
    }

    public Student exit(Student student) {
        return students.remove(0);
    }
}
