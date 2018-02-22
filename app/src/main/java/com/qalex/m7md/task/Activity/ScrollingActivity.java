package com.qalex.m7md.task.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.qalex.m7md.task.Adapter.SetAdapter;
import com.qalex.m7md.task.Storage.SharedPreferenceUtilities;
import com.qalex.m7md.task.rest.ApiClient;
import com.qalex.m7md.task.rest.ApiInterface;
import com.qalex.m7md.task.R;
import com.qalex.m7md.task.Model.User;
import com.qalex.m7md.task.rest.InternetConnection;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScrollingActivity extends AppCompatActivity {


    private Boolean more = false, DataAvailable = true;
    private RecyclerView mrecyclerView;
    private SetAdapter adapter;

    private final static int ID = 0;
    private final static int per_page = 10;

    private List<User> dataArrayList = null;
    private List<User> newArrayList = null;

    private ApiInterface apiService;

    private SharedPreferenceUtilities myPrefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mrecyclerView=(RecyclerView) findViewById(R.id.user_recycler_view);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
      //  new LinearLayoutManager(getApplicationContext())


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "No action ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        myPrefs = new SharedPreferenceUtilities(getApplicationContext());
        adapter = new SetAdapter(getApplicationContext());
        dataArrayList = new ArrayList<>();
        dataArrayList.clear();
        newArrayList = new ArrayList<>();
//////////////////////////////////////// NetWork Connection Test /////////////////////
        if (InternetConnection.checkConnection(getBaseContext())) {
            callingAPI(ID);
        } else {
            Toast.makeText(getBaseContext(),"No Internet Connection ...", Toast.LENGTH_SHORT).show();
            Toast.makeText(getBaseContext(),"Load Cached Data ...", Toast.LENGTH_SHORT).show();
            dataArrayList = myPrefs.LoadSharedData();
            adapter.setAdapterToDisplay(dataArrayList,mrecyclerView);
        }

///////////////////////////////////////////////////////

    }

    private void callingAPI(final int ID) {

        apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<User>> call = apiService.getUser(ID,per_page);

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>>call, Response<List<User>> response) {

               if(more == true){

                   newArrayList = response.body();

                   if(newArrayList.size()>0 || newArrayList == null){
                       //add loaded data
                       dataArrayList.addAll(newArrayList);
                   }else{//result size 0 means there is no more data available at server
                       DataAvailable = false;
                       //telling adapter to stop calling load more as no more server data available
                       Toast.makeText(getBaseContext(),"No More Data Available",Toast.LENGTH_LONG).show();
                   }

                   // userAdapter.notifyDataSetChanged();
                }
                else
                   dataArrayList = response.body();
                //   myPrefs.saveUsers(dataArrayList);

                adapter.setAdapterToDisplay(dataArrayList,mrecyclerView);
                //  Toast.makeText(getBaseContext(),"he  "+dataArrayList, Toast.LENGTH_LONG).show();

               myPrefs.saveUsers(dataArrayList);


         mrecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
                {

                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx,int dy)
                    {
                        super.onScrolled(recyclerView, dx, dy);
                        LinearLayoutManager layoutManager=LinearLayoutManager.class.cast(recyclerView.getLayoutManager());
                        int visibleItemCount        = layoutManager.getChildCount();
                        int totalItemCount          = layoutManager.getItemCount();
                        int firstVisibleItemPosition= layoutManager.findFirstVisibleItemPosition();

                        // Load more if we have reach the end to the recyclerView
                        if (DataAvailable==true && (visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0) {
                         int inc = ID + 10;
                         callingAPI(inc);
                            more = true;
                        //   Toast.makeText(getBaseContext(),"Load more Data "+dx+" - " + dy, Toast.LENGTH_SHORT).show();

                        }

                    }

                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView,int newState)
                    {

                    }
                });

            }

            @Override
            public void onFailure(Call<List<User>>call, Throwable t) {


                Toast.makeText(getBaseContext(),"Fail to connect to API ...", Toast.LENGTH_SHORT).show();
                Toast.makeText(getBaseContext(),"Load Cached Data ...", Toast.LENGTH_SHORT).show();

               dataArrayList = myPrefs.LoadSharedData();
               adapter.setAdapterToDisplay(dataArrayList,mrecyclerView);
;
            }
        });
    }

}
