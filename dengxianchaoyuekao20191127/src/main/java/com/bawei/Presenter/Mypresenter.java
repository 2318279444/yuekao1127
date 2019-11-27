package com.bawei.Presenter;

import com.bawei.Base.BasePresenter;
import com.bawei.Bean.Shops;
import com.bawei.Contract.Icontract;
import com.bawei.Model.Mymodel;
import com.bawei.View.MainActivity;
import com.google.gson.Gson;

/*
 *@auther:邓先超
 *@Date: 2019/11/27
 *@Time:10:22
 *@Description:${DESCRIPTION}
 **/
public class Mypresenter extends BasePresenter implements Icontract.toRequest {
    Mymodel mymodel;
    public Mypresenter(){
        mymodel=new Mymodel();
    }


    @Override
    public void toData(String url) {
        mymodel.toGit(url, new Icontract.CallBack() {
            @Override
            public void success(String json) {
                Gson gson = new Gson();
                Shops shops = gson.fromJson(json, Shops.class);
                MainActivity mainActivity= (MainActivity) v;
                mainActivity.success(shops);
            }

            @Override
            public void error(String error) {

            }
        });
    }
}
