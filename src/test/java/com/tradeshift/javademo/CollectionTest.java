package com.tradeshift.javademo;

import java.lang.reflect.Field;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class CollectionTest {
    @Test
    public void testArrayListGrow() throws Exception {
        int iterCount = 1000000;
        Field valueField = ArrayList.class.getDeclaredField("elementData");
        valueField.setAccessible(true);


        ArrayList<String> dynamicArrayList = new ArrayList<>();
        Instant start = Instant.now();
        int eleSize = 0;
        for (int i = 0; i < iterCount; i++) {
            dynamicArrayList.add("aaaaa");
            Object[] elementData = (Object[]) valueField.get(dynamicArrayList);
            if (elementData.length > eleSize) {
                eleSize = elementData.length;
                System.out.println("ArrayList grows to " + eleSize);
            }
        }
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());

        ArrayList<String> prelocatedArrayList = new ArrayList<>(iterCount);
        Instant start1 = Instant.now();
        eleSize = 0;
        for (int i = 0; i < iterCount; i++) {
            prelocatedArrayList.add("aaaaa");
            Object[] elementData = (Object[]) valueField.get(prelocatedArrayList);
            if (elementData.length > eleSize) {
                eleSize = elementData.length;
                System.out.println("ArrayList grows to " + eleSize);
            }
        }
        Instant end1 = Instant.now();
        System.out.println(Duration.between(start1, end1).toMillis());
    }

    @Test
    public void testArrayListDelete() throws Exception {
        int iterCount = 400000;
        ArrayList<String> prelocatedArrayList = new ArrayList<>(iterCount);
        for (int i = 0; i < iterCount; i++) {
            prelocatedArrayList.add("aaaaa");
        }
        Instant start1 = Instant.now();
        for (int i = 0; i < iterCount; i++) {
            prelocatedArrayList.remove(0);
        }
        Instant end1 = Instant.now();
        System.out.println(Duration.between(start1, end1).toMillis());
    }

    @Test
    public void testlinkedListDelete() throws Exception {
        int iterCount = 400000;
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < iterCount; i++) {
            linkedList.add("aaaaa");
        }
        Instant start1 = Instant.now();
        for (int i = 0; i < iterCount; i++) {
            linkedList.removeFirst();
        }
        Instant end1 = Instant.now();
        System.out.println(Duration.between(start1, end1).toMillis());
    }


}
