package com.wallex.business.impl;

import com.wallex.business.NumOperation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

/**
 * Created by Chao.Wang on 2019/5/6.
 */
public class DivideOperation implements NumOperation {
    @Override
    public void handleOperation(Stack<BigDecimal> stack) {
        BigDecimal d2 = stack.pop();
        BigDecimal d1 = stack.pop();
        BigDecimal result = d1.divide(d2, RoundingMode.HALF_UP);
        stack.push(result);
    }
}
