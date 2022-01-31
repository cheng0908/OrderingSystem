package JavaFinalReport;

public class Employee {
    /**
     * 成員屬性:ID、姓名、職務、請假天數、基本工資
     */
    private String ID;
    private String name1;
    private String job;
    private String name2;

    /**
     * get和set方法
     */
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public String getName1() {
        return name1;
    }
    public void setName1(String name1) {
        this.name1 = name1;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public String getName2() {
        return name2;
    }
    public void setName2(String name2) {
        this.name2 = name2;
    }

    /**
     * toString()方法
     */
    public String toString() {
        return "編號：" + ID + ", 姓名：" + name1 + ", 級別" + job + ", 上級姓名：" + name2;
    }
}