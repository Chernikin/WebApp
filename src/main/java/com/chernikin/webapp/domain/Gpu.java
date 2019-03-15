package com.chernikin.webapp.domain;

public class Gpu {

    private int id;
    private String gpuName;

    public Gpu() {
    }

    public Gpu(int id, String gpuName) {
        this.id = id;
        this.gpuName = gpuName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGpuName() {
        return gpuName;
    }

    public void setGpuName(String gpuName) {
        this.gpuName = gpuName;
    }

    @Override
    public String toString() {
        return "Gpu{" +
                "id=" + id +
                ", gpuName='" + gpuName + '\'' +
                '}';
    }
}
