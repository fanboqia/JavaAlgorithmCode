package com.lintcode.HuaWei;

import java.util.Stack;

public class Expression {

    //预处理替换大括号小括号
    public static String preprocessor(String str){
        char[] chrs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chrs.length; i++){
            if(chrs[i] == '[' || chrs[i] == '{'){
                sb.append('(');
                continue;
            }
            if(chrs[i] == ']' || chrs[i] == '}'){
                sb.append(')');
                continue;
            }
            if(i == 0 && chrs[i] == '-'){
                sb.append('0');
                sb.append(chrs[i]);
                continue;
            }
            if(i != 0 && (chrs[i-1] == '(' || chrs[i-1] == '[' || chrs[i-1] == '{') && chrs[i] == '-'){
                sb.append('0');
                sb.append(chrs[i]);
                continue;
            }
            sb.append(chrs[i]);
        }

        String str2 = sb.toString();
        str2 = str2.replaceAll("(\\(0-\\d)","($1)");
        return str2;
    }

    //获取符号的优先级
    public static int getPriority(char ch){
        switch(ch){
            case '(': return 1;
            case '+': case '-': return 2;
            case '*': case '/': return 3;
            case ')': return 4;
        }
        return -1;
    }

    public static boolean isOperator(char ch){
        return ch == '/' || ch == '*' || ch == '+' || ch == '-';
    }

    public static boolean isLeftBracket(char ch){
        return ch == '(';
    }

    public static boolean isRightBracket(char ch){
        return ch == ')';
    }

    public static boolean isBracket(char ch){
        return isLeftBracket(ch) || isRightBracket(ch);
    }

    public static String convertMidToPostExp(String str){
        //1）如果遇到数字，直接添加到后缀表达式末尾；
        //2）如果遇到运算符+、-、*、/：
        //先判断栈是否为空。若是，则直接将此运算符压入栈。若不是，则查看当前栈顶元素。若栈顶元素优先级大于或等于此操作符级别，则弹出栈顶元素，将栈顶元素添加到后缀表达式中，并继续进行上述判断。如果不满足上述判断或者栈为空，将这个运算符入栈。要注意的是，经过上述步骤，这个运算符最终一定会入栈。
        //3）如果遇到括号：
        //如果是左括号，直接入栈。如果是右括号，弹出栈中第一个左括号前所有的操作符，并将左括号弹出。（右括号别入栈）。
        //4）字符串遍历结束后，如果栈不为空，则弹出栈中所有元素，将它们添加到后缀表达式的末尾，直到栈为空。
        Stack<Character> st = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        char[] chrs = str.toCharArray();
        for(int i = 0; i < chrs.length; i++){
            if(Character.isDigit(chrs[i])){
                sb.append(chrs[i]);
            }else if(isOperator(chrs[i])){
                if(st.isEmpty()){
                   st.push(chrs[i]);
                }else{
                    while(!st.isEmpty() && getPriority(st.peek()) >= getPriority(chrs[i])){
                        sb.append(st.pop());
                    }
                    st.push(chrs[i]);
                }
            }else if(isBracket(chrs[i])){
                if(isLeftBracket(chrs[i])){
                    st.push(chrs[i]);
                }else{
                    while(!isLeftBracket(st.peek())){
                        sb.append(st.pop());
                    }
                    st.pop();
                }
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }

    public static int calculator(String string)
    {
        //计算后缀表达式的值，默认中缀表达式所有数字都是一位的，在0-9之间
        Stack<Integer> mystack = new Stack<Integer>();
        char[] str = string.toCharArray();
        int size = string.length();
        int num1, num2, num3 = 0;
        for (int i = 0; i < size; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                mystack.push(str[i] - '0');
            }
            else {
                num2 = mystack.peek();
                mystack.pop();
                num1 = mystack.peek();
                mystack.pop();
                if (str[i] == '+') {
                    num3 = num1 + num2;
                }
                else if (str[i] == '-') {
                    num3 = num1 - num2;
                }
                else if (str[i] == '*') {
                    num3 = num1 * num2;
                }
                else if (str[i] == '/') {
                    num3 = num1 / num2;
                }
                mystack.push(num3);
            }
        }
        return mystack.peek();
    }

    public static void main(String[] args){
        String str="3+2*{1+2*[-4/(8-6)+7]}";
        String str2="-3+2*{1+2*[-4/(8-6)+7]}";
        //String suffix = "123-4*+42/+";
        System.out.println(preprocessor("-3+2*{1+2*[-4/(8-6)+7]}"));
        String suffix = convertMidToPostExp(preprocessor(str2));
        System.out.println(suffix);
        int res = calculator(suffix);
        System.out.println(res);
    }
}
