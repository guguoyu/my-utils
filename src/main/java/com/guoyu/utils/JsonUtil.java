package com.guoyu.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;


/**
 * @author guguoyu
 * @date 2019/4/18
 * @since JDK 1.8
 */
public class JsonUtil {
    private static final ObjectMapper om = new ObjectMapper();
    private static final Logger logger = LogManager
            .getLogger(JsonUtil.class);

    /**
     * 对象转json字符串
     *
     * @param object 需要转换的对象,例如：OcrAbility(id=1, type=ocr, status=1)
     * @return 返回json字符串，例如：{"id":1,"type":"ocr","status":1}
     */
    public static String obj2Json(Object object) {
        try {
            return om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("实体转换json失败", e);
        }
        return null;
    }

    /**
     * json字符串转对象
     *
     * @param jsonString  需要转换的json字符串，例如：{"id":1,"type":"ocr","status":1}
     * @param objectClass 转换后的对象class，例如OcrAbility.class
     * @param <T>         实体类对象,例如：OcrAbility(id=1, type=ocr, status=1)
     * @return OcrAbility(id = 1, type = ocr, status = 1)
     */
    public static <T> T json2Obj(String jsonString, Class<T> objectClass) {
        try {
            return om.readValue(jsonString, objectClass);
        } catch (Exception e) {
            logger.error("json转换实体失败", e);
        }
        return null;
    }

    /**
     * json字符串转成map
     *
     * @param jsonStr 需要转换的json字符串,例如：{"appId":"123456","userId":"654789","probability":"true"}
     * @return 转换后的map ，例如：{appId=123456, userId=654789, probability=true}
     */
    public static Map<String, Object> json2Map(String jsonStr) {
        try {
            return om.readValue(jsonStr, Map.class);
        } catch (Exception e) {
            logger.error("json转换map失败", e);
        }
        return null;
    }

    /**
     * map转成json字符串
     *
     * @param map 需要转换的map，例如：{appId=123456, userId=654789, probability=true}
     * @return 转换之后的json字符串，例如：{"appId":"123456","userId":"654789","probability":"true"}
     */
    public static String map2Json(Map map) {
        try {
            return om.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            logger.error("map转换json失败", e);
        }
        return null;
    }
}