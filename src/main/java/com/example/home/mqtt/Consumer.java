package com.example.home.mqtt;

import com.example.home.common.MessageUtil;
import com.example.home.common.SpringUtils;
import com.example.home.entity.Device;
import com.example.home.service.DeviceService;
import com.example.home.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  测试mqtt监听类
 */
@Slf4j
@Component
public class Consumer {

    //获取上下文，构造服务类
    ApplicationContext applicationContext = SpringUtils.getApplicationContext();
    DeviceService deviceService = applicationContext.getBean(DeviceService.class);

    ProducerService newsProducerService = applicationContext.getBean(ProducerService.class);

    Device device = new Device();

    /**
     * 消息消费者，参数类型可以修改，观察结果
     * @param payload
     */
    @JmsListener(destination = "inTopic")
    public void receive(String payload) {

        System.out.println("payload:" + payload);

    }

    @JmsListener(destination = "DHT11")
    public void subscribe(byte[] payload)  {
    /*
        测试接收到的故障消息，格式正确
        1.修改字节格式上传
        2.修改解析方法
        3.
     */
        analyser(new String(payload));

    }

    public void analyser(String Messages)  {

        /**
         * 先解析协议头
         * * 网关认证应答消息
         * * 网关测试消息
         * * 温度上传消息
         * * 定位消息
         * * 路由广播消息
         * * 路灯状态消息
         * * 定位状态消息
         * * 路灯故障消息
         *  协议头存到一个变量里
         *  这里也要添加一个帧头帧尾的判定
         */
        //转换为Int型后的数据，便于查找
        Integer[] integers = MessageUtil.handleStr2ArrInt(MessageUtil.handleStr2ArrStr(Messages));

        //帧头帧尾检测，消息类型识别
        if(integers[0]==0x58 && integers[1]==0x44 && integers[integers.length-1]==0x23){

            switch (integers[16]) {
                //路灯信息协议
                case 0x02 : {     //协议类型
                    //可以改进
                    System.out.println("路灯信息");

                    infoProcess(Messages);

                    break;
                }
                //故障信息协议
                case 0x03 :
                    System.out.println("故障信息");
//                     调用alarm方法，针对不同类型的故障信息，做出相应处理
//                    alarmProcess(Messages , integers);

                    break;
                //注册认证协议
                case 0x0F :
                    System.out.println("注册认证消息");
                    //认证处理方法

                    break;
                //应答消息协议
                case 0xAA :
                    System.out.println("应答消息");

                    break;
                //心跳包协议
                case 0x55 : {
                    System.out.println("心跳包");

//                    heartProcess(Messages);

                    break;
                }
                default:
                    break;
            }
        }else {//未检测到帧头帧尾
            System.out.println("未检测到帧头帧尾");
        }


    }

    //路灯信息处理方法
    public void infoProcess(String Messages){

        //PanID
        System.out.println(Messages.substring(6, 8) + Messages.substring(4, 6));
        //MAC地址
        device.setDeviceMac(Messages.substring(8, 24));

        //短地址
        String temp = Messages.substring(26, 28) + Messages.substring(24, 26);
        device.setDeviceShort(temp);

        //序列号
        temp = Messages.substring(30, 32) + Messages.substring(28, 30);
        device.setDeviceSerial(temp);

        //开灯状态,int型
        device.setDeviceLight(Integer.parseInt(Messages.substring(36, 38)));

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String update_time = sf.format(date);

        device.setDeviceUpdatetime(update_time);

        deviceService.insertDevice(device);

        //Java端对Zigbee端的应答消息
        byte[] payload = {0x58, 0x44, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xAA, 0x01, 0x02, 0x23};

        newsProducerService.publishBytes(payload);
    }

}

