package com.chernikin.webapp.domain;

public class Cpu {

    private int id;
    private String cpuName;

    public Cpu() {
    }

    public Cpu(int id, String cpuName) {
        this.id = id;
        this.cpuName = cpuName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "id=" + id +
                ", cpuName='" + cpuName + '\'' +
                '}';
    }
}
