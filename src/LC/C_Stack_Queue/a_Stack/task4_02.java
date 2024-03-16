/*
 * Ant Group
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package LC.C_Stack_Queue.a_Stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author weikeyao
 * @version task4_02.java, v 0.1 2024年01月11日 21:51 weikeyao
 */
public class task4_02 {

    // 232. 用栈实现队列
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    /** Initialize your data structure here. */
//    public MyQueue() {
//        stackIn = new Stack<>(); // 负责进栈
//        stackOut = new Stack<>(); // 负责出栈
//    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        dumpstackIn();
        return stackOut.pop();
    }

    /** Get the front element. */
    public int peek() {
        dumpstackIn();
        return stackOut.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
    private void dumpstackIn(){
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }

    //20. Valid Parentheses
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(")");
            } else if (s.charAt(i) == '{') {
                stack.add("}");
            } else if (s.charAt(i) == '[') {
                stack.add("]");
            } else if (s.charAt(i) == ']') {
                if (stack.empty() || !stack.pop().equals("]")) return false;
            } else if (s.charAt(i) == '}') {
                if (stack.empty() || !stack.pop().equals("}")) return false;
            } else if (s.charAt(i) == ')') {
                if (stack.empty() || !stack.pop().equals(")")) return false;
            }
        }
        return stack.empty();
    }

    // 150. Evaluate Reverse Polish Notation
    // 原理是二叉树的后续遍历
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList();
        for (String s : tokens) {
            if ("+".equals(s)) {        // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

    // 155. 最小栈      单调栈

    // 739. 每日温度    单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            while(stack.size() > 0 && temperatures[stack.peekLast()] < temperatures[i]){
                int target = stack.removeLast();
                res[target] = i - target;
            }
            stack.addLast(i);
        }
        return res;
    }
}