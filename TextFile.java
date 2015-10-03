package com.side.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 文本文件操作类
 *
 * @author chenside
 * @since 10/3/15 11:40 AM
 */
public class TextFile extends ArrayList<String> {
    public static String read(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    stringBuilder.append(s).append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName, String spliter) {
        super(Arrays.asList(read(fileName).split(spliter)));
        if (get(0).equals(""))
            remove(0);
    }

    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                for (String item : this) {
                    out.println(item);
                }
            } finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file = read("data.txt");
        write("text.txt", file);

        TextFile textFile = new TextFile("text.txt");
        textFile.add("hello");
        textFile.write("text2.txt");

        TreeSet<String> words = new TreeSet<>(new TextFile("data.txt", "\\w+"));
        System.out.println(words);
        System.out.println(words.headSet("a"));
    }
}
