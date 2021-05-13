package com.cest.dataStructures.stackAndQueue.leetcodePro;

import com.cest.dataStructures.stackAndQueue.arrayStack.ArrayStack;
import com.cest.dataStructures.stackAndQueue.arrayStack.Stack;

public class Solution {

    public boolean isValid(String s) {
        Stack<Character> arrayStack = new ArrayStack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                arrayStack.push(c);
            } else {
                if (arrayStack.isEmpty())
                    return false;

                Character pop = arrayStack.pop();
                if (c == ')' && pop != '(')
                    return false;
                if (c == ']' && pop != '[')
                    return false;
                if (c == '}' && pop != '{')
                    return false;
            }
        }

        return arrayStack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println((new Solution()).isValid("()[]{}}"));
    }
}
