package com.anshishagua;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class GraphNode {
    private static AtomicInteger atomicInteger = new AtomicInteger();

    private long id;
    private String name;
    private Map<String, String> properties;
    private List<GraphNode> in;
    private List<GraphNode> out;

    public static int newId() {
        return atomicInteger.getAndIncrement();
    }

    public GraphNode(int id) {
        this.id = id;
    }
}
