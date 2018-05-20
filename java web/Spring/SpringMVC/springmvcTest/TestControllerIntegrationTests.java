package com.viscu.test;

import com.viscu.springmvc.MyMvcConfig;
import com.viscu.springmvc.springmvcTest.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @ Create by ostreamBaba on 18-5-20
 * @ Spring MVC的测试 测试web项目通常不启动项目 需要一些Servlet相关的模拟对象
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyMvcConfig.class)
@WebAppConfiguration("src/main/resources") //指定加载的ApplicationContext是一个WebApplicationContext
//属性是web资源的位置 默认是src/main/webapp 现指向src/main/resources

public class TestControllerIntegrationTests {
    private MockMvc mockMvc; //模拟MVC对象
    @Autowired
    private DemoService demoService;
    @Autowired
    WebApplicationContext wac; //注入WebApplicationContext
    @Autowired
    MockHttpSession session; //可注入模拟的 Http session
    @Autowired
    MockHttpServletRequest request; //可注入模拟的 Http request
    @Before
    public void setup(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.wac).build();
    }//初始化MVC对象
    @Test  //测试前的初始化工作
    public void testNormalController() throws Exception{
        mockMvc.perform(get("/normal")) //模拟向/normal 发生get请求
                .andExpect(status().isOk()) //预期状态值为200
                .andExpect(view().name("page")) //预期view名称为page
                .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp")) //预期页面转向真正的路径/WEB-INF/classes/views/page.jsp
                .andExpect(model().attribute("msg",demoService.hello()));//预期model里面的值是demoService.hello())的返回值
    }
    @Test
    public void testRestController()throws Exception{
        mockMvc.perform(get("/testRest"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(demoService.hello()))//预期返回的媒体类型是demoService.hello())
                .andExpect(content().string(demoService.hello()));//预期返回的值是demoService.hello())的返回值hello
    }
}

