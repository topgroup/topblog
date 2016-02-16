package com.topblog.action;

import com.alibaba.fastjson.JSON;
import com.dao.entity.UserInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by wmo on 2015/7/21.
 */
public class TestAction {
    public static void main(String... args){
        if(args==null || args.length==0){
            System.out.println("args is null");
        }

        List<UserInfo> userList=new ArrayList<>();

        for (int i=0; i < 1; i ++) {

            UserInfo userInfo = new UserInfo();
            userInfo.setUserid(123);
            userInfo.setSex(true);
            userInfo.setUserno(i);
            userInfo.setUsername("wmo");

            userList.add(userInfo);
        }
        long start=System.currentTimeMillis();

        System.out.println(JSON.toJSONString(userList));

        long end=System.currentTimeMillis();

        System.out.println("use time:"+(end - start) + "ms");
    }

    public void getClass(String name){
        System.out.println("aaa");
    }
}
