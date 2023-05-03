package askisi4.spaces;
import askisi4.people.*;
import java.util.Vector;

public abstract class Operating extends Space {
    protected int Cclass;
    protected Vector<Teacher> teachers = new Vector<>(1);

    protected Operating(int Cclass) {
        super();
        this.Cclass = Cclass;
    }

    protected void place(Teacher teacher) {
        teachers.add(teacher);
    }

    abstract void enter(Student student);

    abstract void operate(int N);

    abstract void print();
}
