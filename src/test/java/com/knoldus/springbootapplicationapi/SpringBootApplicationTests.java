package com.knoldus.springbootapplicationapi;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootApplication.class)
public class SpringBootApplicationTests {
    public static final long MSEC_SINCE_EPOCH = System.currentTimeMillis();
    protected MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void whenGettingStatus_shouldReturnCurrentTime() throws Exception{
        Date instant = new Date( MSEC_SINCE_EPOCH );
        SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm aa" );
        String time = sdf.format( instant );

        String uri = "/status_time";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status_time = mvcResult.getResponse().getStatus();
        assertEquals(200, status_time);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals("Running, "+time, content);
    }
}