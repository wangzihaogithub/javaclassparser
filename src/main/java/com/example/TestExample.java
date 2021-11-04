package com.example;

import com.example.JavaClassFile.Attribute;
import com.example.JavaClassFile.Member;
import com.example.JavaClassFile.Opcodes;

import java.io.IOException;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 代码例子
 */
public class TestExample {
    public static void main(String[] args) throws IllegalClassFormatException, IOException, ClassNotFoundException, NoSuchMethodException {
        JavaClassFile javaClassFile = new JavaClassFile(MyBean.class);

        List<Attribute.LocalVariable[]> localVariableTableList = javaClassFile.getLocalVariableTableList();

        // 方法
        Member[] methods = javaClassFile.getMethods();
        Member helloMethod = javaClassFile.getMethod("hello", new Class[]{String.class, int.class}, void.class);

        // 方法内的元素
        Method javaMethod = (Method) helloMethod.toJavaMember();

        String[] parameterNames = helloMethod.getParameterNames();
        Attribute.LocalVariable[] localVariableTable = helloMethod.getLocalVariableTable();
        Attribute.LocalVariable[] localVariableTypeTable = helloMethod.getLocalVariableTypeTable();
        Opcodes opcodes = helloMethod.getOpcodes();
        Attribute.Annotation[] runtimeVisibleAnnotations = helloMethod.getRuntimeVisibleAnnotations();
        Attribute.CodeException[] exceptionTable = helloMethod.getExceptionTable();
        Attribute.StackMapFrame[] stackMapTable = helloMethod.getStackMapTable();

        System.out.println("localVariableTableList = " + localVariableTableList);
    }

    public static class MyBean {
        public void hello(String aa, int 你好) {
            String result = aa + "1";
        }
    }
}
