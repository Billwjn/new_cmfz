package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Carousel;
import com.baizhi.entity.User;
import com.baizhi.entity.UserDTO;
import com.baizhi.service.UserService;
import com.google.gson.Gson;
import io.goeasy.GoEasy;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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
    public void queryStatistics(){
        Map<String, Object> stringObjectMap = userService.queryStatistics();
        GoEasy goEasy = new GoEasy("https://rest-hangzhou.goeasy.io", "BC-82da440207614095b697816ca3ef5935");
        Gson gson = new Gson();
        String s = gson.toJson(stringObjectMap);
        goEasy.publish("demo_channel",s);
        System.out.println("goeasy输出完毕+++++++++++++++++++++++");
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
    @RequestMapping("regist")
    public void regsit(HttpSession session , MultipartFile imgFile , User user){
        String originalFilename = imgFile.getOriginalFilename();
        String realPath = session.getServletContext().getRealPath("profile");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdir();
        }
        String profile = realPath+"/"+originalFilename;
        user.setProfile(profile);
        try {
            imgFile.transferTo(new File(profile));
            userService.regist(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> stringObjectMap = userService.queryStatistics();
        GoEasy goEasy = new GoEasy("https://rest-hangzhou.goeasy.io", "BC-82da440207614095b697816ca3ef5935");
        Gson gson = new Gson();
        String s = gson.toJson(stringObjectMap);
        goEasy.publish("demo_channel",s);
    }
}
