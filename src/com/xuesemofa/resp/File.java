package com.xuesemofa.resp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件操作
 * 不要采用try-finally,而是try-with-resources
 */
class Files {

    public static void readFile(String path, String dst) {
        try (
                InputStream in = new FileInputStream(path);
//                OutputStream out = new FileOutputStream(dst)
        ) {
            byte[] buf = new byte[1024];
            int i;
            while ((i = in.read(buf)) >= 0) {
                System.out.println(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readFile("D:\\work\\新建文本文档.txt", "/");
    }
}
