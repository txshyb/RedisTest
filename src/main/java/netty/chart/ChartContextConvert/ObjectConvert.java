package netty.chart.ChartContextConvert;

import java.io.*;

/**
 * @author tangxiaoshuang
 * @date 2017/11/23 17:39
 */
public class  ObjectConvert {

    public static <T>   byte[] object2byte(T t) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutput = new ObjectOutputStream(byteArrayOutputStream);
        objectOutput.writeObject(t);
        byteArrayOutputStream.close();
        objectOutput.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static <T> T byte2Obj(byte[] b) throws Exception {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object obj = objectInputStream.readObject();
            byteArrayInputStream.close();
            objectInputStream.close();
            return (T)obj;

    }
}
