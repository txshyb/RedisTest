package GsonTest;

import GsonTest.test.Book;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import javax.xml.stream.XMLStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        new Test().test();
    }
    public void test() {
        Gson gson = new GsonBuilder().registerTypeAdapter(Integer.class,new IntegerDefault0Adapter()).create();
/*
        DevLog devLog = new DevLog(1,"ip","port");
        String str = gson.toJson(devLog);
        System.out.println(str);
    //    System.out.println(gson.toJson(str));
        DevLogBasic logBasic = gson.fromJson(gson.toJson(devLog), DevLogBasic.class);
        System.out.println(logBasic);

       */
/* String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);
        List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {}.getType());
*/
/*        HashMap<String,String> map = new HashMap<>();
        String str = "(?<=(wd=|word=)).*?(?=(\\&|$))";
        map.put("str",str);
        map.put("sss","hdhhd");
        String s = gson.toJson(map);
        System.out.println(s);*/

        String str = "{name='', age=''}";
        Book book = gson.fromJson(str,Book.class);
        System.out.println(book);
    }

    class IntegerDefault0Adapter implements JsonSerializer<Integer>, JsonDeserializer<Integer> {
        @Override
        public Integer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            try {
                if (json.getAsString().equals("") || json.getAsString().equals("null")) {//定义为int类型,如果后台返回""或者null,则返回0
                    return null;
                }
            } catch (Exception ignore) {
            }
            try {
                return json.getAsInt();
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override
        public JsonElement serialize(Integer src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src);
        }
    }
}