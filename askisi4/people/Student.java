package askisi4.people;

public abstract class Student extends Person {
    protected Student(String name, int floorNo, int classNo, boolean inClass) {
        super(name, floorNo, classNo, inClass);
    }

    public void print() {
        System.out.println(name + " Fatigue: " + fatigue);
    }

    public abstract void attend(int N);
}
