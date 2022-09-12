package com.yy.st.thread;

/**
 * @author yuyou
 * @since 2022/9/12 15:07
 */
public class VolatileTest {
    private int x = 0;
    private volatile boolean v = false;

    public void write() {
        x = 42;
        v = true;
    }

    public void read() {
        if (v) {
            System.out.println(x);

        }
    }

}
