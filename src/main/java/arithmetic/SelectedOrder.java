package arithmetic;

import java.util.Arrays;

/**
 * 选择排序
 * 最简单最基础排序方式：通过遍历对比获取最小下标，然后和第一个交换，第二个因子和第一个一样流程，以此类推直到最大一个为止
 * 时间复杂度：O(n²)
 * 缺点：
 * 不稳定：相同数据，可能会发生位置变更
 * @author bigmoon
 * @date 2021/8/31
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class SelectedOrder {

    public static void main(String[] args) {
        int[] orig=new int[]{3,21,1,54,0,11,98,47};
        int minIndex=-1;
        for (int i = 0; i < orig.length; i++) {
            minIndex=i;
            for (int i1 = i+1; i1 < orig.length; i1++) {
                //二次嵌套循环是(n-1)+(n-2)+(n-3).......  = n(n+1)/2 ≈ n2 算法中常量剔除，低密度数据不管，这里/2就是
                minIndex=orig[minIndex]>orig[i1]?i1:minIndex;
            }
            //遍历完成之后，替换下标
            int tmp=orig[i];
            orig[i]=orig[minIndex];
            orig[minIndex]=tmp;
            System.out.println(Arrays.toString(orig));
        }

        System.out.println("result:"+ Arrays.toString(orig));

    }
}
