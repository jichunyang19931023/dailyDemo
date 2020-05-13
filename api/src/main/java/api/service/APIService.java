package api.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import api.annotion.API;
import api.annotion.APIField;
import api.entity.AbstractAPI;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class APIService {

	public JSONObject apiCreate(AbstractAPI api){
		JSONObject result = new JSONObject();
		// 从API注解获取请求说明
		API apiObj = api.getClass().getAnnotation(API.class);
		result.put("apiDesc", apiObj.desc());
		result.put("apiUrl", apiObj.url());
		result.put("apiType", apiObj.type());
		
		JSONArray apiParams = JSONUtil.createArray();
		Arrays.stream(api.getClass().getDeclaredFields()) // 获得所有字段
				.filter(field -> field.isAnnotationPresent(APIField.class)) // 查找标记了注解的字段
				.peek(field -> field.setAccessible(true)) // 设置可以访问私有字段
				.forEach(field -> {
					JSONObject paramObj = new JSONObject();
					// 获得注解
					APIField apiField = field.getAnnotation(APIField.class);
					Object value = "";
					try {
						// 反射获取字段值
						value = field.get(api);
					} catch (IllegalAccessException e) {
						log.error("反射获取字段值发生异常", e);
					}
					paramObj.put("paramName", field.getName());
					paramObj.put("paramType", apiField.type());
					paramObj.put("isRequired", apiField.isRequired());
					paramObj.put("remark", apiField.remark());
					paramObj.put("paramValue", value);
					apiParams.add(paramObj);
				});
		result.put("apiParams", apiParams);
		return result;
	}
}
