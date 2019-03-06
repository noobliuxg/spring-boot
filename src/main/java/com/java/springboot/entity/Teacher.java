package com.java.springboot.entity;

public class Teacher {

    private long id;
    private String teaName;
    private long teaAge;

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

    public long getTeaAge() {
        return teaAge;
    }

    public void setTeaAge(long teaAge) {
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
