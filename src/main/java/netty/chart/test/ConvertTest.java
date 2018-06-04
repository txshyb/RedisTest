package netty.chart.test;

import netty.chart.ChartContextConvert.ObjectConvert;
import netty.chart.entity.ChartContext;

import java.io.IOException;

/**
 * @author tangxiaoshuang
 * @date 2017/11/24 9:12
 */
public class ConvertTest {


    public static void main(String[] args) throws Exception {

        ChartContext chartContext = new ChartContext("1","你好","w lail");

        byte[] b = ObjectConvert.object2byte(chartContext);

        ChartContext c = ObjectConvert.byte2Obj(b);

        System.out.println(c);
    }
}
