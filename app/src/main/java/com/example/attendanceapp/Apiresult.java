package com.example.attendanceapp;

import java.util.ArrayList;
import java.util.List;

public class Apiresult {

    private String message;
    private ArrayList<Attendance>attendance;


    public Apiresult(String message, List<Attendance> attendance) {
        this.message = message;
        this.attendance = (ArrayList<Attendance>) attendance;
    }

    public ArrayList<Attendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<Attendance> attendance) {
        this.attendance = (ArrayList<Attendance>) attendance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
