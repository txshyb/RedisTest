package Redis;


import com.google.gson.Gson;
import entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class TestListener {
    Gson gson = new Gson();
    private static final Logger LOGGER = LoggerFactory.getLogger(TestListener.class);

    public void handleMessage(Serializable message){
        if(message instanceof  String ) {
            System.out.println(message.toString());
        }
        if(message instanceof Person) {
            LOGGER.info(message.toString());
        }
    }


}
