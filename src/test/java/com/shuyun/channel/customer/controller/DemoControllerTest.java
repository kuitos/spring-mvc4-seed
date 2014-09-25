package com.shuyun.channel.customer.controller;

import com.shuyun.channel.customer.model.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class DemoControllerTest {

    @Test
    public void testTest() throws Exception {

        DemoController demoController = new DemoController();
        User user = User.newInstance("kuitos", 10);
        demoController.test(user);

    }
}