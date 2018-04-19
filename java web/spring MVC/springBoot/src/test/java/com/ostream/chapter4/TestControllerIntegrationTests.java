package com.ostream.chapter4;

import com.ostream.springmvc4.MyMvcConfig;
import com.ostream.springmvc4.service.DemoService;
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
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Create by ostreamBaba on 18-4-11
 * @描述
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class})
@WebAppConfiguration("src/main/resource")
public class TestControllerIntegrationTests {
    private MockMvc mockMvc;

    @Autowired
    private DemoService demoService;

    @Autowired
    WebApplicationContext wac;

    @Autowired
    MockHttpSession session;

    @Autowired
    MockHttpServletRequest request;


    @Before
    public void setup(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

   /* @Test
    public void test() throws Exception{
        mockMvc.perform(get("/normal"))
                .andExpect(status.isOk())
                .andExpect(view().name("page"));
    }*/
}