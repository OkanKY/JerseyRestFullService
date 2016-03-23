package com.ok.test;

import com.ok.jpa.controller.JpaController;

public class MainTest {
    public static void main(String[] args) {
    	JpaController controller =new JpaController();
    	controller.checkUserLogin("okan", "1234");
       }
}
