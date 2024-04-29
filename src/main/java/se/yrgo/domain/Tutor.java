package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tutorId;
    private String name;
    private int salaray;
    @OneToMany
    private List<Student> teachingGroup;

    public Tutor() {
    }

    public Tutor(String tutorId, String name, int salaray) {
        this.tutorId = tutorId;
        this.name = name;
        this.salaray = salaray;
        this.teachingGroup = new ArrayList<>();
    }

    public void addStudentToTeachingGroup(Student newStudent) {
        this.teachingGroup.add(newStudent);
    }

    public List<Student> getTeachingGroup() {
        List<Student> unmodifiable = Collections.unmodifiableList(this.teachingGroup);
        return unmodifiable;
    }

    public String getTutorId() {
        return tutorId;
    }

    public String getName() {
        return name;
    }

    public int getSalaray() {
        return salaray;
    }

    public String toString() {
        return String.format("Tutor ID: %s%nName: %s%nSalaray: %d%n", tutorId, name, salaray);
    }
}
