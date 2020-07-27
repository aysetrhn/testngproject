package com.techproed.paralelTesting;

import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void method1(){
        System.out.println("Test 1 - Method 1");
        System.out.println("Method 1 - Thread ID : "+ Thread.currentThread().getId());
    }
    @Test
    public void method2(){
        System.out.println("Test 1 - Method 2");
        System.out.println("Method 2 - Thread ID : "+ Thread.currentThread().getId());
    }
    @Test
    public void method3(){
        System.out.println("Test 1 - Method 3");
        System.out.println("Method 3 - Thread ID : "+ Thread.currentThread().getId());
    }
}
