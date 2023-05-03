package askisi4.spaces;
import askisi4.people.*;
public class School extends Operating {
    private final Yard yard;
    private final Stairs stairs;
    private final Floor[] floors = new Floor[3];
    private int studcnt = Cclass * 18;

    public School(int Cclass) {
        super(Cclass);
        yard = new Yard();
        stairs = new Stairs();
        for (int i = 0; i < 3; i++) {
            floors[i] = new Floor(Cclass, (i + 1)); //floors[0] has floorNo = 1
        }
        System.out.println("A New School has been created!\n");
    }

    public void enter(Student student) {
        System.out.println(student.getName() + " enters School!");
        yard.enter(student);
        stairs.enter(yard.exit(student));
        for (int i = 0; i < 3; i++) {
            if (student.getFloorNo() == (i + 1)) {
                floors[i].enter(stairs.exit(student));
            }
        }
    }

    public void empty() {
        while (studcnt > 0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 6; j++) {
                    stairs.enter(floors[i].exit(j));
                    yard.enter(stairs.exit(stairs.students.get(0)));
                    yard.exit(yard.students.get(0));
                    studcnt--;
                }
            }
        }
        System.out.print("\n");
        for (int t = 0; t < 3; t++) {
            floors[t].teachers_out();
        }
    }

    public void place(Teacher teacher) {
        System.out.println(teacher.getName() + " is placed in School!");
        int floorNo = teacher.getFloorNo();
        floors[floorNo - 1].place(teacher); //floors[0] has floorNo = 1
    }

    public void operate(int N) {
        for (int i = 0; i < 3; i++) {
            floors[i].operate(N);
        }
    }

    public void print() {
        System.out.println("\nSchool life consists of: ");
        for (int i = 0; i < 3; i++) {
            floors[i].print();
        }
    }
}
