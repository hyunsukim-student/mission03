package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Queue;

public class LinkedQueue<E> extends DoublyLinkedList<E> implements Queue<E> {

    DoublyLinkedList<E> dou = new DoublyLinkedList<>();
    SinglyLinkedList<E> sing = new SinglyLinkedList<>();

    @Override
    public int size() {
        return dou.size();
    }

    @Override
    public boolean isEmpty() {
        return dou.isEmpty();
    }

    @Override
    public void offer(E element) {
        dou.addFirst(element);
    }

    @Override
    public E peek() {
        return dou.last();
    }

    @Override
    public E poll() {
        return dou.removeLast();
    }

    @Override
    public void printQueue() {
        int s = dou.size();
        reverse();
        for (int i = 0; i < s; i++) {
            System.out.println(dou.get(i));
        }
    }

    @Override
    public void transfer(Queue<E> into) {
        if(into == null){
            return;
        }
        reverse();
        while (!isEmpty()){
            E num = peek();
            poll();
            into.offer(num);
        }
    }

    @Override
    public void reverse() {
        for(int i = 0; i < size(); i++){
            E num = peek();
            poll();
            dou.insert(num, i);

        }
    }

    @Override
    public void merge(Queue<E> from) {
        if(from == null){
            return;
        }
        int s = from.size();
        System.out.println("s" + s);
        //for(int i = s-1; i >= 0; i--){
        for(int i = 0; i < s; i++){
            //E num = peek();
            E num = dou.get(i);
            //poll();
            System.out.println(num);
            offer(num);
        }
    }
}
