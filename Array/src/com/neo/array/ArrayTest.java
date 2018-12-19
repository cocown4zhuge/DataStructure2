package com.neo.array;

import com.neo.array.Array;

/**
 * Created by Administrator on 2018/12/19.
 */
public class ArrayTest {
    public static void main(String[] args) {
        Array array = new Array();
        array.add(0,11);
        array.add(1,7);
        array.add(2,16);
        array.add(3,9527);
        array.add(4,26);
        System.out.println(array);

        array.addLast(99);
        System.out.println(array);

        array.addFirst(111);
        System.out.println(array);

        array.delete(3);
        System.out.println(array);

        array.deleteLast();
        System.out.println(array);

        array.deleteFirst();
        System.out.println(array);

        array.set(0,66);
        System.out.println(array);

        System.out.println(array.get(0));
        System.out.println(array.find(9527));
        System.out.println(array.contains(9527));
        System.out.println(array.contains(100000));

        System.out.println("test");

    }
}
