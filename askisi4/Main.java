package askisi4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;
import java.util.Vector;
import askisi4.people.*;
import askisi4.spaces.*;

public class Main {
    public static void main(String[] args) {
        int Cclass = Integer.parseInt(args[0]);
        Junior.Lj = Integer.parseInt(args[1]);
        Senior.Ls = Integer.parseInt(args[2]);
        Teacher.Lt = Integer.parseInt(args[3]);
        int N = Integer.parseInt(args[4]);
        String[] names = new String[600];
        File file = new File("askisi4/names.txt"); //txt of names
        int teachcnt = 0; //Total number of teachers
        int studcnt = (Cclass) * 18; //Total number of students
        int floorNo = 1; //Assisting variable

        //////////Creation of School//////////
        School school = new School(Cclass);

        //////////Creation of names array//////////
        try {
            Scanner scanner = new Scanner(file); //Create new Scanner object to read data
            for(int i = 0; i < 600; i++) {
                names[i] = scanner.nextLine(); //Read the lines one by one
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //////////Creation of teachers//////////
        Vector<Teacher> teachers = new Vector<>(18);
        while(teachcnt < 18) {
            for(int classNo = 1; classNo <= 6; classNo++) {
                Teacher t = new Teacher(names[teachcnt], floorNo, classNo, false);
                teachers.add(t);
                teachcnt++;
            }
            if(teachcnt % 6 == 0) { //For every 6 teachers move up one floor
                floorNo++;
            }
        }
        floorNo = 1; //Floor number equals again 1 to properly create students
        System.out.print("\n");

        //////////Creation of students//////////
        Vector<Student> students = new Vector<>(studcnt);
        for(int i = 0; i < studcnt; ) {
            for(int classNo = 1; classNo <= 3; classNo++) { //Classes 1-3 are for Juniors
                Student junior = new Junior(names[i+18], floorNo, classNo, false);
                students.add(junior);
                i++;
            }
            for(int classNo = 4; classNo <=6; classNo++) { //Classes 4-6 are for Seniors
                Student senior = new Senior(names[i+18], floorNo, classNo, false);
                students.add(senior);
                i++;
            }
            floorNo++;
            if(floorNo == 4) floorNo = 1;
        }
        System.out.print("\n");

        //////////Shuffle students//////////
        Collections.shuffle(students);

        //////////Shuffle teachers//////////
        Collections.shuffle(teachers);

        //////////Enter students/place teachers//////////
        for(int i = 0; i < studcnt; i++) {
            school.enter(students.get(i));
            if(i < teachcnt) {
                school.place(teachers.get(i));
            }
        }

        //////////School operating//////////
        school.operate(N);

        //////////School print//////////
        school.print();

        //////////School evacuation//////////
        school.empty();
    }
}
