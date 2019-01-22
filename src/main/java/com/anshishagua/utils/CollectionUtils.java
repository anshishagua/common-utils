package com.anshishagua.utils;

import scala.collection.JavaConverters;
import scala.collection.Seq;

import java.util.List;

public class CollectionUtils {
    public static <T> Seq<T> toScalaSeq(List<T> list) {
        return JavaConverters.asScalaIteratorConverter(list.iterator()).asScala().toSeq();
    }
}