package askisi4.spaces;
import askisi4.people.*;
import java.util.Vector;

public class Classroom extends Operating {
    private final int floorNo;
    private final int classNo;
    protected Vector<Student> students = new Vector<>(Cclass);
    private final Vector<Teacher> teachers = new Vector<>(1);

    public Classroom(int Cclass, int floorNo, int classNo) {
        super(Cclass);
        this.floorNo = floorNo;
        this.classNo = classNo;
        System.out.println("A New Classroom has been created!");
    }

    public int getClassNo() {
        return classNo;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void enter(Student student) {
        students.add(student);
        student.setInClass(true);
        System.out.println(student.getName() + " enters Classroom! No:" + classNo);
    }

    public Student exit() {
        System.out.println(students.get(0).getName() + " exits Classroom!");
        students.get(0).setInClass(false);
        return students.remove(0);
    }

    public void place(Teacher teacher) {
        teachers.add(teacher);
        teacher.setInClass(true);
        System.out.println(teacher.getName() + " is placed in Classroom! No: " + classNo);
    }

    public void teacher_out() {
        teachers.get(0).setInClass(false);
        System.out.println(teachers.get(0).getName() + " floorNo:" + teachers.get(0).getFloorNo() +
                " classNo:" + teachers.get(0).getClassNo() + " teacher is out!");
        teachers.remove(0);
    }

    public void operate(int N) {
        teachers.get(0).teach(N);
        for (int i = 0; i < students.size(); i++) {
            students.get(i).attend(N);
        }
    }

    public void print() {
        System.out.println("People in Classroom " + classNo + " are:");
        for (int i = 0; i < students.size(); i++) {
            students.get(i).print();
        }
        teachers.get(0).print();
    }
}
