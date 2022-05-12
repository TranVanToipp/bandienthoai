package com.example.bandienthoai.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bandienthoai.R;
import com.example.bandienthoai.adapter.DienthoaiAdapter;
import com.example.bandienthoai.model.Sanpham;
import com.example.bandienthoai.uliti.Checkinternt;
import com.example.bandienthoai.uliti.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.widget.ListAdapter;

public class DienthoaiActivity extends AppCompatActivity {
    Toolbar tootbardt;
    ListView listviewdienthoai;
    DienthoaiAdapter dienthoaiAdapter;
    ArrayList<Sanpham> mangdienthoai;
    int iddienthoai = 0;
    int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dienthoai);
        Anhxa();
        listviewdienthoai.setAdapter(dienthoaiAdapter);
        if(Checkinternt.haveNetworkConnection(getApplicationContext())){
            GetIdLoaidt();
            ActionToobar();
            Getdata(page);
        }else {
            Checkinternt.showToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối internet");
            finish();
        }
    }

    private void Getdata(int Page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String DuongDan = Server.DuongDanDienThoai + String.valueOf(Page);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, DuongDan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id = 0;
                String Tendt = "";
                int Giadt = 0;
                String Hinhanhdt = "";
                String Mota = "";
                int idspdt = 0;
                if(response != null){
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for(int i = 0; i< jsonArray.length(); i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            Tendt = jsonObject.getString("tensp");
                            Giadt = jsonObject.getInt("giasp");
                            Hinhanhdt = jsonObject.getString("hinhanhsp");
                            Mota = jsonObject.getString("motasp");
                            idspdt = jsonObject.getInt("idsanpham");
                            mangdienthoai.add(new Sanpham(id,Tendt,Giadt,Hinhanhdt,Mota,idspdt));
                            dienthoaiAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> para = new HashMap<String, String>();
                para.put("idsanpham",String.valueOf(iddienthoai));
                return para;
            }
        };
        requestQueue.add(stringRequest);
    }
    private void ActionToobar() {
        setSupportActionBar(tootbardt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tootbardt.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }



//    private void setSupportActionBar(Toolbar toobardt) {
//    }


    private void GetIdLoaidt() {
        iddienthoai = getIntent().getByteExtra("idloaisanpham", (byte) 1);
        Log.d("giá trị loại sản phẩm ",iddienthoai+"");
    }

    private void Anhxa() {
        tootbardt = (Toolbar) findViewById(R.id.tootbardienthoai);
        listviewdienthoai = (ListView) findViewById(R.id.listviewdienthoai);
        mangdienthoai = new ArrayList<>();
        dienthoaiAdapter = new DienthoaiAdapter(getApplicationContext(),mangdienthoai);


    }
}