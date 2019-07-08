package com.tradeshift.javademo;

import java.time.Duration;
import java.time.Instant;

import org.junit.Test;

public class RegexTest {

    @Test
    public void testMatchMode() {
        //greedy
        System.out.println("abbbc".matches("ab{1,3}c"));
        //Reluctant
        System.out.println("abbbc".matches("ab{1,3}?c"));
        //Possessive
        System.out.println("abbbc".matches("ab{1,3}+c"));


        System.out.println("123".matches("\\d+."));
        System.out.println("123".matches("\\d+?."));
        System.out.println("123".matches("\\d++."));


        Instant start = Instant.now();
        for (int i = 0; i <=500; i++) {
            "?x-amz-expect-ip=58.210.213.130&response-content-disposition=attachment&X-Amz-Security-Token=FQoDYXdzENP%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaDMC7Dcv2Q9nbHWvvTiKIAzUC1hFLUYleOBEWXodHZpwCwmN%2FC4pSxoauz33EdemrZ4TxJn3afJWHH3k4NJmdnjVbZZp%2FyOqfLUQ8W7aIEaXKyHPBjTKZHGBYic01TaC8FZKQ5XmpeSOhAikyKwL7dscEYWr6ummb4qqKGkmMUgPEMgvko%2F%2B5tO309YelEk%2Bp%2FF54kHHINK8iEMhrUiUToYeigaViPLiolGrG51v6WTSa3tKZreXdUMuUkmLsjKrtZSZ%2FyuVptkYbT8ITJcw2pb4K272sgBopMbLpT63u6o5p%2BMBy0UrRuBbTq%2BZIS60z88fTKYucbWP3BRbzFjUJEvigKETvODUsg1C%2Fl10aPk1NDVu%2FSUFkV9mkJ0986WW09qwhskEaa0weI14N4LYmJP6FdkPH2i1ru3Qg8ZAF0odB7GSFvRAlQYvB67e4m1LRDmFXAaF2a2XIi2oB2bWtCCqqGbMo6IqB9fASEoNeKzuAFPyN0cwCmmZ5uM901XeD7y6BoQ%2BShVCUcjDuz2B%2BjdgtfQuPsqOgKNer9%2BgF&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20190704T104505Z&X-Amz-SignedHeaders=host&X-Amz-Expires=300&X-Amz-Credential=ASIAZC5ZBVA2R2TCGEJW%2F20190704%2Fcn-north-1%2Fs3%2Faws4_request&X-Amz-Signature=825da0e8f6b6c01e3b318d7a95e00b833cb807d8adc45b7891ea7340764820c2"
                    .matches("\\?(([A-Za-z0-9-~_=%]+\\&{0,1})+)");
        }
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());

        Instant startPos = Instant.now();
        for (int i = 0; i < 500; i++) {
            "?x-amz-expect-ip=58.210.213.130&response-content-disposition=attachment&X-Amz-Security-Token=FQoDYXdzENP%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaDMC7Dcv2Q9nbHWvvTiKIAzUC1hFLUYleOBEWXodHZpwCwmN%2FC4pSxoauz33EdemrZ4TxJn3afJWHH3k4NJmdnjVbZZp%2FyOqfLUQ8W7aIEaXKyHPBjTKZHGBYic01TaC8FZKQ5XmpeSOhAikyKwL7dscEYWr6ummb4qqKGkmMUgPEMgvko%2F%2B5tO309YelEk%2Bp%2FF54kHHINK8iEMhrUiUToYeigaViPLiolGrG51v6WTSa3tKZreXdUMuUkmLsjKrtZSZ%2FyuVptkYbT8ITJcw2pb4K272sgBopMbLpT63u6o5p%2BMBy0UrRuBbTq%2BZIS60z88fTKYucbWP3BRbzFjUJEvigKETvODUsg1C%2Fl10aPk1NDVu%2FSUFkV9mkJ0986WW09qwhskEaa0weI14N4LYmJP6FdkPH2i1ru3Qg8ZAF0odB7GSFvRAlQYvB67e4m1LRDmFXAaF2a2XIi2oB2bWtCCqqGbMo6IqB9fASEoNeKzuAFPyN0cwCmmZ5uM901XeD7y6BoQ%2BShVCUcjDuz2B%2BjdgtfQuPsqOgKNer9%2BgF&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20190704T104505Z&X-Amz-SignedHeaders=host&X-Amz-Expires=300&X-Amz-Credential=ASIAZC5ZBVA2R2TCGEJW%2F20190704%2Fcn-north-1%2Fs3%2Faws4_request&X-Amz-Signature=825da0e8f6b6c01e3b318d7a95e00b833cb807d8adc45b7891ea7340764820c2"
                    .matches("\\?(([A-Za-z0-9-~_=%]++\\&{0,1})+)");
        }
        Instant endPos = Instant.now();
        System.out.println(Duration.between(startPos, endPos).toMillis());
    }
}
