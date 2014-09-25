package com.shuyun.channel.customer.controller;

import com.shuyun.channel.common.base.BaseController;
import com.shuyun.channel.common.model.ResponseResult;
import com.shuyun.channel.customer.model.User;
import com.shuyun.channel.customer.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kui.liu
 * @since 2014/09/24 下午7:54
 */
@RestController
public class DemoController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @Resource
    private DemoService demoService;

    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public ResponseResult<List<User>> getUser(String userName) {

        try {
            List<User> userList = demoService.getUser(userName);
            return this.genResult(userList, "成功!");

        } catch (Exception e) {
            LOGGER.error("查询用户出现异常!", e);
            return this.genErrorResult("用户获取失败!");
        }

    }

    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public ResponseResult saveUser(@RequestBody User user) {

        try {
            demoService.saveUser(user);
            return this.genResult("保存成功!");
        } catch (Exception e) {
            LOGGER.error("保存过程出现异常!", e);
            return this.genErrorResult("保存失败!");
        }
    }

}
