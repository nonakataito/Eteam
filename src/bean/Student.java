package bean;

public class Student {
    private String no;
    private String name;
    private int enterYear;
    private boolean isAttend;
    private School school;
    private ClassNum classNum;

    // Getter / Setter 省略せずに実装
    public String getNo() { return no; }
    public void setNo(String no) { this.no = no; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getEnterYear() { return enterYear; }
    public void setEnterYear(int enterYear) { this.enterYear = enterYear; }

    public boolean isAttend() { return isAttend; }
    public void setAttend(boolean isAttend) { this.isAttend = isAttend; }

    public School getSchool() { return school; }
    public void setSchool(School school) { this.school = school; }

    public ClassNum getClassNum() { return classNum; }
    public void setClassNum(ClassNum classNum) { this.classNum = classNum; }
}
