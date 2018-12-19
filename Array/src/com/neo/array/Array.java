package com.neo.array;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2018/12/19.
 */
public class Array {
    private int[] data;
    private int size;

    //构造方法。根据初始容量初始化容器
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }

    //构造方法。默认初始容量10
    public Array(){
        this(10);
    }

    //获取容器大小size
    public int size(){
        return size;
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
    public void add(int index, int e){
        //合法性校验
        if(size == data.length)
            throw new IllegalArgumentException("Add failed, array is full");
        if(index<0 || index>size)
            throw new IllegalArgumentException("Add failed, index must between 0 to size");

        for (int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //在容器末尾添加数据
    public void addLast(int e){
        add(size,e);
    }

    //在容器头添加数据
    public void addFirst(int e){
        add(0,e);
    }

    //获取指定索引数据
    public int get(int index){
        //合法性判断
        if(index<0 || index>=size) {
            throw new IllegalArgumentException("Get failed, index is illegal");
        }
        return  data[index];
    }

    //获取指定元素索引
    public int find(int e){
        for (int i = 0; i < size; i++) {
            if(data[i] == e){
                return i;
            }
        }
        return -1;
    }

    //删除指定索引数据
    public int delete(int index){
        //合法性判断
        if(index<0 || index>=size) {
            throw new IllegalArgumentException("Delete failed, index is illegal");
        }
        int retValue = data[index];
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        data[size-1] = 0;
        size--;
        return retValue;
    }

    //删除末尾数据
    public int deleteLast(){
        return delete(size-1);
    }

    //删除开头数据
    public int deleteFirst(){
        return delete(0);
    }

    //删除指定元素(删除第一个查询到的元素)
    public void deleteElement(int e){
        int index = find(e);
        if(index != -1)
            delete(index);
    }

    //修改指定索引位置数据
    public void set(int index, int e){
        //合法性判断
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    //包含
    public boolean contains(int e){
        int index = find(e);
        return index!=-1;
    }


    @Override
    public String toString() {
        return "size:" + size + ",capacity:" + capacity() + ",arrayData:" + Arrays.toString(data);
    }
}
