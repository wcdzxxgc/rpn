package com.wallex.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Chao.Wang on 2019/5/6.
 */
public class NumberUtil {

    /**
     * format string to num, otherwise return a null
     * @param input any string
     * @return num, otherwise a null
     */
    public static BigDecimal phaseIfNum(String input){
        try {
            return new BigDecimal(input).setScale(15, RoundingMode.HALF_UP);
        }catch (Exception e){
            return null;
        }
    }
}
