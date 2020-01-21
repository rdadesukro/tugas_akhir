package com.example.tugas_akhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tugas_akhir.model.Response_tugas;
import com.example.tugas_akhir.model.ResultItem_tugas;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecycler;
    private RecyclerView.LayoutManager mManager,manager;
    private List<ResultItem_tugas> data = new ArrayList<>();
    adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mRecycler = (RecyclerView) findViewById(R.id.rv);
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swifeRefresh);



     data();








        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                get_data();
            }
        });

    }


    public void get_data() {

        ApiRequest api = Retroserver.getClient().create(ApiRequest.class);
        Call<Response_tugas> call = api.tugas();


        call.enqueue(new Callback<Response_tugas>() {
            @Override
            public void onResponse(Call<Response_tugas> call, Response<Response_tugas> response) {

                try {

                    data = response.body().getResult();
                    adapter = new adapter(MainActivity.this,data,"","","");
                    mRecycler.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                    mSwipeRefreshLayout.setRefreshing(false);

                    Log.i("cek_data", "onResponse: "+data.size());



                } catch (Exception e) {
                    Log.e("onResponse", "There is an error"+e);

                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Response_tugas> call, Throwable t) {
                t.printStackTrace();


            }
        });
    }

    public void data() {


      
         
            mRecycler = (RecyclerView) findViewById(R.id.rv);
            mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            manager = new LinearLayoutManager(this);
            mRecycler.setLayoutManager(mManager);
            mRecycler.setHasFixedSize(true);
            get_data();
          
       
       

    }


}
