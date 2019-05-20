package com.wallex.business.impl;

import com.wallex.business.NumOperation;
import com.wallex.common.Constants;

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
        BigDecimal result = new BigDecimal(Math.sqrt(d.doubleValue())).setScale(Constants.INNER_SCALES, RoundingMode.HALF_UP);
        stack.push(result);
    }
}
