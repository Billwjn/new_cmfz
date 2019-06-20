package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Carousel;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("queryAll")
    public Map<String,Object> queryAll(Integer page , Integer rows){
        Map<String, Object> stringObjectMap = userService.queryUsers(page, rows);
        return stringObjectMap;
    }
    @RequestMapping("queryStatistics")
    public Map<String, Object> queryStatistics(){
        Map<String, Object> stringObjectMap = userService.queryStatistics();
        return stringObjectMap;
    }
    @RequestMapping("queryDistribution")
    public Map<String,Object> queryDistribution(){
        Map<String, Object> stringObjectMap = userService.queryDistribution();
        return stringObjectMap;
    }
    @RequestMapping("export")
    public void export(HttpServletResponse res)throws Exception{
        List<User> users = userService.queryAllUsers();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("全部用户","用户表"), User.class, users);
        //设置响应类型和响应头
        res.setContentType("application/vnd.ms-excel");
        res.setHeader("Content-Disposition", "attachment;fileName="+ java.net.URLEncoder.encode("用户信息.xls", "UTF-8"));
        workbook.write(res.getOutputStream());
        workbook.close();
    }
}
