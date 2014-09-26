package com.shuyun.channel.common.base;

import com.shuyun.channel.common.enums.ResponseErrorEnum;
import com.shuyun.channel.common.exception.ParamsNotMatchException;
import com.shuyun.channel.common.model.ResponseResult;
import com.shuyun.channel.common.util.RestResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController增强，用于统一请求响应的结果，统一接口异常处理
 *
 * @author kui.liu
 * @since 2014/09/25 上午10:19
 */
@ControllerAdvice(annotations = RestController.class)
public class RestControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestControllerAdvice.class);

    /**
     * 统一的rest接口异常处理器
     *
     * @param e 捕获的异常
     * @return 异常信息
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected <T> ResponseResult<T> exceptionHandler(Exception e) {

        LOGGER.error("接口调用异常!", e);
        return RestResultGenerator.genErrorResult(ResponseErrorEnum.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ParamsNotMatchException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected <T> ResponseResult<T> exception1Handler(Exception e) {

        LOGGER.error("ParamsNotMatchException!", e);
        return RestResultGenerator.genErrorResult(ResponseErrorEnum.PARAMS_NOT_MATCH);
    }

}
