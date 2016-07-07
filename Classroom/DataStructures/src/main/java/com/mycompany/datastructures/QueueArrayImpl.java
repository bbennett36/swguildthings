/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datastructures;

/**
 *
 * @author apprentice
 */
public class QueueArrayImpl<T> implements Queue<T> {

    private int arraySize = 5;
    private T[] queueArray;
//            = (T[]) new Object[arraySize];
    private int front = 0;
    private int next = 0;
    private int size = 0;
    
    @Override
    public void resize(int capacity)   {
    
        T[] tmp = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++)
            tmp[i] = queueArray[(front + i) % queueArray.length];

        queueArray = tmp;
        front = 0;
        next = size;
    }


    @Override
    public void enqueue(T element) {

        if (size == queueArray.length) {
            System.out.println("Stack is full");
        } else {
            queueArray[next] = element;
            next = (next + 1) % queueArray.length;
            size++;
        }

    }

    @Override
    public T dequeue() {
        if (size == 0) {
            System.out.println("Cannot remove from empty queue");
        }

        T item = queueArray[front];
        queueArray[front] = null;
        front = (front + 1) % queueArray.length;
        size--;

        return item;

    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

}
