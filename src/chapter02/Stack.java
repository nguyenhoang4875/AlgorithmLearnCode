package chapter02;

import java.util.EmptyStackException;
import java.util.Vector;

public class Stack<E> extends Vector<E> {

    public Stack() {
    }

    public E push(E item) {
        this.add(item);
        return item;

    }

    public synchronized E pop() {
        int len = this.size();
        E obj = this.peek();
        this.removeElementAt(len - 1);
        return obj;
    }

    public synchronized E peek() {
        int len = this.size();
        if (len == 0) {
            throw new EmptyStackException();
        } else {
            return this.elementAt(len - 1);
        }

    }

    public boolean empty() {
        return this.size() == 0;
    }

    public synchronized int search(Object o) {
        int i = this.lastIndexOf(o);
        return i >= 0 ? this.size() - i : -1;

    }
}
