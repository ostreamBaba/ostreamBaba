package com.viscu.ognl;
import com.viscu.entity.User;
import ognl.Ognl;
import ognl.OgnlException;

import java.util.HashMap;
import java.util.Map;

/**
 * @Create by ostreamBaba on 18-3-29
 * @描述
 */
public class ognlTest {

    public static void main(String[] args) throws OgnlException{
        User user=new User();
        user.setUsername("money");
        Map context=new HashMap();
        context.put("u",user);
        System.out.println("username="+(String)Ognl.getValue("getUsername()",user));
        System.out.println("获取数据:"+(String) Ognl.getValue("#u.username",context,user));
    }
}
