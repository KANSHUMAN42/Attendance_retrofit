package com.example.attendanceapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String msg = "here";
     private itemadapter itemadapter ;
     private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=findViewById(R.id.attendacelist);
        fetchjson();



    }
    private  void fetchjson(){

        Retrofit  retrofit=new Retrofit.Builder()
                .baseUrl(API.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api=retrofit.create(API.class);
        Call<String> call=api.getattendance();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("respomdig",response.body().toString());
                if(response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onsuccess",response.body().toString());
                        String jsonresponse=response.body().toString();
                        writeresponse(jsonresponse);

                    }
                    else{
                        Log.i("on empty response","return empty response");
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
    //start from here
private void writeresponse(String response){
        try {
        //getting the whole json object from the response
        JSONObject obj = new JSONObject(response);
        if(obj.optString("message").equals("success")){

            ArrayList<Attendance> modelRecyclerArrayList = new ArrayList<>();
            JSONArray dataArray  = obj.getJSONArray("data");

            for (int i = 0; i < dataArray.length(); i++) {

                Attendance attendance = new Attendance();
                JSONObject dataobj = dataArray.getJSONObject(i);

                attendance.setClassName(dataobj.getString("ClassName"));
                attendance.setPresent(dataobj.getString("present"));
                attendance.setAbsent(dataobj.getString("absent"));
                attendance.setLate(dataobj.getString("late"));
                attendance.setSick(dataobj.getString("sick"));
                attendance.setTotalLectures(dataobj.getString("TotalLectures"));

                modelRecyclerArrayList.add(attendance);

            }

            itemadapter  = new itemadapter (this,modelRecyclerArrayList);
            recyclerView.setAdapter(itemadapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));

        }else {
            Toast.makeText(MainActivity.this, obj.optString("message")+"", Toast.LENGTH_SHORT).show();
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }

}


}



 //end in here
