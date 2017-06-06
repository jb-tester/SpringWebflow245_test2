package com.mytests.spring.webflow244.javaConfig.test2;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 10/21/2016.
 * Project: test1
 * *******************************
 */
@Component
public class Service1Impl implements Service1 , Serializable{
    @Override
    public String str1() {
        return "str1";
    }

    @Override
    public String getStr2() {
        return "str2";
    }
}
