package com.shuyun.channel.common.base;

import com.shuyun.channel.common.model.ResponseResult;
import org.junit.Test;

public class BaseControllerTest {

    @Test
    public void testGenResult() throws Exception {

    }

    @Test
    public void testGenErrorResult() throws Exception {

        BaseController baseController = new BaseController();
        ResponseResult responseResult = baseController.genErrorResult("错误");


    }
}