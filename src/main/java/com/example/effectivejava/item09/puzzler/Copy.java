package com.example.effectivejava.item09.puzzler;

import java.io.*;

public class Copy {
    private static final int BUFFER_SIZE = 8 * 1024;

    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        } finally {
            try {
                out.close();
            } catch (IOException e) {   // IOException 이 아니라 런타임ex이 터진다면 catch 문 X
                // TODO 안전한가?
            }

            try {
                in.close();
            } catch (IOException e) {
                // TODO 안전한가?
            }

        }
    }

    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src, dst);
    }
}
