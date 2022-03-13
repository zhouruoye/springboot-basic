package com.cest.service.template.impl;

import com.alibaba.fastjson.JSON;
import com.cest.service.template.HttpClient;
import com.cest.service.template.NetMall;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service("dangDangNetMall")
public class DangDangNetMall extends NetMall {


    @Override
    public Boolean login(String uId, String uPwd) {
        log.info("模拟当当用户登录 uId：{} uPwd：{}", uId, uPwd);
        return true;
    }

    @Override
    public Map<String, String> reptile(String skuUrl) {
        String str = HttpClient.doGet(skuUrl);
        Pattern p9 = Pattern.compile("(?<=title\\>).*(?=</title)");
        Matcher m9 = p9.matcher(str);
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        if (m9.find()) {
            map.put("name", m9.group());
        }
        map.put("price", "4548.00");
        log.info("模拟当当商品爬虫解析：{} | {} 元 {}", map.get("name"), map.get("price"), skuUrl);
        return map;
    }

    @Override
    public String createBase64(Map<String, String> goodsInfo) {
        BASE64Encoder encoder = new BASE64Encoder();
        log.info("模拟生成当当商品base64海报");
        return encoder.encode(JSON.toJSONString(goodsInfo).getBytes());
    }
}
