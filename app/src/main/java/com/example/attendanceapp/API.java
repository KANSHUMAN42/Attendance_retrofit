package com.example.attendanceapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    String base_url="services.intellify.in";

    @GET("api/Attendance?for=AllClassAttendance")

     Call<String> getattendance();


}
