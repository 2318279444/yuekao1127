package com.bawei.Base;

/*
 *@auther:邓先超
 *@Date: 2019/11/27
 *@Time:10:22
 *@Description:${DESCRIPTION}
 **/
public class BasePresenter<V extends BaseActivity> {
    public V v;
    public void attach(V v){
        this.v=v;
    }


    public void unattach(){
        if(v!=null){
            v=null;
        }
    }
}
