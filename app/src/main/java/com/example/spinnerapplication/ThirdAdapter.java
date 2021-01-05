package com.example.spinnerapplication;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.MediaStoreSignature;

import java.util.ArrayList;

/***** Adapter class extends with ArrayAdapter ******/
class ThirdAdapter extends ArrayAdapter<String> {

    private Activity activity;
    public ArrayList<CompanyBegin> companyList;
    CompanyBegin tempValues=null;
    LayoutInflater inflater;

    /*************  CustomAdapter Constructor *****************/
    public ThirdAdapter(
            ThirdActivity activitySpinner,
            int textViewResourceId,
            ArrayList objects
    )
    {
        super(activitySpinner, textViewResourceId, objects);

        /********** Take passed values **********/
        activity = activitySpinner;
        companyList    = objects;
        Log.e("Objects",""+objects);
        Log.e("Companylist",""+companyList);

        /***********  Layout inflator to call external xml layout () **********************/
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // This funtion called for each row ( Called data.size() times )
    public View getCustomView(int position, View convertView, ViewGroup parent) {

        /********** Inflate spinner_rows.xml file for each row ( Defined below ) ************/
        View row = inflater.inflate(R.layout.spinner_rows, parent, false);

        /***** Get each Model object from Arraylist ********/
        tempValues = null;
        tempValues = (CompanyBegin) companyList.get(position);

        TextView label        = (TextView)row.findViewById(R.id.company);
        TextView sub          = (TextView)row.findViewById(R.id.sub);
        ImageView companyLogo = (ImageView)row.findViewById(R.id.image);

        if(position==0){

            // Default selected Spinner item
            label.setText("Please select company");
            sub.setText("");
            Log.e("Here 1","here 1");
        }
        else
        {
            // Set values for spinner each row
            label.setText(tempValues.getCompanyName());
            sub.setText(tempValues.getSlogan());
            Log.e("Here 2","here 2");


            String img="http://192.168.43.149/MySales/uploads/settings/logo.png";
            Long time=System.currentTimeMillis();
            Glide.with(getContext()).load(img).signature(new MediaStoreSignature(img,time,0)).into(companyLogo);


        }

        return row;
    }
}
