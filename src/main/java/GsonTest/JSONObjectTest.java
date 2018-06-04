package GsonTest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.sf.json.JSONObject;

import java.util.HashMap;

/**
 * @author tangxiaoshuang
 * @date 2017/11/17 16:54
 */
public class JSONObjectTest {

    static Gson gson = new Gson();

    public static void main(String[] args) {
        DevLog devLog = new DevLog(1,"192.168.1.1","22");
        HashMap<String,Object> resMap = new HashMap();
        resMap.put("id",devLog);
        JSONObject jsonObject = JSONObject.fromObject(gson.toJson(resMap));

        Object obj = jsonObject.get("id");
        DevLog d = (DevLog)JSONObject.toBean((JSONObject) obj,DevLog.class);
        System.out.println(d.getClass());
        System.out.println(d);
        System.out.println(obj.getClass());
        System.out.println(obj);

    }
}
