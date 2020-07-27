package com.techproed.tests;

import org.testng.annotations.Test;

public class Priority_DependsOnMethod {
    /* TestNG de test metodlari alfabetik siraya gore calisir.Yukaridan asagiya dogru calismaz.
    Test caseleri oncelik sirasina koymak icin "priority" annotation'ini kullaniriz.
    Eger ayni priority numarasi verilirse alfabetik siraya gore yurutulur.
    Test metodunda priority annotationi yoksa once calisir.
     */


    @Test(priority = 1)
    public void login(){
        System.out.println("Bu sayfa login sayfasidir");
    }

    @Test(priority = 2)
    public void homePage(){
        System.out.println("Bu sayfa home page sayfasidir");
    }

    @Test(priority = 3,dependsOnMethods = "login")
    public void search(){
        System.out.println("Bu sayfa search sayfasidir");
    }

    @Test(priority = 4,dependsOnMethods = "search")
    public void result(){
        System.out.println("Bu sayfa result sayfasidir");
    }


}
