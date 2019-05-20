package com.wallex.impl;

import com.wallex.business.NumOperation;
import com.wallex.business.impl.*;
import com.wallex.common.Constants;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.wallex.common.Constants.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

/**
 * Created by Chao1.Wang
 * date: 5/20/19 6:53 PM
 * description:
 */
public class NumOperationUT {

    private Stack<BigDecimal> stack = new Stack<>();
    @Before
    public void prepare(){
        stack.clear();
        stack.push(new BigDecimal(3).setScale(INNER_SCALES, RoundingMode.HALF_UP));
        stack.push(new BigDecimal(4).setScale(INNER_SCALES, RoundingMode.HALF_UP));
    }

    @Test
    public void testAddOperation(){
        NumOperation operation = new AddNumOperation();
        operation.handleOperation(stack);
        assertTrue(stack.pop().equals(new BigDecimal(7).setScale(INNER_SCALES, BigDecimal.ROUND_HALF_UP)));
    }

    @Test
    public void testDivideOperation(){
        NumOperation operation = new DivideOperation();
        operation.handleOperation(stack);
        assertTrue(stack.pop().equals(new BigDecimal(3/4.0).setScale(INNER_SCALES, RoundingMode.HALF_UP)));
    }

    @Test
    public void testMultiplyOperation(){
        NumOperation operation = new MultiplyOperation();
        operation.handleOperation(stack);
        assertTrue(stack.pop().equals(new BigDecimal(12).setScale(INNER_SCALES, RoundingMode.HALF_UP)));
    }

    @Test
    public void testSqrtOperation(){
        NumOperation operation = new SqrtOperation();
        operation.handleOperation(stack);
        assertTrue(stack.pop().equals(new BigDecimal(2).setScale(INNER_SCALES, RoundingMode.HALF_UP)));
    }

    @Test
    public void testSubtractOperation(){
        NumOperation operation = new SubtractOperation();
        operation.handleOperation(stack);
        assertTrue(stack.pop().equals(new BigDecimal(-1).setScale(INNER_SCALES, RoundingMode.HALF_UP)));
    }
}
