package cloud;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author tangxiaoshuang
 * @date 2018/2/28 10:51
 */
public class Main {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        for (int i=0; i<100; i++) {
            HttpGet httpGet = new HttpGet("http://localhost:9000/invoke");
            HttpResponse httpResponse = httpClient.execute(httpGet);
            System.out.println(EntityUtils.toString(httpResponse.getEntity()));
        }
    }
}
