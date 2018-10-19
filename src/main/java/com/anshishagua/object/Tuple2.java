package com.anshishagua.object;

public class Tuple2<T> {
    private final T first;
    private final T second;

    public Tuple2(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }
}