package dataStructure.tree;

import org.testng.annotations.Test;

public class MaxPriorityHeapTest {

    @Test
    void testMan(){

        //创建优先队列
        MaxPriorityHeap<String> queue = new MaxPriorityHeap<>(10);

        //往队列中存储元素
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");

        //通过循环从队列中获取最大的元素
        while(!queue.isEmpty()){
            String max = queue.delMax();
            System.out.print(max+" ");
        }
    }
}