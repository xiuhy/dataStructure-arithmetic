package arithmetic;

import java.util.Arrays;

/**
 * 插入排序：从从后向前相隔两两遍历，如果小于前者则替换
 * 插入排序：基于有序数组实现
 * 时间复杂度:O(n2)
 *
 * @author bigmoon
 * @date 2022/9/4
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] orig=new int[]{3,21,1,54,0,11,98,47};
        int minIndex=-1;
        for (int i = 1; i < orig.length; i++) {
            for(int j=i;j>0;j--){
                //和前者判断大小置换
                int tmp=orig[j];
                if(orig[j]<orig[j-1]){

                    orig[j]=orig[j-1];
                    orig[j-1]=tmp;
                }
            }
            System.out.println(Arrays.toString(orig));
        }
        System.out.println("result:"+ Arrays.toString(orig));
    }
}
