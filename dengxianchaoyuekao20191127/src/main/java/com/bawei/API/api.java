package com.bawei.API;

/*
 *@auther:邓先超
 *@Date: 2019/11/27
 *@Time:10:38
 *@Description:${DESCRIPTION}
 **/
public class api {
    public String getUrl(String keyword,int page,int count){
        String url="http://172.17.8.100/small/commodity/v1/findCommodityByKeyword"+"?keyword="+keyword+"&page="+page+"&count="+count;
        return url;
    }
}
