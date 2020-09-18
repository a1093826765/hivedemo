package com.bigdata.hive.function;

import org.apache.hadoop.hive.ql.exec.UDF;

public class MyFunctionUDF extends UDF {
    public String evaluate(String name){
        return name+"dddd";
    }
}
