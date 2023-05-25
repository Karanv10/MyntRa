package com.jjj.myntra.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.jjj.myntra.Interface.Recyclerclicklistener;
import com.jjj.myntra.ModelClass.Modalclass;
import com.jjj.myntra.R;
import com.jjj.myntra.RecyclerAdapters.ImageSliderAdaptor;
import com.jjj.myntra.RecyclerAdapters.ImageSliderAdaptor_subhome;
import com.jjj.myntra.RecyclerAdapters.ImageSliderAdaptor_subhome2;
import com.jjj.myntra.RecyclerAdapters.RecyclerAdapterEnd_Subhome;
import com.jjj.myntra.RecyclerAdapters.RecyclerAdapterMid_Subhome;
import com.jjj.myntra.RecyclerAdapters.RecyclerAdapterMid_Subhome2;
import com.jjj.myntra.RecyclerAdapters.RecyclerAdapterMid_Subhome3;
import com.jjj.myntra.RecyclerAdapters.RecyclerAdapterTop_Subhome;
import com.jjj.myntra.RecyclerAdapters.RecyclerAdapterTop_Women;
import com.jjj.myntra.RecyclerAdapters.RecyclerAdapter_Top;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SubHomeFragment extends Fragment {

                                                                 //-------For Women-------//
    RecyclerView rec_top,rec_mid,rec_mid2,rec_mid4,rec_end;
    ViewPager2 viewpager1,viewpager2;
    ImageView gifimg1,img2,gifimg3,gifimg4;
    TextView text1,text2;

    Runnable sliderRunnable,sliderRunnable2;

    private Handler sliderHandler = new Handler();
    private Handler sliderHandler2 = new Handler();

    RecyclerAdapterTop_Subhome adapterTopsubhome;
    RecyclerAdapterMid_Subhome adapterMidSubhome;
    RecyclerAdapterMid_Subhome2 adapterMidSubhome2;
    RecyclerAdapterMid_Subhome3 adapterMidSubhome3;
    RecyclerAdapterEnd_Subhome adapterEndSubhome;

    ArrayList<Modalclass> arrayListtop,arrayListmid,arrayListmid2,arrayListmid3,arrayListend,arrayListslider,arrayListslider2;


                                                                //-------For Women-------//


    RecyclerView rec_topW,rec_midW,rec_midW2,rec_midW4,rec_endW;
    ViewPager2 viewpagerW1,viewpagerW2;
    ImageView gifimgW1,imgW2,gifimgW3,gifimgW4;
    TextView textW1,textW2;

    Runnable sliderRunnableW,sliderRunnableW2;

    private Handler sliderHandlerW = new Handler();
    private Handler sliderHandlerW2 = new Handler();

    RecyclerAdapterTop_Women adapterTopWomen;


    ArrayList<Modalclass> arrayListtopW,arrayListmidW,arrayListmidW2,arrayListmidW3,arrayListendW,arrayListsliderW,arrayListsliderW2;


    RequestQueue requestQueue;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sub_home, container, false);

                                                    //-------For Women-------//

        //Recycler View
        rec_top=view.findViewById(R.id.rectop_subhome);
        rec_mid=view.findViewById(R.id.recmid_subhome);
        rec_mid2=view.findViewById(R.id.recmid2_subhome);
        //rec_mid3=view.findViewById(R.id.recmid3_subhome);
        rec_mid4=view.findViewById(R.id.recmid4_subhome);
        rec_end=view.findViewById(R.id.recend_subhome);

        //Image Slider
        viewpager1=view.findViewById(R.id.slider1_subhome);
        viewpager2=view.findViewById(R.id.slider2_subhome);

        //Image View

        gifimg1=view.findViewById(R.id.imggif1_subhome);
        img2=view.findViewById(R.id.img2_subhome);
        gifimg3=view.findViewById(R.id.imggif3_subhome);
        gifimg4=view.findViewById(R.id.imggif4_subhome);

        //Text View
        text1=view.findViewById(R.id.txt1_subhome);
        text2=view.findViewById(R.id.txt2_subhome);

        requestQueue= Volley.newRequestQueue(getContext());
        arrayListtop=new ArrayList<>();
        arrayListmid=new ArrayList<>();
        arrayListmid2=new ArrayList<>();
        arrayListmid3=new ArrayList<>();
        arrayListend=new ArrayList<>();
        arrayListslider=new ArrayList<>();
        arrayListslider2=new ArrayList<>();


                                                                   //-------For Women-------//

        //Recycler View
        rec_topW=view.findViewById(R.id.rectop_subhome);
        rec_midW=view.findViewById(R.id.recmid_subhome);
        rec_midW2=view.findViewById(R.id.recmid2_subhome);
        //rec_mid3=view.findViewById(R.id.recmid3_subhome);
        rec_midW4=view.findViewById(R.id.recmid4_subhome);
        rec_endW=view.findViewById(R.id.recend_subhome);

        //Image Slider
        viewpagerW1=view.findViewById(R.id.slider1_subhome);
        viewpagerW2=view.findViewById(R.id.slider2_subhome);

        //Image View

        gifimgW1=view.findViewById(R.id.imggif1_subhome);
        imgW2=view.findViewById(R.id.img2_subhome);
        gifimgW3=view.findViewById(R.id.imggif3_subhome);
        gifimgW4=view.findViewById(R.id.imggif4_subhome);

        //Text View
        textW1=view.findViewById(R.id.txt1_subhome);
        textW2=view.findViewById(R.id.txt2_subhome);

        requestQueue= Volley.newRequestQueue(getContext());
        arrayListtopW=new ArrayList<>();
        arrayListmidW=new ArrayList<>();
        arrayListmidW2=new ArrayList<>();
        arrayListmidW3=new ArrayList<>();
        arrayListendW=new ArrayList<>();
        arrayListsliderW=new ArrayList<>();
        arrayListsliderW2=new ArrayList<>();


                                                                             //---Data Men---//

        //Receiving Data From Home Fragment For Men
        Bundle bundle=this.getArguments();
        String cid=bundle.getString("key");

       // int cid1=Integer.parseInt(cid);

       // Toast.makeText(getContext(), ""+cid, Toast.LENGTH_SHORT).show();


        if (cid.equals("1")) {

            //For Recycler View Top
            StringRequest stringRequesttop = new StringRequest(Request.Method.GET, "http://api.karanvarma.link/Webservice1.asmx/mentopapi?id=" + cid, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    Log.d("response", response);
                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        Log.d("response2", response);

                        for (int i = 0; i < jsonArray.length(); i++) {
                            Modalclass modalclass = new Modalclass();
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            String name = jsonObject.getString("mname");
                            String id = jsonObject.getString("id");


                            String img = "http://api.karanvarma.link/upload/" + jsonObject.getString("mimg");
                            // Toast.makeText(getContext(), "gggg"+img, Toast.LENGTH_SHORT).show();
                            modalclass.setName(name);
                            modalclass.setId(id);
                            modalclass.setImg(img);
                            arrayListtop.add(modalclass);
                            // For Recycler View First
                            adapterTopsubhome = new RecyclerAdapterTop_Subhome(getContext(), arrayListtop);
                            rec_top.setLayoutManager(new GridLayoutManager(getContext(), 4));
                            rec_top.setAdapter(adapterTopsubhome);

                            // Click listener

                            // Click listener
                            adapterTopsubhome.onitemclicklistener(new Recyclerclicklistener() {
                                @Override
                                public void onclick(int pos) {
                                    Log.d("position", String.valueOf(pos));
                                    ProductFragment productFragment = new ProductFragment();
                                    Bundle bundle = new Bundle();
                                    bundle.putString("key_sub", "" + arrayListtop.get(pos).getId());
                                    productFragment.setArguments(bundle);
                                    getFragmentManager().beginTransaction().replace(R.id.hide_container, productFragment).addToBackStack(null).commit();

                                }
                            });

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            requestQueue.add(stringRequesttop);


            // For Recycler View Mid
            StringRequest stringRequestmid = new StringRequest(Request.Method.GET, "http://api.karanvarma.link/Webservice1.asmx/menmidapi?id=" + cid, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        for (int i = 0; i < jsonArray.length(); i++) {

                            Modalclass modalclass = new Modalclass();
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String name = jsonObject.getString("mname");
                            String id = jsonObject.getString("id");
                            modalclass.setName(name);
                            modalclass.setId(id);

                            String img = "http://api.karanvarma.link/upload/" + jsonObject.getString("mimg");
                            modalclass.setImg(img);
                            arrayListmid.add(modalclass);
                            // For Recycler View First
                            adapterMidSubhome = new RecyclerAdapterMid_Subhome(getContext(), arrayListmid);
                            rec_mid.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                            rec_mid.setAdapter(adapterMidSubhome);

                            // Click listener

                        /*   adapter_top.onitemclicklistener(new Recyclerclicklistener() {
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

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            requestQueue.add(stringRequestmid);


            // For Recycler View Mid 2
            StringRequest stringRequestmid2 = new StringRequest(Request.Method.GET, "http://api.karanvarma.link/Webservice1.asmx/menmid2api?id=" + cid, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        for (int i = 0; i < jsonArray.length(); i++) {

                            Modalclass modalclass = new Modalclass();
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String name = jsonObject.getString("mname");
                            modalclass.setName(name);
                            String id = jsonObject.getString("id");

                            modalclass.setId(id);
                            String img = "http://api.karanvarma.link/upload/" + jsonObject.getString("mimg");
                            modalclass.setImg(img);
                            arrayListmid2.add(modalclass);
                            // For Recycler View First
                            adapterMidSubhome2 = new RecyclerAdapterMid_Subhome2(getContext(), arrayListmid2);
                            rec_mid2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                            rec_mid2.setAdapter(adapterMidSubhome2);

                            // Click listener

                           /*   adapter_top.onitemclicklistener(new Recyclerclicklistener() {
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

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            requestQueue.add(stringRequestmid2);


            // For Recycler View Mid 3
            StringRequest stringRequestmid3 = new StringRequest(Request.Method.GET, "http://api.karanvarma.link/Webservice1.asmx/menmid3api?id=" + cid, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        for (int i = 0; i < jsonArray.length(); i++) {

                            Modalclass modalclass = new Modalclass();
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String name = jsonObject.getString("mname");
                            modalclass.setName(name);
                            String id = jsonObject.getString("id");

                            modalclass.setId(id);

                            String img = "http://api.karanvarma.link/upload/" + jsonObject.getString("mimg");
                            modalclass.setImg(img);
                            arrayListmid3.add(modalclass);
                            // For Recycler View First
                            adapterMidSubhome3 = new RecyclerAdapterMid_Subhome3(getContext(), arrayListmid3);
                            rec_mid4.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                            rec_mid4.setAdapter(adapterMidSubhome3);

                            // Click listener

                           /*   adapter_top.onitemclicklistener(new Recyclerclicklistener() {
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

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            requestQueue.add(stringRequestmid3);


            // For Recycler View End
            StringRequest stringRequestend = new StringRequest(Request.Method.GET, "http://api.karanvarma.link/Webservice1.asmx/menendapi?id=" + cid, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        for (int i = 0; i < jsonArray.length(); i++) {

                            Modalclass modalclass = new Modalclass();
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String name = jsonObject.getString("mname");
                            modalclass.setName(name);
                            String id = jsonObject.getString("id");

                            modalclass.setId(id);

                            String img = "http://api.karanvarma.link/upload/" + jsonObject.getString("mimg");
                            modalclass.setImg(img);
                            arrayListend.add(modalclass);
                            // For Recycler View First
                            adapterEndSubhome = new RecyclerAdapterEnd_Subhome(getContext(), arrayListend);
                            rec_end.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                            rec_end.setAdapter(adapterEndSubhome);

                            // Click listener

                           /*   adapter_top.onitemclicklistener(new Recyclerclicklistener() {
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

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            requestQueue.add(stringRequestend);


            // For Image Slider First
            StringRequest stringRequestslider = new StringRequest(Request.Method.GET, " http://api.karanvarma.link/Webservice1.asmx/mensliderapi?id=" + cid, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            Modalclass modalclass = new Modalclass();
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String image = "http://api.karanvarma.link/upload/" + jsonObject.getString("mimg");

                            modalclass.setImg(image);
                            String id = jsonObject.getString("id");

                            modalclass.setId(id);
                            viewpager1.setAdapter(new ImageSliderAdaptor_subhome(viewpager1, arrayListslider));
                            arrayListslider.add(modalclass);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            requestQueue.add(stringRequestslider);


            // viewPager2.setAdapter(new ImageSliderAdaptor(viewPager2, arraylist5));
            viewpager1.setClipToPadding(false);
            viewpager1.setClipChildren(false);
            viewpager1.setOffscreenPageLimit(3);
            viewpager1.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


            CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
            compositePageTransformer.addTransformer(new MarginPageTransformer(20));
            compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
                @Override
                public void transformPage(@NonNull View page, float position) {
                    float r = 1 - Math.abs(position);
                    page.setScaleY(0.85f + r * 0.15f);
                }
            });


            sliderRunnable = new Runnable() {
                @Override
                public void run() {
                    viewpager1.setCurrentItem(viewpager1.getCurrentItem() + 1);
                }
            };


            viewpager1.setPageTransformer(compositePageTransformer);
            viewpager1.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                @Override
                public void onPageSelected(int position) {
                    super.onPageSelected(position);

                    sliderHandler.removeCallbacks(sliderRunnable);
                    sliderHandler.postDelayed(sliderRunnable, 2000); // slide duration 2 seconds
                }
            });


            //For Image Slider Second
            StringRequest stringRequestslider2 = new StringRequest(Request.Method.GET, "http://api.karanvarma.link/Webservice1.asmx/subcategoryapi?id=" + cid, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            Modalclass modalclass = new Modalclass();
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String image = "http://api.karanvarma.link/upload/" + jsonObject.getString("subimg");

                            String id = jsonObject.getString("id");

                            modalclass.setId(id);
                            modalclass.setImg(image);
                            viewpager2.setAdapter(new ImageSliderAdaptor_subhome2(viewpager2, arrayListslider2));
                            arrayListslider2.add(modalclass);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            requestQueue.add(stringRequestslider2);

            // viewPager2.setAdapter(new ImageSliderAdaptor(viewPager2, arraylist5));
            viewpager2.setClipToPadding(false);
            viewpager2.setClipChildren(false);
            viewpager2.setOffscreenPageLimit(3);
            viewpager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


            CompositePageTransformer compositePageTransformer2 = new CompositePageTransformer();
            compositePageTransformer2.addTransformer(new MarginPageTransformer(20));
            compositePageTransformer2.addTransformer(new ViewPager2.PageTransformer() {
                @Override
                public void transformPage(@NonNull View page, float position) {
                    float r = 1 - Math.abs(position);
                    page.setScaleY(0.85f + r * 0.15f);
                }
            });


            sliderRunnable2 = new Runnable() {
                @Override
                public void run() {
                    viewpager2.setCurrentItem(viewpager2.getCurrentItem() + 1);
                }
            };

            viewpager2.setPageTransformer(compositePageTransformer);
            viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                @Override
                public void onPageSelected(int position) {
                    super.onPageSelected(position);

                    sliderHandler2.removeCallbacks(sliderRunnable2);
                    sliderHandler2.postDelayed(sliderRunnable2, 2000); // slide duration 2 seconds
                }
            });


            //For Text
            StringRequest stringRequesttext = new StringRequest(Request.Method.GET, " http://api.karanvarma.link/Webservice1.asmx/mentextapi?id=" + cid, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        String txt = jsonArray.getJSONObject(0).getString("tname");
                        text1.setText(txt);

                    } catch (JSONException e) {
                        e.printStackTrace();

                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(getContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            requestQueue.add(stringRequesttext);


            //For Text 2
            StringRequest stringRequesttext2 = new StringRequest(Request.Method.GET, " http://api.karanvarma.link/Webservice1.asmx/mentext2api?id=" + cid, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        String txt2 = jsonArray.getJSONObject(0).getString("tname");
                        text2.setText(txt2);

                    } catch (JSONException e) {
                        e.printStackTrace();

                    }



                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(getContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            requestQueue.add(stringRequesttext2);


            //For Multi Images
            StringRequest stringRequestmulti_sub = new StringRequest(Request.Method.GET, "http://api.karanvarma.link/Webservice1.asmx/imgsubmultiapi?catid=" + cid, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    Toast.makeText(getContext(), "" + response, Toast.LENGTH_SHORT).show();

                    try {
                        JSONArray jsonArray = new JSONArray(response);

                        String imag1 = "http://api.karanvarma.link/upload/" + jsonArray.getJSONObject(0).getString("iimg");
                        Glide.with(getContext()).load(imag1).into(gifimg1);

                        String imag2 = "http://api.karanvarma.link/upload/" + jsonArray.getJSONObject(1).getString("iimg");
                        Glide.with(getContext()).load(imag2).into(img2);

                        String imag3 = "http://api.karanvarma.link/upload/" + jsonArray.getJSONObject(2).getString("iimg");
                        Glide.with(getContext()).load(imag3).into(gifimg3);

                        String imag4 = "http://api.karanvarma.link/upload/" + jsonArray.getJSONObject(3).getString("iimg");
                        Glide.with(getContext()).load(imag4).into(gifimg4);


                    } catch (JSONException e) {
                        e.printStackTrace();

                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(getContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            requestQueue.add(stringRequestmulti_sub);
        }

//----------------------------------------------------------------------------------------------------------------------------------------------------

                                                         //-----For Women-----//

        else if (cid.equals("2")){

        //For Recycler View Top
        StringRequest stringRequesttopw=new StringRequest(Request.Method.GET, "http://api.karanvarma.link/Webservice1.asmx/womentopapi?id=2", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("response",response);
                try {
                    JSONArray jsonArray=new JSONArray(response);

                    Log.d("response2",response);

                    for (int i=0;i<jsonArray.length();i++){
                        Modalclass modalclass=new Modalclass();
                        JSONObject jsonObject=jsonArray.getJSONObject(i);

                        String name=jsonObject.getString("wname");
                        String id = jsonObject.getString("id");


                        String img="http://api.karanvarma.link/upload/"+jsonObject.getString("wimg");
                        // Toast.makeText(getContext(), "gggg"+img, Toast.LENGTH_SHORT).show();
                        modalclass.setName(name);
                        modalclass.setId(id);
                        modalclass.setImg(img);
                        arrayListtopW.add(modalclass);
                        // For Recycler View First
                        adapterTopWomen=new RecyclerAdapterTop_Women(getContext(),arrayListtopW);
                        rec_topW.setLayoutManager(new GridLayoutManager(getContext(),4));
                        rec_topW.setAdapter(adapterTopWomen);

                        // Click listener

                        // Click listener
                       /* adapterTopsubhome.onitemclicklistener(new Recyclerclicklistener() {
                            @Override
                            public void onclick(int pos) {
                                Log.d("position", String.valueOf(pos));
                                ProductFragment productFragment = new ProductFragment();
                                Bundle bundle=new Bundle();
                                bundle.putString("key_sub",""+arrayListtop.get(pos).getId());
                                productFragment.setArguments(bundle);
                                getFragmentManager().beginTransaction().replace(R.id.hide_container,productFragment).addToBackStack(null).commit();

                            }
                        });
*/
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequesttopw);

        }


       return view;
    }

  /*  @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
         inflater=getActivity().getMenuInflater();
         inflater.inflate(R.menu.tools_subhome,menu);
         MenuItem.OnActionExpandListener onActionExpandListener=new MenuItem.OnActionExpandListener() {
             @Override
             public boolean onMenuItemActionExpand(@NonNull MenuItem menuItem) {
                 return true;
             }

             @Override
             public boolean onMenuItemActionCollapse(@NonNull MenuItem menuItem) {
                 return false;
             }
         };

        super.onCreateOptionsMenu(menu, inflater);

        return;
    }
*/

   /* //For Toolbar Items

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.bagsub:

            Toast.makeText(getContext(), "hgdosfuagf", Toast.LENGTH_SHORT).show();

            return false;
        }


        return super.onOptionsItemSelected(item);
    }*/
}