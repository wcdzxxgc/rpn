package com.wallex;

import com.wallex.business.NumOperation;
import com.wallex.business.impl.*;
import com.wallex.enums.EnumOperatorType;
import com.wallex.utils.NumberUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Chao.Wang on 2019/5/6.
 */
public class Calculator {

    /**
     * Calculate Rule Map
     */
    private Map<EnumOperatorType, NumOperation> operationMap = new HashMap<>();

    /**
     * Current stack
     */
    private Stack<BigDecimal> stack = new Stack<>();

    /**
     * History stack to record all input included num and operator
     */
    private Stack<String> historyStack = new Stack<>();

    private int displayScales = 10;
    /**
     * Mark if current calculator met error
     */
    private boolean error = false;

    /**
     * Init all calculate rules, it supports extending any regular number operations
     */
    private void init(){
        operationMap.put(EnumOperatorType.ADD, new AddNumOperation());
        operationMap.put(EnumOperatorType.SUBTRACT, new SubtractOperation());
        operationMap.put(EnumOperatorType.MULTIPLY, new MultiplyOperation());
        operationMap.put(EnumOperatorType.DIVIDE, new DivideOperation());
        operationMap.put(EnumOperatorType.SQRT, new SqrtOperation());
    }

    /**
     * Handle input line by line
     * @param line input line
     * @param rebuilding mark if current calling is from undo operation
     */
    private void handleInputLine(String line, boolean rebuilding){
        String[] items = line.split("[ ]");
        int itemIndex = 0;
        int i = 0;
        for (; i < items.length; i++) {
            BigDecimal input = NumberUtil.phaseIfNum(items[i]);
            try {
                if (input != null){
                    stack.add(input);
                    if (!rebuilding){
                        historyStack.push(items[i]);
                    }
                }else {
                    EnumOperatorType operatorType = EnumOperatorType.fromDesc(items[i]);
                    //Clear and undo are not regular number operator, we handle them specially here
                    if (operatorType == EnumOperatorType.CLEAR && !rebuilding){
                        handleClearOperation();
                    }else if (operatorType == EnumOperatorType.UNDO && !rebuilding){
                        handleUndoOperation();
                    }else {
                        operationMap.get(operatorType).handleOperation(stack);
                        if (!rebuilding){
                            historyStack.push(operatorType.getDesc());
                        }
                    }
                }
            } catch (Exception e){
                error = true;
                System.out.println(String.format("operator %s (position: %s): insucient parameters", items[i], itemIndex));
                break;
            } finally {
                itemIndex += (items[i].length()+1);
            }
        }
        if (error){
            if (itemIndex < line.length()){
                System.out.println(String.format("(the %s were not pushed on to the stack due to the previous error)", line.substring(itemIndex)));
            }
        }
    }

    /**
     * Handle clear operation specially
     */
    private void handleClearOperation(){
        error = false;
        stack.clear();
        historyStack.clear();
    }

    /**
     * Handle undo operation specially
     */
    private void handleUndoOperation(){
        error = false;
        historyStack.pop();
        stack.clear();
        String fullCommand = String.join(" ", historyStack);
        handleInputLine(fullCommand, true);
    }

    private void printStack(){
        System.out.print("stack: ");
        for (BigDecimal d : stack){
            System.out.print(d.setScale(displayScales, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString()+" ");
        }
        System.out.println();
    }

    /**
     * Start and init calculator
     */
    public void start(){
        init();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while(true){
            if (line != null && !line.isEmpty()){
                handleInputLine(line, false);
                printStack();
            }
            line = scanner.nextLine();
        }
    }

    public static void main(String args[]) throws Exception{
        System.out.println("RPN Started");
        Calculator calculator = new Calculator();
        calculator.start();
    }
}
