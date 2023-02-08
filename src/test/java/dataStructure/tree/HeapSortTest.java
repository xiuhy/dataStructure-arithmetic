package dataStructure.tree;

import org.testng.annotations.Test;

public class HeapSortTest {

    @Test
    public void testSort() {

        Integer[] tmpResult=new Integer[]{32,12,3,2,13,123,10};
        HeapSort<Integer> result=new HeapSort<Integer>();
        result.sort(tmpResult);
    }
}