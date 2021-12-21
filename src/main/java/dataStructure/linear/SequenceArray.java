package dataStructure.linear;

import java.util.Iterator;

/**
 * 线性表--顺序数组
 * @author bigmoon
 * @date 2021/10/19
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class SequenceArray<T> implements Iterable<T> {
    protected String[] container;
    protected int capacity;
    protected int cnt=0;

    public SequenceArray(int capacity){
        this.container=new String[capacity];
        this.capacity=capacity;
    }

    public void clear(){
        this.container=new String[this.capacity];
    }

    public void insert(String item){
        this.container[cnt++]=item;
    }

    public void insert(int index,String item){

        for(int i=this.cnt-1;i>=index;i--){
            this.container[i+1]=this.container[i];
        }
        this.container[index]=item;
        this.cnt++;
    }

    public String remove(int index){
        String result=this.container[index];
        //删除之后,后面前移；
        for(int i=index;i<=this.cnt;i++){
            this.container[i]=this.container[i+1];
        }
        this.cnt--;
        return result;
    }

    public String get(int index){
        return this.container[index];
    }

    @Override
    public Iterator iterator() {
        return new Iterator<>() {
            int cunt = 0;

            @Override
            public boolean hasNext() {
                return cunt < cnt;
            }

            @Override
            public String next() {
                return container[cunt++];
            }
        };
    }
}
