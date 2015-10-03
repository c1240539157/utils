package com.side.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 读取二进制文件
 *
 * @author chenside
 * @since 10/3/15 12:26 PM
 */
public class BinaryFile {
    public static byte[] read(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] data = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(data);
            return data;
        } finally {
            bufferedInputStream.close();
        }
    }

    public static byte[] read(String file) throws IOException {
        return read(new File(file).getAbsoluteFile());
    }

    public static void main(String[] args) throws IOException {
        byte[] data = read("data.bat");
        System.out.println(new String(data, "UTF-8"));
    }
}
