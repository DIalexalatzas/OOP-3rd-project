package askisi4.people;

public class Senior extends Student {
    public static int Ls = 0;

    public Senior(String name, int floorNo, int classNo, boolean inClass) {
        super(name, floorNo, classNo, inClass);
        System.out.println("A New Student has been created! " + name + "\nfloorNo: " + floorNo + " classNo: " + classNo);
    }

    public void attend(int N) {
        fatigue += (Ls) * N;
    }
}
