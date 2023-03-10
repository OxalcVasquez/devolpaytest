package com.devolpay.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestCliente {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void callContextSpring(){
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigEntity.class);
//        Cliente bean = context.getBean(Cliente.class);
//        bean.setId(Long.MIN_VALUE);
//        Cliente bean1 = context.getBean(Cliente.class);
//        bean.setId(8L);
//        System.out.println(bean.getId());
//        System.out.println(bean1.getId());
//        bean1.setId(90L);
//        System.out.println(bean1.getId());
//        context.close();
    }
}
