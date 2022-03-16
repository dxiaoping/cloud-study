package com.example.user.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Date;

/**
 * @Tile:
 * @Author: 段晓平 医保研发5部 CN32219
 * @Date 2022/3/16
 * @Description:
 */
@Component
//@RefreshScope
@Data
@ConfigurationProperties(prefix = "person")//使用前缀标明具体的属性
@Validated // 校验数据使用
public class User implements Serializable {

    private String name;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
//    解决后台到前台时间格式的转换；只在返回json时起作用
//    pattern:需要转换的时间日期的格式
//    timezone：时间设置为东八区，避免时间在转换中有误差
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    解决前后到后台的时间格式的转换
//    pattern:需要转换的时间日期的格式
    private Date birthday;

    private String gender;

}
