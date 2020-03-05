package com.zkx.item.utils;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class JsonUtils {


    public static String toJson(Object obj) {
        if (JSONUtils.isArray(obj)) {
            return JSONArray.fromObject(obj).toString();
        }
        return JSONObject.fromObject(obj).toString();
    }
}
