package com.example.effectivejava.chapter02.item13.treeset;

import com.example.effectivejava.chapter02.item13.PhoneNumber;

import java.util.*;

public class TreeSetExample {

    public static void main(String[] args) {
//        TreeSet<Integer> numbers = new TreeSet<>();
//        numbers.add(10);
//        numbers.add(4);
//        numbers.add(6);

        TreeSet<PhoneNumber> numbers = new TreeSet<>(Comparator.comparingInt(PhoneNumber::hashCode));
        Set<PhoneNumber> phoneNumbers = Collections.synchronizedSet(numbers);
        phoneNumbers.add(new PhoneNumber(123, 456, 780));
        phoneNumbers.add(new PhoneNumber(123, 456, 7890));
        phoneNumbers.add(new PhoneNumber(123, 456, 789));

        for (PhoneNumber number : numbers) {
            System.out.println(number);
        }
    }
}
