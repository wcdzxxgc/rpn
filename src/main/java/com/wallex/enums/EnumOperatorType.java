package com.wallex.enums;

/**
 * Created by Chao.Wang on 2019/5/6.
 */
public enum  EnumOperatorType {
    UNKNOWN("Unknown"), CLEAR("clear"), UNDO("undo"), ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/"), SQRT("sqrt");

    private String desc;

    public String getDesc(){
        return desc;
    }

    EnumOperatorType(String desc){
        this.desc = desc;
    }

    public static EnumOperatorType fromDesc(String desc){
        if (desc == null) return UNKNOWN;
        for (EnumOperatorType type : EnumOperatorType.values()){
            if (type.desc.equalsIgnoreCase(desc)){
                return type;
            }
        }
        return UNKNOWN;
    }
}
