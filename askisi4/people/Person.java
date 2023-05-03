package askisi4.people;

public abstract class Person {
    protected String name;
    protected int floorNo;
    protected int classNo;
    protected boolean inClass;
    protected int fatigue = 0;

    protected Person(String name, int floorNo, int classNo, boolean inClass) {
        this.name = name;
        this.floorNo = floorNo;
        this.classNo = classNo;
        this.inClass = inClass;
    }

    public String getName() {
        return name;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public int getClassNo() {
        return classNo;
    }

    public boolean getInClass() {
        return inClass;
    }

    public int getFatigue() {
        return fatigue;
    }

    public void setInClass(boolean in) {
        inClass = in;
    }

    abstract void print();
}
