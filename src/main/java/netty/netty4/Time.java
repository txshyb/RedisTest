package netty.netty4;

import java.util.Date;

public class Time {

    public Time() {
        this(System.currentTimeMillis()/1000L+2208988800L);
    }
    public Time(long value ) {
        this.value = value;
    }
    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new Date((value - 2208988800L)*1000L).toString();
    }
}
