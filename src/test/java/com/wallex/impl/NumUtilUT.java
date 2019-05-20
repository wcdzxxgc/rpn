package com.wallex.impl;

import com.wallex.business.NumOperation;
import com.wallex.business.impl.*;
import com.wallex.common.Constants;
import com.wallex.utils.NumberUtil;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

import static com.wallex.common.Constants.INNER_SCALES;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Chao1.Wang
 * date: 5/20/19 6:53 PM
 * description:
 */
public class NumUtilUT {


    @Test
    public void testPhaseIfNum(){
        String input = "123.0";
        BigDecimal output = NumberUtil.phaseIfNum(input);
        assertTrue(output.equals(new BigDecimal(123.0).setScale(Constants.INNER_SCALES, RoundingMode.HALF_UP)));

        input = "-123";
        output = NumberUtil.phaseIfNum(input);
        assertTrue(output.equals(new BigDecimal(-123).setScale(Constants.INNER_SCALES, BigDecimal.ROUND_HALF_UP)));

        input = "--";
        output = NumberUtil.phaseIfNum(input);
        assertNull(output);

        input = "";
        output = NumberUtil.phaseIfNum(input);
        assertNull(output);

        output = NumberUtil.phaseIfNum(null);
        assertNull(output);
    }
}
