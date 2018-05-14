package com.ostream.redis;

import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @ Create by ostreamBaba on 18-5-14
 * @ redis
 */
public class initRedis {
    public static void main(String[] args) {
        //链接到本地的Redis服务
        Jedis jedis=new Jedis("localhost");
        System.out.println("linked success");
        //System.out.println("linking: "+jedis.ping());
        jedis.lpush("site-list","baidu");
        jedis.lpush("site-list","Alibaba");
        jedis.lpush("site-list","tx");
        List<String> list=jedis.lrange("site-list",0,2);
        for (String str:list){
            System.out.println(str);
        }
        Set<String> set=jedis.keys("*");
        for(Iterator<String> it=set.iterator();it.hasNext();){
            String key=it.next();
            System.out.println(key);
        }
    }
}
