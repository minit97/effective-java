package com.example.effectivejava.chapter02.item10.inheritance;

import com.example.effectivejava.chapter02.item10.Color;

public class SmellPointTest {
    public static void main(String[] args) {
        SmellPoint p1 = new SmellPoint(1,0, "sweet");
        ColorPoint p2 = new ColorPoint(1,0, Color.RED);
        p1.equals(p2);
    }
}
