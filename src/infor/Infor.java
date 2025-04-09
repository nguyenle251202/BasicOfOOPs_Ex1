package infor;

import java.util.concurrent.atomic.AtomicInteger;

public class Infor {

    private static final AtomicInteger idCounter = new AtomicInteger(1);

    private String id;
    private String fullName;
    private int age;
    private float gpa;

    public Infor(String id, String fullName, int age, float gpa) {
        this.id = String.format("SV%03d", idCounter.getAndIncrement());
        this.fullName = fullName;
        this.age = age;
        this.gpa = gpa;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public float getGpa() {
        return gpa;
    }

    //Setters
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    //toString

    @Override
    public String toString() {
        return "Infor{" +
                "id='" + id + '\'' +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                '}';
    }


}
