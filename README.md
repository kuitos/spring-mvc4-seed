# Spring MVC4 Seed
基于springMVC4构建的seed项目，提供统一的rest接口响应、异常处理、参数校验等

******************


### 目录和说明 (menus and files)

    +src/main/java/com.kuitos.common
        +base
            -MybatisDao.java            // 通用MybatisDao
            -RestExceptionHandler.java  // 全局RestController异常处理器，使用@ControllerAdvice实现
        +controller
            -DemoRestController.java    // demo controller
        +enums              
            -ResponseErrorEnum.java     // 统一响应错误信息
        +bean
            -ResponseResult.java        // 统一响应结果bean
        +util
            -JacksonMapper.java         // Jackson操作工具类
            -RestResponseGenerator.java //统一响应结果生成工具类

## License

Licensed under MIT.
