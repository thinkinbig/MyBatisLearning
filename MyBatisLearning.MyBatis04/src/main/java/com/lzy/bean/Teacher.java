package com.lzy.bean;

public class Teacher {
    private int tid;
    private String name;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher(int tid, String name) {
        this.tid = tid;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                '}';
    }
}
