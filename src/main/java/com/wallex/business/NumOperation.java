package com.wallex.business;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by Chao.Wang on 2019/5/6.
 */
public interface NumOperation {

    void handleOperation(Stack<BigDecimal> stack);
}
