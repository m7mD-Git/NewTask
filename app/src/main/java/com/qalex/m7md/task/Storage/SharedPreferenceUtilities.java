package com.qalex.m7md.task.Storage;

import java.lang.reflect.Type;
import java.util.List;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qalex.m7md.task.Model.User;

/**
 * Created by m7md on 22/02/18.
 */
public class SharedPreferenceUtilities {

    public static final String PREFS_NAME = "myPrefs";
    private SharedPreferences sharedData;
    private SharedPreferences.Editor editor;
    private List<User> list_User_Cached=null;
    private Gson gson;
    private Context context;
    private Type listOfObjects;
    private String json = "";

    public SharedPreferenceUtilities(Context context) {

        this.context = context;
        sharedData = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = sharedData.edit();
        gson = new Gson();

    }

    public void saveUsers( List<User> userData) {

        json = gson.toJson(userData);
        editor.putString("User", json);
        editor.commit();

    }
    public List<User> LoadSharedData() {

        listOfObjects = new TypeToken<List<User>>(){}.getType();
        json = sharedData.getString("User","");
        list_User_Cached = gson.fromJson(json, listOfObjects);

        return list_User_Cached;
    }

}
