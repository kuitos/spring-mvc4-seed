package com.shuyun.channel.common.base;

import com.shuyun.channel.common.model.RequestResult;
import com.shuyun.channel.common.util.JacksonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kui.liu
 * @since 2014/09/25 上午10:19
 */
public class BaseController {

    private final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    protected <T> RequestResult<T> genResult(T data, String message) {

        RequestResult<T> result = new RequestResult<>();
        result.setSuccess(true);
        result.setData(data);
        result.setMessage(message);

        if (LOGGER.isDebugEnabled()) {
            String resultStr = JacksonMapper.toJsonString(result);
            LOGGER.debug("--------> result:{}", resultStr);
        }

        return result;
    }

    protected RequestResult genErrorResult(String message) {

        RequestResult result = new RequestResult();
        result.setSuccess(false);
        result.setMessage(message);

        if (LOGGER.isDebugEnabled()) {
            String resultStr = JacksonMapper.toJsonString(result);
            LOGGER.debug("--------> result:{}", resultStr);
        }

        return result;
    }

}
