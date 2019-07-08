package com.tradeshift.javademo;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class StringTest {

    @Test
    public void testConstantPool() throws NoSuchFieldException, IllegalAccessException {
        String hw0 = "Hello World";
        String hw1 = "Hello World";
        String hw2 = new String("Hello World");

        assertTrue(hw0==hw1);

        Field valueField = String.class.getDeclaredField("value");
        valueField.setAccessible(true);

        assertTrue(valueField.get(hw0)==valueField.get(hw2)); //get char value[]
    }

    @Test
    public void testStringCodeOptimizer() {
        String pooledString = "123";
        String splitString = "1" + "2" + "3";
        assertTrue(pooledString == splitString); //exactly the same pooled string
    }

    @Test
    public void testStringAppender() {
        Instant start = Instant.now();
        String str1 = "abc";
        for (int i = 0; i < 10000; i++) {
            str1 = str1 + i;
        } //not necessarily optimized
        Instant end = Instant.now();
        System.out.println(str1);
        System.out.println(Duration.between(start,end).toMillis());

        Instant start2 = Instant.now();
        String str2 = "abc";
        for (int i = 0; i < 10000; i++) {
            str2 = str2 + i;
        } //not necessarily optimized
        Instant end2 = Instant.now();
        System.out.println(str2);
        System.out.println(Duration.between(start2,end2).toMillis());

        Instant sbStart = Instant.now();
        StringBuilder sb = new StringBuilder("abc");
        for (int i = 0; i < 10000; i++) {
            sb.append(i);
        }
        String str3 = sb.toString();
        Instant sbEnd = Instant.now();
        System.out.println(str3);
        System.out.println(Duration.between(sbStart,sbEnd).toMillis());
    }

    //-xmx20M
    @Test
    public void testIntern(){
        LinkedList<String> stringList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            String genString = RandomStringUtils.random(1, false, true);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 10000; j++) {
                sb.append(genString);
            }
            String someString = sb.toString().intern();
            stringList.add(someString);
        }
        System.out.println(stringList.size());
    }

    //-xmx20M
    @Test
    public void testNotInternOOM(){
        LinkedList<String> stringList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            String genString = RandomStringUtils.random(1, false, true);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 10000; j++) {
                sb.append(genString);
            }
            String someString = sb.toString();
            stringList.add(someString);
        }
        System.out.println(stringList.size());
    }
}
