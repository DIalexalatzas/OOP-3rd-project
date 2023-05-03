package askisi4.spaces;
import askisi4.people.*;
public class Floor extends Operating {
    private final int floorNo;
    private final Corridor corridor;
    private final Classroom[] classes = new Classroom[6];

    public Floor(int Cclass, int floorNo) {
        super(Cclass);
        this.floorNo = floorNo;
        corridor = new Corridor();
        for (int i = 0; i < 6; i++) {
            classes[i] = new Classroom(Cclass, floorNo, (i + 1)); //classes[0] is classroom no:1
        }
        System.out.println("A New Floor has been created!");
    }

    public void enter(Student student) {
        System.out.println(student.getName() + " enters Floor!");
        corridor.enter(student);
        for (int i = 0; i < 6; i++) {
            if (student.getClassNo() == (i + 1)) {
                classes[i].enter(corridor.exit(student));
            }
        }
    }

    public Student exit(int classNo) {
        System.out.println(classes[classNo].students.get(0).getName() + " starts exiting!");
        corridor.enter(classes[classNo].exit());
        return corridor.exit(corridor.students.get(0));
    }

    public void place(Teacher teacher) {
        System.out.println(teacher.getName() + " is placed in Floor! No: " + floorNo);
        int classNo = teacher.getClassNo();
        classes[classNo - 1].place(teacher); //classes[0] == classNo: 1
    }

    public void teachers_out() {
        for (int i = 0; i < 6; i++) {
            classes[i].teacher_out();
        }
    }

    public void operate(int N) {
        for (int i = 0; i < 6; i++) {
            classes[i].operate(N);
        }
    }

    public void print() {
        System.out.println("Floor number: " + floorNo + " contains:");
        for (int i = 0; i < 6; i++) {
            classes[i].print();
        }
    }
}
