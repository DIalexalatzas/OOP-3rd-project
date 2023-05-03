package askisi4.people;

public class Teacher extends Person {
    public static int Lt = 0;

    public Teacher(String name, int floorNo, int classNo, boolean inClass) {
        super(name, floorNo, classNo, inClass);
        System.out.println("A New Teacher has been created! " + name + "\nfloorNo: " + floorNo + " classNo: " + classNo);
    }

    public void print() {
        System.out.println("The teacher is: " + name + " Fatigue: " + fatigue + "\n");
    }

    public void teach(int N) {
        fatigue += (Lt) * N;
    }
}
