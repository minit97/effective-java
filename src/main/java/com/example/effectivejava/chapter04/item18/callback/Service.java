package com.example.effectivejava.chapter04.item18.callback;

public class Service {
    public void run(FunctionToCall functionToCall) {
        System.out.println("뭐 좀 하다가...");
        functionToCall.call();
    }

    public static void main(String[] args) {
        Service service = new Service();
        BobFunction bobFunction = new BobFunction(service);
        BobFunctionWrapper bobFunctionWrapper = new BobFunctionWrapper(bobFunction);    // BobFunction의 call을 호출한다.
        bobFunctionWrapper.run();
    }
}
