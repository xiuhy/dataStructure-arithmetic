package dataStructure.tree;

/**
 * 最大优先级队列
 *
 * @author bigmoon
 * @date 2022/3/9
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class MaxPriorityHeap<T extends Comparable<T>> {
    private T[] items;
    private int count;

    public MaxPriorityHeap(int capital) {
        this.items = (T[]) new Comparable[capital + 1];
    }

    /**
     * 交互
     *
     * @return void
     * @author bigmoon
     * @params [i, j]
     * @see [相关类/方法]（可选）
     * @since
     */
    public void exch(int i, int j) {
        T item = this.items[i];
        this.items[i] = this.items[j];
        this.items[j] = item;
    }

    public void insert(T item) {

        if (this.count >= this.items.length) {
            throw new IndexOutOfBoundsException();
        }
        this.items[++this.count] = item;

        //重新排序，最大在上面
//        最大在最上面
        swim(this.count);
    }

    public boolean isEmpty(){
        return this.count==0;
    }


    public T delMax() {

        T max = this.items[1];
//        System.out.println(max);
        //交换一头一尾内容
        exch(1, this.count);
        this.count--;
        skin(1);

        return max;
    }

    /**
     * 上浮，在大顶堆中，下级的子节点比父级大的替换上去
     *
     * @return void
     * @author bigmoon
     * @params []
     * @see [相关类/方法]（可选）
     * @since
     */
    void swim(int i) {

        int index = i;

        while (index > 1) {
            if (less(index / 2, index)) {
                exch(index / 2, index);
            }
            index = index / 2;
        }
    }

    boolean less(int a, int b) {
        return this.items[a].compareTo(this.items[b]) < 0;
    }

    /**
     * 下沉，在大顶堆里面把父级中较小的(子集中较大的)替换下来
     * @author bigmoon
     * @params [i]
     * @return void
     * @see [相关类/方法]（可选）
     * @since
     */
    void skin(int i) {

        int index = i;
        int max;
        while (2 * index + 1 <= this.count) {
            if (less(2 * index, 2 * index + 1)) {
                max = 2 * index + 1;
            } else {
                max = 2 * index;
            }

            if (less(index, max)) {
                exch(index, max);
            }
            index = max;
        }
    }


}
