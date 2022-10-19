package com.example.api;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
        APIinterface apIinterface;
        RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle1);
        apIinterface = RetrofitInstance.getRetrofit().create(APIinterface.class);
        apIinterface.getpost().enqueue(new Callback<List<postpojo>>() {
            @Override
            public void onResponse(Call<List<postpojo>> call, Response<List<postpojo>> response) {
                if(response.body().size()>0){
                    Toast.makeText(MainActivity.this, "LIST IS NOT EMPTY", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MainActivity.this, "LIST IS EMPTY", Toast.LENGTH_SHORT).show();
                }
                
            }

            @Override
            public void onFailure(Call<List<postpojo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "t.getLocalizedMessage", Toast.LENGTH_LONG).show();

            }
        });
    }
}