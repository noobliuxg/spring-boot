package com.java.springboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "TEACHER")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="TEA_NAME")
    private String teaName;

    @Column(name = "TEA_AGE")
    private int teaAge;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public int getTeaAge() {
        return teaAge;
    }

    public void setTeaAge(int teaAge) {
        this.teaAge = teaAge;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teaName='" + teaName + '\'' +
                ", teaAge=" + teaAge +
                '}';
    }
}
