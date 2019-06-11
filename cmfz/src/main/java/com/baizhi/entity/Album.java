package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album implements Serializable {
    private String id;
    private String title;
    private String cover;
    private Integer count;
    private Integer score;
    private String author;
    private String broadcast;
    private String brief;
    private Date publishTime;
}
