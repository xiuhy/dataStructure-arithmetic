package dataStructure.tree;

/**
 * 堆:堆是完全二叉树结构。父节点大于或者小于其子节点。
 * 堆分为大顶堆和小顶堆，顾名思义最大在根节点或者最小在根节点
 * 堆特性：
 * 1. 当父节点下标为k时，左子节点为2k,又子节点为2k+1
 *
 * 当前以大顶堆
 * @author bigmoon
 * @date 2022/2/17
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class Heap<T extends Comparable<T>> {

    private T[] items;
    private int count;

    public Heap(int capability){
        this.items= (T[]) new Comparable[capability+1];
        this.count=0;
    }

    public Comparable[] getItems() {
        return items;
    }

    public int getCount() {
        return count;
    }

    /**
     * 判断指定元素 a是否大于b
     * @author bigmoon
     * @params [a, b]
     * @return boolean
     * @see [相关类/方法]（可选）
     * @since
     */
    public boolean less(int a,int b){
        return this.items[a].compareTo(this.items[b])>0;
    }

    /**
     * 交互
     * @author bigmoon
     * @params [i, j]
     * @return void
     * @see [相关类/方法]（可选）
     * @since
     */
    public void exch(int i,int j){
        T item=this.items[i];
        this.items[i]=this.items[j];
        this.items[j]=item;
    }

    public void insert(T item){
        this.items[++this.count]=item;
        swim(this.count);
    }

    /**
     * 上浮
     * @author bigmoon
     * @params [k]
     * @return void
     * @see [相关类/方法]（可选）
     * @since
     */
    public void swim(int k){

        while (k>1){

            if(less(k,k/2)){
                exch(k,k/2);
            }
            k=k/2;
        }
    }

    /**
     * 删除最大
     * @author bigmoon
     * @params [k]
     * @return void
     * @see [相关类/方法]（可选）
     * @since
     */
    public T delMax(){

        T max=this.items[1];
        exch(1,count);
        this.items[this.count]=null;
        this.count--;
        skin(1);
        return max;
    }

    /**
     * 下沉 .当前节点和子节点判断，如果小于子节点则交换
     * @author bigmoon
     * @params [k]
     * @return void
     * @see [相关类/方法]（可选）
     * @since
     */
    public void skin(int k){

        //region mysel A-plan
//        while(2*k<=this.count){
//            if(2*k+1<=this.count&&this.items[2*k+1]!=null){
//                //右子数据节点
//                if(less(2*k+1,k)){
//                    exch(k,2*k+1);
//                }
//            }
//
//            if(2*k<=this.count&&this.items[2*k]!=null){
//                //右子数据节点
//                if(less(2*k,k)){
//                    exch(k,2*k);
//                }
//            }
//            k=2*k;
//        }
        //endregion

        //region B-plan

        while (2*k<=count){
            int max=2*k;
            if (2*k+1<=count) {
                if(less(2*k+1,2*k)){
                    max=2*k+1;
                }
            }

            if(less(k,max)){
                break;
            }

            exch(k,max);
            k=max;
        }

        //endregion
    }

}
