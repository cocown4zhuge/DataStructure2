package com.neo.general;

import java.nio.file.Watchable;
import java.util.Arrays;

/**
 * Created by Administrator on 2018/12/19.
 */
public class Array<E> {

    private E[] data;
    private int size;

    //构造方法。根据初始容量初始化容器
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }
    //构造方法。默认初始容量10
    public Array(){
        this(10);
    }
    //获取容器大小size
    public int size(){
        return  size;
    }
    //获取容器容量capacity
    public int capacity(){
        return data.length;
    }
    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    //根据添加数据到容器
    public void add(int index, E e){
        if(index<0 || index>size)
            throw new IllegalArgumentException("Add failed,index is illegal.");
        //如果容器已经满了就扩容
        if(size == capacity())
            resize(2*data.length);

        for (int i = size-1; i>=index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //在容器末尾添加数据
    public void addLast(E e){
        add(size,e);
    }
    //在容器头添加数据
    public void addFirst(E e){
        add(0,e);
    }
    //获取指定索引数据
    public E get(int index){
        if(index<0 || index>=size)
            throw new IllegalArgumentException("Get failed,index is illegal.");
        return data[index];
    }

    //获取指定元素索引
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //删除指定索引数据
    public E delete(int index){
        if(index<0 || index>=size)
            throw new IllegalArgumentException("Delete failed,index is illegal.");
        //如果容器中元素个数小于容器容积一半时缩容
        if(size < capacity() / 2)
            resize(data.length/2);

        E retVal = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
         }
        data[size-1] = null;
        size--;
        return retVal;
    }

    //删除末尾数据
    public E deleteLast(){
        return delete(size-1);
    }
    //删除开头数据
    public E deleteFirst(){
        return delete(0);
    }
    //删除指定元素(删除第一个查询到的元素)
    public void deleteElement(E e){
        int index = find(e);
        if(index != -1)
           delete(index);
    }

    //修改指定索引位置数据
    public void set(int index, E e){
        if(index<0 || index>=size)
            throw new IllegalArgumentException("Delete failed,index is illegal.");
        data[index] = e;
    }

    //包含
    public boolean contains(E e){
        return find(e) != -1;
    }

    //toString

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}' + ", capacity=" + capacity();
    }
    
    //修改容量
    public void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < Math.min(size,newCapacity); i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
