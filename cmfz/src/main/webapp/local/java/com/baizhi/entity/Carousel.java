package com.baizhi.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carousel implements Serializable {
	private String id;
	private String name;
	private String imgPath;
	private String description;
	private String status;
	//用jackson转成json时的json格式
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	//设置springMVC接受日期的格式
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime;
}
