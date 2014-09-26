package com.shuyun.channel.common.base;

import com.shuyun.channel.common.enums.ResponseErrorEnum;
import com.shuyun.channel.common.model.ResponseResult;
import com.shuyun.channel.common.util.JacksonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 所有restController基类，用于统一请求响应的结果，统一接口异常处理
 *
 * @author kui.liu
 * @since 2014/09/25 上午10:19
 */
@ControllerAdvice(annotations = RestController.class)
public class BaseRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseRestController.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected <T> ResponseResult<T> exceptionHandler(Exception e) {

        LOGGER.error("接口调用异常!", e);
        return this.genErrorResult(ResponseErrorEnum.INTERNAL_SERVER_ERROR);
    }

    /**
     * 生成响应成功的(不带正文)的结果
     *
     * @param message 成功提示信息
     * @return ResponseResult
     */
    protected <T> ResponseResult<T> genResult(String message) {

        ResponseResult<T> responseResult = ResponseResult.newInstance();
        responseResult.setSuccess(true);
        responseResult.setMessage(message);

        return responseResult;
    }

    /**
     * 生成响应成功(带正文)的结果
     *
     * @param data    结果正文
     * @param message 成功提示信息
     * @return ResponseResult
     */
    protected <T> ResponseResult<T> genResult(T data, String message) {

        ResponseResult<T> result = ResponseResult.newInstance();
        result.setSuccess(true);
        result.setData(data);
        result.setMessage(message);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("--------> result:{}", JacksonMapper.toJsonString(result));
        }

        return result;
    }

    /**
     * 生成响应失败的结果
     *
     * @param message 自定义错误信息
     * @return ResponseResult
     */
    protected <T> ResponseResult<T> genErrorResult(String message) {

        ResponseResult<T> result = ResponseResult.newInstance();
        result.setSuccess(false);
        result.setMessage(message);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("--------> result:{}", JacksonMapper.toJsonString(result));
        }

        return result;
    }

    /**
     * 生成响应失败(带errorCode)的结果
     *
     * @param responseErrorEnum 失败信息
     * @return ResponseResult
     */
    protected <T> ResponseResult<T> genErrorResult(ResponseErrorEnum responseErrorEnum) {

        ResponseResult<T> result = ResponseResult.newInstance();
        result.setSuccess(false);
        result.setErrorInfo(responseErrorEnum);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("--------> result:{}", JacksonMapper.toJsonString(result));
        }

        return result;
    }

}
