package se.yrgo.domain;

import jakarta.persistence.*;

@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //This line is optional
    private int id;
    private String enrollmentID;
    private String name;
    private String tutorName; // This will become a class soon
    @Column(name="NUM_COURSES")
    private int numberOfCourses;
//    @OneToMany
//    @JoinColumn(name="TUTOR_FK")
//    private Tutor tutor;

    public Student(String name, int numberOfCourses) {
        this.name = name;
        this.numberOfCourses = numberOfCourses;
    }

    public Student(String name, String enrollmentID) {
        this.name = name;
        this.enrollmentID = enrollmentID;
        this.numberOfCourses = 10;
    }

    public Student() {
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getEnrollmentID() {
        return enrollmentID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEnrollmentID(String enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String toString() {
        return String.format("Name: %s%n", name);
    }
}
