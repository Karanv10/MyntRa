package com.jjj.myntra.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.jjj.myntra.R;

public class RegisterFragment extends Fragment {

    EditText ed1,ed2,ed3,ed4,ed5;
    CheckBox checkBox;
    TextView already;
    Button btn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        ed1=view.findViewById(R.id.regname);
        ed2=view.findViewById(R.id.regemail);
        ed3=view.findViewById(R.id.regpassword);
        ed4=view.findViewById(R.id.mobile);
        ed5=view.findViewById(R.id.address);
        already=view.findViewById(R.id.alreadyHaveAccount);
        checkBox=view.findViewById(R.id.checkBoxreg);

        btn=view.findViewById(R.id.regbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RequestQueue queue = Volley.newRequestQueue(getContext());

                String name = ed1.getText().toString();
                String email = ed2.getText().toString();
                String pass = ed3.getText().toString();
                String mobile = ed4.getText().toString();
                String address = ed5.getText().toString();

                String url= "http://api.karanvarma.link/Webservice1.asmx/registerapi?n="+name+"&e="+email+"&p="+pass+"&ph="+mobile+"&ad="+address;

                StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getContext(), ""+response, Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

                queue.add(stringRequest);

            }
        });

        //alreadyHaveAccount...

        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                closefragment();

            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkBox.isChecked()){

                    btn.setEnabled(true);

                }
                else {

                    btn.setEnabled(false);
                }
            }
        });


        return view;
    }

    private void closefragment() {
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    }
}