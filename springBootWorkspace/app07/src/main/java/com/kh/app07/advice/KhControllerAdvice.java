package com.kh.app07.advice;

import com.kh.app07.annotation.KhAno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = { Controller.class , RestController.class } )
public class KhControllerAdvice {

    @ExceptionHandler(NullPointerException.class)
    public void m01(Model model){
        System.out.println("KhControllerAdvice.m01");
    }

    @ExceptionHandler(ArithmeticException.class)
    public void m02(){
        System.out.println("KhControllerAdvice.m02");
    }

    @ExceptionHandler(Exception.class)
    public void m03(){
        System.out.println("KhControllerAdvice.m03");
    }

}
