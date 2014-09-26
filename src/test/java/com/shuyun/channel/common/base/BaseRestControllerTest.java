package com.shuyun.channel.common.base;

import com.shuyun.channel.common.model.ResponseResult;
import org.junit.Test;

public class BaseRestControllerTest {

    @Test
    public void testGenResult() throws Exception {

    }

    @Test
    public void testGenErrorResult() throws Exception {

        BaseRestController baseRestController = new BaseRestController();
        ResponseResult responseResult = baseRestController.genErrorResult("错误");


    }
}