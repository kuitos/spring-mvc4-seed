package com.shuyun.channel.common.base;

import com.shuyun.channel.common.model.RequestResult;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseControllerTest {

    @Test
    public void testGenResult() throws Exception {

    }

    @Test
    public void testGenErrorResult() throws Exception {

        BaseController baseController = new BaseController();
        RequestResult requestResult = baseController.genErrorResult("错误");


    }
}