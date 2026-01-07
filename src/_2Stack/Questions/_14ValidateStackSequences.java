package _2Stack.Questions;

import java.util.Stack;

public class _14ValidateStackSequences
{
    public static boolean validateStackSequences(int[] pushed, int[] popped)
    {
        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for (int val : pushed)
        {
            stack.push(val);

            while (!stack.isEmpty() && stack.peek() == popped[j])
            {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args)
    {
        // ✅ Case 1: Valid stack sequence (Should return true)
        int[] pushed1 = {1, 2, 3, 4, 5};
        int[] popped1 = {4, 5, 3, 2, 1};
        System.out.println("Case 1 (Expected: true): " + validateStackSequences(pushed1, popped1));

        // ❌ Case 2: Invalid stack sequence (Should return false)
        int[] pushed2 = {1, 2, 3, 4, 5};
        int[] popped2 = {4, 3, 5, 1, 2};
        System.out.println("Case 2 (Expected: false): " + validateStackSequences(pushed2, popped2));
    }

}

/*
🔄 VALIDATE STACK SEQUENCES

Given two arrays: pushed[] and popped[]
Goal: Check if the popped[] sequence is valid for stack operations on pushed[].

Steps:
1. Use a stack.
2. Iterate through pushed[] and push each element.
3. After each push, keep popping while stack.top == popped[j].
4. If you reach the end and stack is empty → valid sequence.

Time: O(n)
Space: O(n)
*/


/*
==============================
CASE 1 (VALID)
pushed = [1, 2, 3, 4, 5]
popped = [4, 5, 3, 2, 1]
==============================

stack = []
j = 0

--------------------------------
val = 1
push 1
stack = [1]

top == popped[0]? 1 == 4 ❌
(no pop)

--------------------------------
val = 2
push 2
stack = [1, 2]

top == popped[0]? 2 == 4 ❌
(no pop)

--------------------------------
val = 3
push 3
stack = [1, 2, 3]

top == popped[0]? 3 == 4 ❌
(no pop)

--------------------------------
val = 4
push 4
stack = [1, 2, 3, 4]

top == popped[0]? 4 == 4 ✅
pop → stack = [1, 2, 3]
j = 1

top == popped[1]? 3 == 5 ❌
(stop popping)

--------------------------------
val = 5
push 5
stack = [1, 2, 3, 5]

top == popped[1]? 5 == 5 ✅
pop → stack = [1, 2, 3]
j = 2

top == popped[2]? 3 == 3 ✅
pop → stack = [1, 2]
j = 3

top == popped[3]? 2 == 2 ✅
pop → stack = [1]
j = 4

top == popped[4]? 1 == 1 ✅
pop → stack = []
j = 5

--------------------------------
END:
stack is empty → TRUE
--------------------------------
OUTPUT: true
--------------------------------



==============================
CASE 2 (INVALID)
pushed = [1, 2, 3, 4, 5]
popped = [4, 3, 5, 1, 2]
==============================

stack = []
j = 0

--------------------------------
val = 1
push 1
stack = [1]

1 == 4 ❌

--------------------------------
val = 2
push 2
stack = [1, 2]

2 == 4 ❌

--------------------------------
val = 3
push 3
stack = [1, 2, 3]

3 == 4 ❌

--------------------------------
val = 4
push 4
stack = [1, 2, 3, 4]

4 == 4 ✅
pop → stack = [1, 2, 3]
j = 1

top == popped[1]? 3 == 3 ✅
pop → stack = [1, 2]
j = 2

top == popped[2]? 2 == 5 ❌
(stop popping)

--------------------------------
val = 5
push 5
stack = [1, 2, 5]

top == popped[2]? 5 == 5 ✅
pop → stack = [1, 2]
j = 3

top == popped[3]? 2 == 1 ❌

--------------------------------
END:
stack NOT empty → FALSE
--------------------------------
OUTPUT: false
--------------------------------
*/
