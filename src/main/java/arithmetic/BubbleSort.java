package arithmetic;

import java.util.Arrays;

/**
 * 冒泡排序: 相邻两个相互比较，较大置换，再和下一个相邻比较大小，直到最大或者最小置换到最后
 * 时间复杂度:O(n²)
 * 空间复杂度：
 * 缺点:效率低(慢)
 * @author bigmoon
 * @date 2022/8/23
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] ints=new int[]{23,19,40,50,16,5,7,12,1,2084,3};
        bubbleSort(ints);
        System.out.println(Arrays.toString(ints));

    }

    private static void bubbleSort(int[] arrays){

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length-i-1; j++) {
                if(arrays[j]>arrays[j+1]){
                    //置换
                    int i1 = arrays[j];
                    arrays[j]=arrays[j+1];
                    arrays[j+1]=i1;
                }
            }
            System.out.println(Arrays.toString(arrays));
        }
    }
}
