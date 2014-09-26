package com.shuyun.channel.model;

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
    private int age;

    private User() {
    }

    private User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public static User newInstance(String userName, int age) {
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

    public void setAge(int age) {
        this.age = age;
    }
}
