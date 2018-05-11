package com.cn.spring.cloud.dubbo.dto;

import lombok.Data;

/**
 * Created by luozhonghua on 2017/6/17.
 */
@Data
public class UserDTO {

    private Integer userId;

    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
