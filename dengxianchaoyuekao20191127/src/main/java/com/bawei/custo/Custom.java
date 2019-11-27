package com.bawei.custo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bawei.dengxianchaoyuekao20191127.R;

/*
 *@auther:邓先超
 *@Date: 2019/11/27
 *@Time:11:01
 *@Description:${DESCRIPTION}
 **/
public class Custom extends LinearLayout {
    public EditText editText;
    public Button button;
    public Custom(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.custom, this);
        editText=view.findViewById(R.id.edit);
        button=view.findViewById(R.id.sousuo);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                customm.onClick();
            }
        });
    }



    public interface Customm {
        void onClick();
    }

    public Customm customm;

    public void setCustomm(Customm customm){
        this.customm=customm;
    }
}
