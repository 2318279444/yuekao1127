package com.bawei.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.API.api;
import com.bawei.Adapter.MyAdapter;
import com.bawei.Base.BaseActivity;
import com.bawei.Base.BasePresenter;
import com.bawei.Bean.Shops;
import com.bawei.Contract.Icontract;
import com.bawei.Mylinner.Myview;
import com.bawei.Presenter.Mypresenter;
import com.bawei.custo.Custom;
import com.bawei.dengxianchaoyuekao20191127.Info;
import com.bawei.dengxianchaoyuekao20191127.R;
import com.bawei.util.Util;

import java.net.URLEncoder;

public class MainActivity extends BaseActivity implements Icontract.toRid, Custom.Customm {
    RecyclerView recyclerView;

    Custom custom;

    Myview myview;
    @Override
    protected void inidata() {
        boolean connected = Util.getInstance().getConnected(MainActivity.this);
        if(connected){

            String str = URLEncoder.encode("板鞋");
            api api = new api();
            Mypresenter mypresenter= (Mypresenter) p;
            mypresenter.toData(api.getUrl(str,1,5));


        }else {
            Toast.makeText(MainActivity.this,"无网络",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void iniview() {
        myview=findViewById(R.id.mylinner);

        custom=findViewById(R.id.custom);
        custom.setCustomm(this);

        recyclerView=findViewById(R.id.RecyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new Mypresenter();
    }

    @Override
    public void success(Shops shops) {
        MyAdapter myAdapter = new MyAdapter(shops.getResult(), this);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setCallBa(new MyAdapter.CallBa() {
            @Override
            public void onClick(int position) {
                startActivity(new Intent(MainActivity.this, Info.class));
            }
        });
    }

    @Override
    public void onClick() {
        String key = custom.editText.getText().toString();
        String str = URLEncoder.encode(key);
        api api = new api();
        Mypresenter mypresenter= (Mypresenter) p;
        mypresenter.toData(api.getUrl(str,1,5));
        addview(key);
    }


    public void addview(String s){
        TextView textView=new TextView(MainActivity.this);
        textView.setText(s);
        textView.setTextSize(15);
        textView.setTextColor(Color.BLACK);
        myview.addView(textView);
    }
}
