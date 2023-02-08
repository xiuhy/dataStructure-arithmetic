package dataStructure.tree;

/**
 * 索引优先队列
 * 索引优先队列中索引下标指pq数组
 * pq是 items队列堆排序后
 * qp是pq逆排序（下标和值颠倒）
 *
 * @author bigmoon
 * @date 2022/3/16
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class IndexPriorityQueue<T extends Comparable<T>> {

    private T[] items;
    private int[] pq;
    private int[] qp;
    private int count;

    public IndexPriorityQueue(int capability) {
        items = (T[]) new Comparable[capability + 1];
        pq = new int[capability + 1];
        qp = new int[capability + 1];

        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }
    }

    public int size(){
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * 堆排序队列坐标对比
     * a是否小于b
     *
     * @return boolean：true,a小于b;false a>=b
     * @author bigmoon
     * @params [a, b]
     * @see [相关类/方法]（可选）
     * @since
     */
    public boolean less(int a, int b) {
        return this.items[pq[a]].compareTo(this.items[pq[b]]) < 0;
    }

    /**
     * 交换堆下标内容
     * 同步qp队列
     *
     * @return void
     * @author bigmoon
     * @params [i, j]
     * @see [相关类/方法]（可选）
     * @since
     */
    public void exchan(int i, int j) {

        int target = pq[i];
        pq[i] = pq[j];
        pq[j] = target;

        //对应 pq，和qp
        //这里较难理解。此时pq已经完成替换；
        /** 且pq和qp是颠倒。举例：
         *  pq:i:a,j:b  -->exchan  i:b，j:a
         *  qp:a:i,b:j  --->  pq[i]=b,qp[b]源指向j，现在指向i。所以....
         */
        this.qp[this.pq[i]] = i;
        this.qp[this.pq[j]] = j;

    }

    /**
     * 判断k（值源值itme,下标）对应的数据是否存在
     * TODO 数组太多，何时下表用在和数组下较为困难
     *
     * @return boolean
     * @author bigmoon
     * @params [k]
     * @see [相关类/方法]（可选）
     * @since
     */
    public boolean contains(int k) {
        return this.qp[k] != -1;
    }

    /**
     * 最小元素关联索引
     *
     * @return int
     * @author bigmoon
     * @params []
     * @see [相关类/方法]（可选）
     * @since
     */
    public int minIndex() {
        return this.pq[1];
    }

    /**
     * 插入指定位置和值
     * todo 这里插入感觉更像追加
     *
     * @return void
     * @author bigmoon
     * @params [i, v]
     * @see [相关类/方法]（可选）
     * @since
     */
    public void insert(int i, T v) {

        if (contains(i)) {
            return;
        }

        //itsm追加一个元素；然后记录pq的下坐标；最后再更像qp
        this.count++;
        this.items[i] = v;
        pq[count] = i;
        qp[i] = count;
        //由于插入内容，所以要对i值内容上浮操作
        swim(count);
    }

    /**
     * 删除最小
     *
     * @return T
     * @author bigmoon
     * @params []
     * @see [相关类/方法]（可选）
     * @since
     */
    public int delMin() {
        //标记pq数组下最小的坐标；删除pq最小内容；然后同步更新qp内容；最后把item所在坐标内容更新
        //最最后重新排序pq
        int minIndex = pq[1];
        T min = this.items[minIndex];
        //更新item数组最小内容
        this.items[minIndex] = null;
        //qp最小内容抹去
        this.qp[minIndex] = -1;
        //交换pq堆排序的内容
        exchan(1, this.count);
        //pq最小内容移除
        this.pq[this.count] = -1;
        this.count--;
        //最最后重新排序pq
        skin(1);
        return minIndex;
    }

    /**
     * 删除指定坐标下的元素
     *
     * @return T
     * @author bigmoon
     * @params [i]
     * @see [相关类/方法]（可选）
     * @since
     */
    public T del(int i) {

        //1 判断i坐标下是否存在；2. 删除pq下内容 ；3.删除qp下内容；4. 删除item下内容；5.重新排序
        if (!contains(i)) {
            return null;
        }
        int pqIndex = qp[i];

        //删除item内容
        T delVal = this.items[i];
        this.items[i] = null;
        //删除qp内容
        qp[i] = -1;
        exchan(pqIndex, this.count);
        pq[this.count] = -1;
        //todo 以下双操作何以
        skin(pqIndex);
        swim(pqIndex);
        this.count--;
        return delVal;
    }

    /**
     * 通过指定的坐标改变内容
     *
     * @return void
     * @author bigmoon
     * @params [i, v]
     * @see [相关类/方法]（可选）
     * @since
     */
    public void changeItem(int i, T v) {
        //改变item value内容;然后同步重新排序pq
        items[i] = v;
        int index = qp[i];
        skin(index);
        swim(index);
    }

    /**
     * 上浮。 和父节点对比
     *
     * @return void
     * @author bigmoon
     * @params s
     * @see [相关类/方法]（可选）
     * @since
     */
    public void swim(int k) {

        while (k > 1) {

            if (less(k, k / 2)) {
                exchan(k, k / 2);
            }
            k = k / 2;
        }
    }

    /**
     * 下沉，和子节点对比
     *
     * @return void
     * @author bigmoon
     * @params [k]
     * @see [相关类/方法]（可选）
     * @since
     */
    public void skin(int k) {

        int sonNode = -1;
        while (2 * k <= this.count) {

            if (2 * k + 1 <= this.count) {
                if (less(2 * k, 2 * k + 1)) {
                    sonNode = 2 * k;
                } else {
                    sonNode = 2 * k + 1;
                }
            } else {
                sonNode = 2 * k;
            }

            if (!less(k, sonNode)) {
                exchan(k, sonNode);
            }
            k = sonNode;
        }
    }
}
