package com.qalex.m7md.task.rest;

/**
 * Created by m7md on 19/02/18.
 */

import com.qalex.m7md.task.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("users")

    Call<List<User>> getUser(@Query("since") int id);

}

