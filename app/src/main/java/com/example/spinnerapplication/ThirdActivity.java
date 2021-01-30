package com.example.spinnerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThirdActivity extends AppCompatActivity {

    /**************  Intialize Variables *************/
    public ArrayList<CompanyBegin> companyList =new ArrayList<>();
    TextView output = null;
    ThirdAdapter adapter;
    ThirdActivity activity = null;
    Spinner SpinnerExample;
    int companyId=0;
    String Company="",CompanySlogan="",companyPhoto="",lastMod="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        activity  = this;
        SpinnerExample = (Spinner)findViewById(R.id.spinner);
        output = (TextView)findViewById(R.id.output);
        loadCompanyData();



        // Set data in arraylist




    }
    public void loadCompanyData() {

//            if(courseAdapter !=null){
//                courseAdapter.clear();
//            }

        /*
         * Creating a String Request
         * The request type is GET defined by first parameter
         * The URL is defined in the second parameter
         * Then we have a Response Listener and a Error Listener
         * In response listener we will get the JSON response as a String
         *Please note that the url can be customized according to your prference
         * */
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.43.149/MySales/MyApi.php?apicall=companylist",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {


                            JSONArray array = new JSONArray(response);
                            //initializing the courselist
                            companyList.add(new CompanyBegin(
                                    0,
                                    null,
                                    null,
                                    null,
                                    null,
                                    null
                            ));

                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject company = array.getJSONObject(i);


                                //adding the product to product list
                                companyList.add(new CompanyBegin(
                                        company.getInt("company_id"),
                                        company.getString("company_name"),
                                        company.getString("company_slogan"),
                                        company.getString("photo"),
                                        company.getString("company_no"),
                                        company.getString("photo_lastmod")
                                ));
                                Log.e("Response",""+companyList);
                                Log.e("Response 1",""+response);
                                // Create custom adapter object ( see below BeginCompanyAdapter.java )


                            }
                            adapter = new ThirdAdapter(activity, R.layout.spinner_rows, companyList);

                            // Set adapter to spinner
                            SpinnerExample.setAdapter(adapter);

                            // Listener called when spinner item selected
                            SpinnerExample.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parentView, View v, int position, long id) {

                                    // Get selected row data to show on screen
                                    Company = ((TextView) v.findViewById(R.id.company)).getText().toString();
                                    CompanySlogan = ((TextView) v.findViewById(R.id.sub)).getText().toString();
                                    if(companyList!=null){

                                        companyId= companyList.get(position).getCompanyId();
                                        companyPhoto=companyList.get(position).getPhoto();
                                        lastMod=companyList.get(position).getPhotolastmod();

                                    }

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parentView) {
                                    // your code here
                                }

                            });





                        } catch (JSONException e) {
//                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("reason", "login");
                return params;

            }
        };

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);


    }

}
