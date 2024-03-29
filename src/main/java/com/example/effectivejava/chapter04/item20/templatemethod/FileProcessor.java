package com.example.effectivejava.chapter04.item20.templatemethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.BiFunction;

public class FileProcessor {
    private String path;

    public FileProcessor(String path) {
        this.path = path;
    }

    public final int process(BiFunction<Integer, Integer, Integer> operator) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            int result = 0;
            String line  = null;
            while((line = reader.readLine()) != null) {
//                result = getResult(result, Integer.parseInt(line)); // 템플릿 메서드 패턴
                result = operator.apply(result, Integer.parseInt(line));    // 템플릿 콜백 패턴
            }
            return result;
        } catch (IOException e) {
            throw new IllegalArgumentException(path + "에 해당하는 파일이 없습니다.", e);
        }
    }

//    protected abstract int getResult(int result, int number);
}
