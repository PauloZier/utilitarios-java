package utilitarios.json;

import com.google.gson.Gson;

public final class JsonUtils {

	private JsonUtils() { }
	
	public static String objectToJson(Object obj) {
		
		Gson gson = new Gson();
		
		return gson.toJson(obj);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T jsonToObject(String json, Class<?> cls) {
		
		Gson gson = new Gson();
		
		return (T)gson.fromJson(json, cls);
	}
}
