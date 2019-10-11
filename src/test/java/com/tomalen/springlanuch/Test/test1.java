package com.tomalen.springlanuch.Test;

import lombok.Data;
import org.junit.Test;

/**
 * Author:钟炜宏
 * Date:2019/8/28
 */
public class test1 {

    @Test
    public void test1() {
        @Data
        class Node{
            int date;
            Node left;
            Node right;
        }
        Node n1 = new Node();
        n1.date = 1;
        Node n2 = new Node();
        Node n3 = new Node();
        n1.left = n2;
        n1.right = n3;
        n2.date = 2;
        System.out.println(n1);
        int a;
        System.out.println(n2.toString());
        System.out.println(n3.toString() );
    }
}

