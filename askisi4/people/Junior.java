package askisi4.people;

public class Junior extends Student {
    public static int Lj = 0;

    public Junior(String name, int floorNo, int classNo, boolean inClass) {
        super(name, floorNo, classNo, inClass);
        System.out.println("A New Student has been created! " + name + "\nfloorNo: " + floorNo + " classNo: " + classNo);
    }

    public void attend(int N) {
        fatigue += (Lj) * N;
    }
}