package com.wc.service;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 2014-05-09.
 */
public class ExceptionTest {

    @Test
    public void testException() {

        int i = 0;
        try {
            float result = 1 / i;
        } catch (ArithmeticException e) {
            System.out.println("000");
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.out.println("111");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("22");
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        int result = 10;
        for (int i = 0; i < list.size(); i++) {
            if (result == 10) {
                if (i < list.size() - 1) {
                    System.out.println(i + "更新后面一个");
                } else {
                    System.out.println(i + "更新第一个");
                }

            }
        }
    }

    @Test
    public void getLong() {
        for (int i = 0; i < 10; i++) {
            System.out.println(UUID.randomUUID().toString());
        }
    }
}
