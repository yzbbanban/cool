package com.riti.cool.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.riti.cool.entity.Temperature;
import com.riti.rfid.entity.RfidOrder;

@Repository("jsonParseUtils")
public class JsonParseUtils {
	public final ObjectMapper mapper = new ObjectMapper();

	private JavaType getCollectionType(Class<?> collectionClass,
			Class<?>... elementClasses) {

		return mapper.getTypeFactory().constructParametricType(collectionClass,
				elementClasses);
	}

	/**
	 * 解析为集合对象
	 * 
	 * @param tempJson
	 * @param collectionClass
	 * @param elementClasses
	 * @return
	 */
	public <T> List<T> getObjList(String tempJson, Class<?> collectionClass,
			Class<?>... elementClasses) {
		try {
			return (List<T>) mapper.readValue(tempJson,
					getCollectionType(ArrayList.class, Temperature.class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 解析为集合对象
	 * 
	 * @param tempJson
	 * @param collectionClass
	 * @param elementClasses
	 * @return
	 */
	public <T> List<T> getOrderObjList(String orderJson,
			Class<?> collectionClass, Class<?>... elementClasses) {
		try {
			return (List<T>) mapper.readValue(orderJson,
					getCollectionType(ArrayList.class, RfidOrder.class));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 解析为单个对象
	 * 
	 * @param json
	 * @param cls
	 * @return
	 */
	public <T> T getObj(String json, Class<T> cls) {
		try {
			return (T) mapper.readValue(json, cls);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
