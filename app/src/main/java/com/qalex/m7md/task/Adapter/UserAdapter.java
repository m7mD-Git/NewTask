package com.qalex.m7md.task.Adapter;

/**
 * Created by m7md on 19/02/18.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.qalex.m7md.task.Model.User;
import com.qalex.m7md.task.R;

import java.util.List;
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {



    private List<User> userData;
    private int rowLayout;
    private Context context;


    public static class UserViewHolder extends RecyclerView.ViewHolder {
        LinearLayout userLayoutUserViewHolder;
        TextView logIn;
        ImageView user_img;
        TextView user_ID;



        public UserViewHolder(View v) {
            super(v);
            userLayoutUserViewHolder = (LinearLayout) v.findViewById(R.id.user_layout);
            logIn = (TextView) v.findViewById(R.id.user_name);
            user_img = (ImageView) v.findViewById(R.id.user_image);
            user_ID = (TextView) v.findViewById(R.id.user_id);

        }
    }

    public UserAdapter(List<User> userData, int rowLayout, Context context) {
        this.userData = userData;
        this.rowLayout = rowLayout;
        this.context = context;

    }

    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new UserViewHolder(view);
    }


    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {
        holder.logIn.setText(userData.get(position).getLogIn());
        holder.user_ID.setText(userData.get(position).getId());
        Glide.with(context).load(userData.get(position).getAvatarURL())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.user_img);

        holder.userLayoutUserViewHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("Go To "+userData.get(position).getLogIn()+" WebSite ")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(userData.get(position).getHtmlURL()));
                               v.getContext().startActivity(i);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return userData == null ? 0 : userData.size();
    }


}
