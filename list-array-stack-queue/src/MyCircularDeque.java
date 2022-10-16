/**
 * @author zhangdongdong <zhangdongdong@kuaishou.com>
 * Created on 2022-10-16
 */
public class MyCircularDeque {
    public int[] elements;
    public int size;
    public int capacity;
    public int l, r;

    public MyCircularDeque(int k) {
        elements = new int[k + 1];
        capacity = k;
        size = 0;
        l = 0;
        r = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        size ++;
        if (size > 1) {
            l = (l - 1 + capacity) % capacity;
        }
        elements[l] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        size ++;
        if (size > 1) {
            r = (r + 1) % capacity;
        }
        elements[r] = value;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        size --;
        if (size == 0) {
            l = 0;
            r = 0;
        } else {
            l  = (l + 1) % capacity;
        }
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        size --;
        if (size == 0) {
            l = 0;
            r = 0;
        } else {
            r  = (r - 1 + capacity) % capacity;
        }
        return true;
    }

    public int getFront() {
        return size == 0 ? -1 : elements[l];
    }

    public int getRear() {
        return size == 0 ? -1 : elements[r];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= capacity;
    }
}
