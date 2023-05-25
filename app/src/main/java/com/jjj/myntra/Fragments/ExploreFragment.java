package com.jjj.myntra.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jjj.myntra.ModelClass.Modalclass;
import com.jjj.myntra.R;
import com.jjj.myntra.RecyclerAdapters.RecyclerAdapter_Explore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ExploreFragment extends Fragment {

    ArrayList<Modalclass> arrayListexplore;
    RequestQueue requestQueue;

    RecyclerAdapter_Explore adapterExplore;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        recyclerView = view.findViewById(R.id.recycler_explore);

        requestQueue= Volley.newRequestQueue(getContext());
        arrayListexplore=new ArrayList<>();

        StringRequest stringRequestexplore=new StringRequest(Request.Method.GET, "http://api.karanvarma.link/Webservice1.asmx/exploreapi", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray=new JSONArray(response);

                    for (int i=0;i<jsonArray.length();i++){

                        Modalclass modalclass=new Modalclass();
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        String name=jsonObject.getString("ename");
                        modalclass.setName(name);

                        String img="http://api.karanvarma.link/upload/"+jsonObject.getString("eimg");
                        modalclass.setImg(img);
                        arrayListexplore.add(modalclass);
                        // For Recycler View First

                        adapterExplore=new RecyclerAdapter_Explore(getContext(),arrayListexplore);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                        recyclerView.setAdapter(adapterExplore);

                        // Click listener
                        /*adapter_top.onitemclicklistener(new Recyclerclicklistener() {
                            @Override
                            public void onclick(int pos) {

                                SubHomeFragment subHomeFragment=new SubHomeFragment();
                                Bundle bundle=new Bundle();
                                bundle.putString("key",""+pos);
                                subHomeFragment.setArguments(bundle);
                                getFragmentManager().beginTransaction().replace(R.id.hide_container,subHomeFragment).addToBackStack(null).commit();

                            }
                        });*/

                    }

                }catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequestexplore);


        return view;
    }
}