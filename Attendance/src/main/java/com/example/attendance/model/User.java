package com.example.attendance.model;

public class User {

    private Integer id;  // SERIAL 自動採番用
    private String name;
    private String unit;

    // ===== getter / setter =====
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
