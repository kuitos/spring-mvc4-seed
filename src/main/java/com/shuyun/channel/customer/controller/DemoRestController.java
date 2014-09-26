package com.shuyun.channel.customer.controller;

import com.shuyun.channel.common.base.BaseRestController;
import com.shuyun.channel.common.model.ResponseResult;
import com.shuyun.channel.customer.model.User;
import com.shuyun.channel.customer.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author kui.liu
 * @since 2014/09/24 下午7:54
 */
@RestController
public class DemoRestController extends BaseRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoRestController.class);

    @Resource
    private DemoService demoService;

    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public ResponseResult<List<User>> getUser(String userName) {

        List<User> userList = demoService.getUser(userName);
        return this.genResult(userList, "成功!");
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public ResponseResult saveUser(@Valid @RequestBody User user, Errors errors, BindingResult bindingResult) {

        demoService.saveUser(user);
        return this.genResult("保存成功!");
    }

}
