package huisedebi.zjb.mylibrary.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public final class GsonUtils {

	public static <T> T parseJSON(String json, Class<T> clazz) {
		Gson gson = new Gson();
		T info = gson.fromJson(json, clazz);
		return info;
	}
	
	/**
	 * Type type = new  TypeToken<ArrayList<TypeInfo>>(){}.getType();
	   <br>Type所在的包：java.lang.reflect
	   <br>TypeToken所在的包：com.google.gson.reflect.TypeToken	
	 * @param type
	 * @return
	 */
	public static <T> T parseJSONArray(String jsonArr, Type type) {
		Gson gson = new Gson();
		T infos = gson.fromJson(jsonArr, type);
		return infos;
	}

	public static String parseObject(Object object) {
		Gson gson = new Gson();
		String json = gson.toJson(object);
		return json;
	}
	
	private GsonUtils(){}
}
