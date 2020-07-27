package com.techproed.tests;

import org.testng.annotations.*;

public class TestNGAnnotations {
    //create setUp() method ve @BeforeMethod annotation kullan
    @BeforeMethod
    public void setUp(){
        //@BeforeMethod , her @Test annotationina sahip methodtan once calisir
        System.out.println("====Before Method====");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("====Before Class====");
    }

    @Test
    public void test1(){
        //@Test test caseleri veya test methodlaro create etmek icin kullanilir.
        //@Test i calistirmamizi(run) saglar.
        System.out.println("Bu Test 1 methodudur");
    }

    @Test
    public void test2(){
        System.out.println("Bu Test 2 methodudur");
    }

    @Ignore
    @Test
    public void test3(){
        System.out.println("Bu Test 3 methodudur");
    }

    @AfterMethod
    public void afterMethod(){
        //Her @Test annotation dan sonra calisir
        System.out.println("====After Method====");
    }

    @AfterClass
    public void afterClass(){
        //tum classin sonunda sadece bir defa calisir
        System.out.println("====After Class====");
    }
}
