package com.example.jack.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.example.jack.retrofit.adapter.AdapterRecyclerview;
import com.example.jack.retrofit.model.Hero;
import com.example.jack.retrofit.model.MyResult;
import com.example.jack.retrofit.model.RestResponse;
import com.example.jack.retrofit.services.ApiClient;
import com.example.jack.retrofit.services.ApiInterface;
import com.example.jack.retrofit.services.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

//    RecyclerView rvEmployees;
//    EmployeeListAdapter employeeListAdapter;
//    ProgressBar progress;
//    // Declare
//    ApiInterface apiInterface;
//
//    //Declare
//    List<Employee> employees;
//
//
//    // Constants
//    public static final String DATA = "data";
//    public static final int REQUEST_UPDATE = 1;

    RecyclerView recyclerView;
    AdapterRecyclerview adapterRecyclerview;
    ApiInterface apiInterface;
    List<MyResult> heroes;
    Button btnResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.review);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        apiInterface = ApiUtils.getAPIService();

        btnResponse = (Button) findViewById(R.id.btnResponse);

        btnResponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fetchAllHeros();
            }
        });




    }

    private void fetchAllHeros()
    {
        Call<Hero> callhero = apiInterface.getAllHero();

        callhero.enqueue(new Callback<Hero>() {
            @Override
            public void onResponse(Call<Hero> call, Response<Hero> response) {

                heroes = response.body().getRestResponse().getResult();

                adapterRecyclerview = new AdapterRecyclerview(heroes,getApplicationContext());

                recyclerView.setAdapter(adapterRecyclerview);

            }

            @Override
            public void onFailure(Call<Hero> call, Throwable t)
            {
                Toast.makeText(getApplicationContext(),""+t,Toast.LENGTH_SHORT).show();
                Log.d("Post MyResult Failure", "Unable to get MyResult."+call.request().body());
                Log.d("Generated Url", call.request().url().toString());

            }
        });



    }
}
