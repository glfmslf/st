package com.yy.st.excel;

import java.io.File;
import java.io.IOException;

/**
 * @author yuyou
 * @since 2022/8/9 15:16
 */
public class HookTest {
    private static String path = "/Users/yuyou/Downloads/";

    private static String fileName = "lock";

    public static void main(String[] args) throws InterruptedException {
        checkExistFile();
//        addHook();
        deletedFile();
        for (int i = 0;i < 100 ; i++) {
            System.out.println("the application is running");
        }
        Thread.sleep(5000);
    }

    public static void checkExistFile() {
        File file = new File(path + fileName);
        if (file.exists()) {
            throw new RuntimeException("Application is running not allowed repeat running");
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("kill this application");
            deletedFile();
        }));
    }

    public static void deletedFile() {
        File file = new File(path + fileName);
        if (file.exists()) {
            file.deleteOnExit();
        }
    }
}
