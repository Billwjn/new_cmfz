package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String id;
    private String mobile;
    private String username;
    private String password;
    private String salt;
    private String dharmaName;
    private String province;
    private String city;
    private String gender;
    private String sign;
    private String profile;
    private String status;
    private Date registTime;
}
