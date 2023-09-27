package com.example.home.controller;


import com.example.home.entity.User;
import com.example.home.entity.testEntity;
import com.example.home.mapper.testMapper;
import com.example.home.service.ProducerService;
import com.example.home.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import com.example.light.common.ResultMapUtil;

@Controller
public class testController {

    @Autowired
    private testMapper testmapper;

    @Autowired
    private ProducerService producerService;



    @RequestMapping("/testString")
    @ResponseBody
    public String testString(){
        return "hello";
    }

    @RequestMapping("/testLogin")
    public String testLogin(){
        return "login2";
    }

    @RequestMapping("/test")

    public String test(){
        return "/test";
    }

    @RequestMapping("/testInt")
    @ResponseBody
    public Object testInt(){
        User user = new User();
        user.setUId(1);
        user.setUName("SCxx");
        user.setUPsw("ioooeiss");
        return user;
    }

//    @RequestMapping("/testLoginIn")
//    @ResponseBody
//    public Object testLoginIn(String username,String password){
//
//
//        System.out.printf("here");
//
//
//        User QueryUser = userService.queryUserByNameAndPassword(username,password);
//
//        if(QueryUser != null){
//            return ResultMapUtil.getHashMapLogin("验证成功","1");
//        }else {
//            return ResultMapUtil.getHashMapLogin("验证失败","2");
//        }
//
//    }

    @RequestMapping("/testIndex")
    public Object testIndex(){
        return "/index";
    }

    @RequestMapping("/testBaiduMap")
    public Object testBaiduMap(){
        return "/baiduMap";
    }

    @RequestMapping("/postcmd")
    @ResponseBody
    public void postcmd(){

        System.out.println("test post cmd");
        //return "test post cmd";
    }

    @RequestMapping("/testController")
    @ResponseBody
    public void testController(){

//        testEntity entity = new testEntity();
//        entity.setIdtestTable(1);
//        testEntity entity1 = testService.queryUserById(entity);
//
//        System.out.println(entity1.getIdtestTable());

    }

    /**
     * 消息生产者
     */
    @RequestMapping("/testProduce")
    @ResponseBody
    public void produce() {

        byte[] payload={0x58,0x44,0x23,0x24,0x26,0x25,0x27,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x04,0x02,0x01,0x00,0x23};

        producerService.publishBytes(payload);

    }


}
