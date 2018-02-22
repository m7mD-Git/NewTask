package com.qalex.m7md.task.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.qalex.m7md.task.Model.User;
import com.qalex.m7md.task.R;

import java.util.List;

/**
 * Created by m7md on 22/02/18.
 */
public class SetAdapter {

    private Context context;
    private UserAdapter userAdapter;

    public SetAdapter(Context context){

        this.context = context;
    }


    public void setAdapterToDisplay(List<User> userData, RecyclerView recyclerView){

        userAdapter=new UserAdapter(userData, R.layout.list_item_user,context);
        recyclerView.setAdapter(userAdapter);

    }
}
