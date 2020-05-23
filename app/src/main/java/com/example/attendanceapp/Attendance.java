package com.example.attendanceapp;

public class Attendance {
    private String absent;
    private String className;
    private String totalLectures;
    private String present;
    private String sick;
    private String late;

    public Attendance() {
        this.className = className;
        this.totalLectures = totalLectures;
        this.present = present;
        this.absent=absent;
        this.sick = sick;
        this.late = late;
    }


    public String getLate() {
        return late;
    }
    public String setAbsent(String absent){
        return absent;
    }

    public void setLate(String late) {
        this.late = late;
    }

    public String getSick() {
        return sick;
    }

    public void setSick(String sick) {
        this.sick = sick;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getTotalLectures() {
        return totalLectures;
    }

    public void setTotalLectures(String totalLectures) {
        this.totalLectures = totalLectures;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAbsent() {
        return absent;
    }
}
