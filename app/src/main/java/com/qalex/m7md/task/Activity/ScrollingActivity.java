package com.qalex.m7md.task.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.qalex.m7md.task.rest.ApiClient;
import com.qalex.m7md.task.rest.ApiInterface;
import com.qalex.m7md.task.R;
import com.qalex.m7md.task.Model.User;
import com.qalex.m7md.task.Adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScrollingActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    private final static int ID = 0;

    private List<User> dataArrayList;

   ApiInterface apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView=(RecyclerView) findViewById(R.id.user_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "No action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        apiService = ApiClient.getClient().create(ApiInterface.class);

         callingAPI(ID);


    }

    private void callingAPI(int ID) {

        Call<List<User>> call = apiService.getUser(ID);
        dataArrayList = new ArrayList<>();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>>call, Response<List<User>> response) {

                dataArrayList = response.body();
                userAdapter=new UserAdapter(dataArrayList,R.layout.list_item_user,getApplicationContext());
                recyclerView.setAdapter(userAdapter);
                    Toast.makeText(getBaseContext(),"he  "+dataArrayList.get(1).getLogIn(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<User>>call, Throwable t) {
                // Log error here since request failed
                Log.e("tag", t.toString());
                //Toast.makeText(getBaseContext(),t.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
