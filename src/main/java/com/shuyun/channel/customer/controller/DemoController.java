package com.shuyun.channel.customer.controller;

import com.shuyun.channel.common.base.BaseController;
import com.shuyun.channel.common.constant.ContentType;
import com.shuyun.channel.common.model.RequestResult;
import com.shuyun.channel.customer.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kui.liu
 * @since 2014/09/24 下午7:54
 */
@RestController
public class DemoController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping(value = "test", produces = ContentType.APPLICATION_JSON_UTF8)
    public RequestResult<User> test(User user) {

        this.genErrorResult("错误");

        LOGGER.debug("tttt");

        return this.genResult(user, "成功!");
    }

    @RequestMapping(value = "s")
    public User t(){
        return User.newInstance("ss",20);
    }

}
