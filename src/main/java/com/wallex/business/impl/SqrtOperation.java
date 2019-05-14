package com.wallex.business.impl;

import com.wallex.business.NumOperation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

/**
 * Created by Chao.Wang on 2019/5/6.
 */
public class SqrtOperation implements NumOperation {
    @Override
    public void handleOperation(Stack<BigDecimal> stack) {
        BigDecimal d = stack.pop();
        BigDecimal result = new BigDecimal(Math.sqrt(d.doubleValue()));
        stack.push(result);
    }
}
