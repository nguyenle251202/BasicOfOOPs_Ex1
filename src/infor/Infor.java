package infor;

import java.util.Date;

public class Infor {
    private int Id;
    private String Name;
    private Date Birthday;
    private float GPA;

    public Infor(int id, String name, Date birthday, float GPA) {
        Id = id;
        Name = name;
        Birthday = birthday;
        this.GPA = GPA;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Infor{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Birthday=" + Birthday +
                ", GPA=" + GPA +
                '}';
    }
}
