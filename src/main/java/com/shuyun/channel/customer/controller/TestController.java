package com.shuyun.channel.customer.controller;

import com.shuyun.channel.common.constant.ContentType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kui.liu
 * @since 2014/09/24 下午7:54
 */
@RestController
public class TestController {

    @RequestMapping(value = "test", produces = ContentType.TEXT_PLAIN_UTF8)
    public String test() {
        return "好了";
    }

}
