package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu implements Serializable {
    private String menuId;
    private String title;
    private String iconCls;
    private String parentId;
    private String href;
    private List<Menu> menus;
}
