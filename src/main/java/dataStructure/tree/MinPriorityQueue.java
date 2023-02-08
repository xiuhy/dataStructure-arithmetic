package dataStructure.tree;

/**
 * @author bigmoon
 * @date 2022/3/13
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class MinPriorityQueue<T extends Comparable> {

    private T[] items;
    private int count;
    private int capability;

    public MinPriorityQueue(int cap) {
        this.items = (T[]) new Comparable[cap + 1];
        this.capability = cap + 1;
    }

    public void exch(int a, int b) {

        T tmp = this.items[a];
        this.items[a] = this.items[b];
        this.items[b] = tmp;
    }

    public boolean lessThen(int a, int b) {
        return this.items[a].compareTo(this.items[b]) > 0;
    }

    public void insert(T add) {
        this.items[++this.count] = add;
        //上浮，最小值
        swim(this.count);
    }

    public void swim(int length) {

        int tmpIndex = length;
        while (tmpIndex > 1) {

            if (lessThen(tmpIndex / 2, tmpIndex)) {
                //父节点更大时，替换
                exch(tmpIndex / 2, tmpIndex);
            }
            tmpIndex = tmpIndex / 2;
        }
    }

    /**
     * 下沉数据，将最大的对象下沉
     *
     * @return void
     * @author bigmoon
     * @params [i]
     * @see [相关类/方法]（可选）
     * @since
     */
    public void skim(int i) {

        int tmp = 0;

        while (i * 2 + 1 <= this.count) {

            if (lessThen(i * 2 + 1, i * 2)) {
                tmp = i * 2;
            } else {
                tmp = i * 2 + 1;
            }

            if (lessThen(i, tmp)) {
                exch(i, tmp);
                i = tmp;
            } else {
                break;
            }
        }
    }

    public boolean isEmpty() {
        return this.count <= 0;
    }


    public T delMin() {
        T min = this.items[1];
        exch(1, this.count);
        this.count--;
        //替换数据格式
        //下沉最大致
        skim(1);
        return min;
    }
}
