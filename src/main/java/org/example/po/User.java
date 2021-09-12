package org.example.po;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer sex;
    private Date createTime;
    private Date updateTime;
}
