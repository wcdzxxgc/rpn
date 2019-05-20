package com.wallex.business.impl;

import com.wallex.business.NumOperation;
import com.wallex.common.Constants;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

/**
 * Created by Chao.Wang on 2019/5/6.
 */
public class MultiplyOperation implements NumOperation {
    @Override
    public void handleOperation(Stack<BigDecimal> stack) {
        BigDecimal d2 = stack.pop();
        BigDecimal d1 = stack.pop();
        BigDecimal result = d1.multiply(d2).setScale(Constants.INNER_SCALES, RoundingMode.HALF_UP);
        stack.push(result);
    }
}
