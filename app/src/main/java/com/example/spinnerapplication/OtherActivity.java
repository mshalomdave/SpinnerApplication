package com.example.spinnerapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OtherActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private int spinnerPosition=-1;


    Spinner spinner;

    private static String userCategory;
    private static String userC;

    //a list to store all the users


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        //getting current user


        //Getting User Categories

        //getting the recyclerview from xml


        String[] data = {"Administrators", "Marketeers"};

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.android_spinner, data);
        adapter.setDropDownViewResource(R.layout.android_spinner_dropdown);
        spinner = findViewById(R.id.spinner);
        //this method will fetch and parse json
        //to display it in recyclerview
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(UsersActivity.this,parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                if (spinnerPosition != position) {
                    spinnerPosition=position;
                    userCategory = parent.getItemAtPosition(position).toString();


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // Set default selection for spinner
        int defaultState = -1;

        if (defaultState == -1)
        {
            defaultState = 0;
        }

        spinner.setSelection(defaultState,false);


    }







}


