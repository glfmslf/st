package com.yy.st.thread;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yuyou
 * @since 2022/9/11 16:35
 */
@Getter
public class CountTest {

    private volatile AtomicInteger count = new AtomicInteger(0);



    public void cal() {
        int index = 0;
        while (index++ < 10000) {
            count.getAndIncrement();
        }
    }

    public void clear() {
        count.set(0);

    }
}
