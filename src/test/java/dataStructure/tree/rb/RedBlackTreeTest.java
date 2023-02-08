package dataStructure.tree.rb;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RedBlackTreeTest {


    @Test
    public void testRBTree() {

        RedBlackTree<Integer, String> bt = new RedBlackTree<>();
        bt.put(4, "二哈");
        bt.put(1, "张三");
        bt.put(3, "李四");
        bt.put(5, "王五");
        System.out.println(bt.size());
        bt.put(1, "老三");
        System.out.println(bt.get(4));
        System.out.println(bt.size());
        System.out.println(bt);
    }


}