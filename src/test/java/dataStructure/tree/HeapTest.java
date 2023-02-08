package dataStructure.tree;

import org.testng.annotations.Test;

public class HeapTest {

    @Test
    public void testInsert() {

        Heap<String> stringHeap = new Heap<>(10);
        stringHeap.insert("A");
        stringHeap.insert("B");
        stringHeap.insert("E");
        stringHeap.insert("D");
        stringHeap.insert("C");
        stringHeap.insert("F");
        stringHeap.insert("G");
        String max=null;

        while ((max=stringHeap.delMax())!=null){
            System.out.println(max);
        }
    }

    @Test
    public void testDelMax() {
    }
}