package GsonTest;

import GsonTest.test.Book;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * @author tangxiaoshuang
 * @date 2018/1/18 10:41
 */
public class Main {

    public static void main(String[] args) {
        Book book = new Book(){};
     //   System.out.println(book.str);

        if("".equals(null)) {
            System.out.println("dsdsd");
        };


        Gson gson = new Gson();
        String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);
        List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {}.getType());

    }
}
