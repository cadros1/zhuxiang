package top.cadros.object;

/**
 * 此类封装了学生信息
 * 
 * @param id 在数据库中的ID
 * @param name 学生姓名
 * @param studentID 学号
 * @param academy 学院
 */
public class Student implements java.io.Serializable{
    private int id;
    private String name;
    private String studentID;
    private int academy;

    public Student(String name,String studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    public Student(String name,String studentID,int academy) {
        this.name = name;
        this.studentID = studentID;
        this.academy = academy;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getStudentID() {
        return this.studentID;
    }

    public int getAcademy() {
        return this.academy;
    }
}
