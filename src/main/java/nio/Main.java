package nio;

import com.alibaba.dubbo.rpc.protocol.thrift.io.InputStreamWrapper;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * @author tangxiaoshuang
 * @date 2018/5/10 11:22
 */
public class Main {

    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test() throws Exception {
        File file = new File("D:/authpuppysyV2004.sql");
        File file1 = new File("D:/test111.sql");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1)));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        boolean flag = true;
        while(flag) {
            String  str = bufferedReader.readLine();
            if(str == null) {
                break;
            }
            if(str.toLowerCase().startsWith("insert")) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        }
        bufferedReader.close();
    }
}
