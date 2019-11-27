package com.bawei.Contract;

import com.bawei.Bean.Shops;

/*
 *@auther:邓先超
 *@Date: 2019/11/27
 *@Time:10:23
 *@Description:${DESCRIPTION}
 **/
public interface Icontract {
    public interface toRequest{
        void toData(String url);
    }

    public interface CallBack{
        void success(String json);
        void error(String error);
    }

    public interface toRid{
        void success(Shops shops);
    }
}
