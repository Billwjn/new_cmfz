package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private String counts;
    private String months;
    private String name;
    private String value;
}
