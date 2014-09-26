package com.shuyun.channel.customer.controller;

import com.shuyun.channel.common.exception.ParamsNotMatchException;
import com.shuyun.channel.common.model.ResponseResult;
import com.shuyun.channel.common.util.RestResultGenerator;
import com.shuyun.channel.customer.model.User;
import com.shuyun.channel.customer.service.DemoService;
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
public class DemoRestController {

    @Resource
    private DemoService demoService;

    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public ResponseResult<List<User>> getUser(String userName) throws ParamsNotMatchException {

        List<User> userList = demoService.getUser(userName);

        throw new ParamsNotMatchException();
//        return ResponseResultGenerator.genResult(userList, "成功!");
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public ResponseResult saveUser(@Valid @RequestBody User user, Errors errors, BindingResult bindingResult) {

        demoService.saveUser(user);
        return RestResultGenerator.genResult("保存成功!");
    }

}
