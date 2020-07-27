package com.techproed.paralelTesting;

import org.testng.annotations.Test;

public class Test2 {
    @Test
    public void method4(){
        System.out.println("Test 2 - Method 4");
        System.out.println("Method 4 - Thread ID : "+ Thread.currentThread().getId());
    }
    @Test
    public void method2(){
        System.out.println("Test 2 - Method 5");
        System.out.println("Method 2 - Thread ID : "+ Thread.currentThread().getId());
    }
}
