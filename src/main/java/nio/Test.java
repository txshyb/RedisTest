package nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * @author tangxiaoshuang
 * @date 2018/4/13 17:06
 */
public class Test {

    public static void main(String[] args) throws Exception {
        new Test().test1();
    }

    private void test1() throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\Users\\Administrator\\Desktop\\randomAccessFile.txt","rw");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(20); //为Buffer进行分配20个字节
        int content = channel.read(buffer);//读取数据
        while (content != -1) {
            buffer.flip();//将Buffer从写模式切换到读模式
            while(buffer.hasRemaining()){
                System.out.print((char) buffer.get());
            }
            buffer.clear();//清空buffer内数据
            buffer.compact();//清空buffer内已经读取的数据
            content = channel.read(buffer);//读取数据
        }
    }
}
