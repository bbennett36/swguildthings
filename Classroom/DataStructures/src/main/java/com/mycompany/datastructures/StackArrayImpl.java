/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datastructures;

/**
 *
 * @author apprentice
 * @param <T>
 */
public class StackArrayImpl<T> implements Stack<T> {

    private final int arraySize = 5;
    private final T[] stackArray = (T[]) new Object[arraySize];
    private int top = -1;
    private final int size = arraySize;

    @Override
    public void push(T element) {

        if (top == size - 1) {
            System.out.println("Stack is full, can't push a value");
        } else {
            top++;
            stackArray[top] = element;
        }

    }

    @Override
    public T pop() {

        if (isEmpty()) {
            System.out.println("Stack empty");
            return null;
        } else {
            return stackArray[top--];
        }

    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    @Override
    public int size() {

        return size;

    }
}
