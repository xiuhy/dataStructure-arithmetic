package dataStructure.tree;

/** 堆排序
 * @author bigmoon
 * @date 2022/2/24
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class HeapSort<T extends Comparable<T>> {

    /**
     * 创建堆对象
     * @author bigmoon
     * @params [source]
     * @return T[]
     * @see [相关类/方法]（可选）
     * @since
     */
    T[] createHeap(T[] source){
        T[] newHeap=(T[])new Comparable[source.length+1];
        System.arraycopy(source,0,newHeap,1,source.length);
        //对现有的新对象排序？

        for (int i = (newHeap.length-1)/2; i >0 ; i--) {
                skin(newHeap,i,newHeap.length-1);
        }
        return newHeap;
    }

    void exch(T[] source,int a,int b){
        T t1 = source[a];
        source[a] = source[b];
        source[b]=t1;
    }

    /**
     * 对比source中a 和b 的大小
     *
     * @author bigmoon
     * @params [source, a, b]
     * @return boolean false:a>=b,true: a<b
     * @see [相关类/方法]（可选）
     * @since
     */
    boolean less(T[] source,int a,int b){
        return source[a].compareTo(source[b])<0;
    }

    void skin(T[] source,int stat,int end){

        int i=stat;

        while(i*2<=end){

            int min;
            if(i*2+1<=end){
                if(less(source,i*2,i*2+1)){
                    min=i*2;
                }else{
                    min=i*2+1;
                }
            }else{
                min=i*2;
            }

            if(!less(source,i,min)){
                exch(source,i,min);
            }
            i=min;
        }
    }

    /**
     * 排序
     * @author bigmoon
     * @params [source, stat, end]
     * @return void
     * @see [相关类/方法]（可选
     * @since
     */
    void sort(T[] source){
        T[] tmpResult=createHeap(source);
        int i=tmpResult.length-1;
        while (i>1) {
            exch(tmpResult, 1, i);
            skin(tmpResult, 1, --i);
        }

        for (int i1 = tmpResult.length-1; i1 > 0; i1--) {
            System.out.println(tmpResult[i1]);
        }
    }
}
