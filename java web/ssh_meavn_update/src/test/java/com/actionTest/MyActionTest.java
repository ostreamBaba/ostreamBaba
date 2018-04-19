package com.actionTest;

import com.viscu.action.MyAction;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @Create by ostreamBaba on 18-4-3
 * @描述
 */
public class MyActionTest extends TestCase{

    @Test
    public void testExecute() throws Exception {
        MyAction myAction=new MyAction();
        myAction.setNumber(5);
        assertEquals("success",myAction.execute());
        assertEquals(15,myAction.getNumber());
    }

}
