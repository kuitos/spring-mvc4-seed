package com.shuyun.channel.common.base;

import com.shuyun.channel.common.enums.ResponseErrorEnum;
import com.shuyun.channel.common.model.ResponseResult;
import com.shuyun.channel.common.util.JacksonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * controller基类，用于统一请求响应的结果
 *
 * @author kui.liu
 * @since 2014/09/25 上午10:19
 */
public class BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    /**
     * 生成响应成功的结果
     *
     * @param data    结果正文
     * @param message 成功提示信息
     * @return
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
     * @return
     */
    protected ResponseResult genErrorResult(String message) {

        ResponseResult result = ResponseResult.newInstance();
        result.setSuccess(false);
        result.setMessage(message);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("--------> result:{}", JacksonMapper.toJsonString(result));
        }

        return result;
    }

    /**
     * 生成响应失败的结果
     *
     * @param responseErrorEnum 失败信息
     * @return
     */
    protected ResponseResult genErrorResult(ResponseErrorEnum responseErrorEnum) {

        ResponseResult result = ResponseResult.newInstance();
        result.setSuccess(false);
        result.setErrorInfo(responseErrorEnum);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("--------> result:{}", JacksonMapper.toJsonString(result));
        }

        return result;

    }

}
