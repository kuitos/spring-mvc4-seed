package com.kuitos.common.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author kui.liu
 * @since 2014/09/24 下午10:51
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {

    @NotEmpty
    private String userName;

    @NotEmpty
    private Integer age;

    private User() {
    }

    private User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public static User newInstance(String userName, Integer age) {
        return new User(userName, age);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
