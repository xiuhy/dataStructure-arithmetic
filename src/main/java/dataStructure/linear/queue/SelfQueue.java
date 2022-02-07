package dataStructure.linear.queue;

import dataStructure.linear.Node;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * @author bigmoon
 * @date 2022/1/23
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class SelfQueue<T> implements Queue<T> {

    private Node<T> first,last;
    int count=0;

    @Override
    public boolean add(T t) {
        Node tmp=this.first;
        Node tmpLast=this.last;
        Node newNode=new Node(new Node(null,null),t,tmpLast);
        this.last=newNode;

        if(null==tmp){
            this.first=newNode;
        }else{
            tmpLast.pre=this.last;
        }

        this.count++;
        return true;
    }

    @Override
    public boolean offer(T t) {
        this.add(t);
        return true;
    }

    @Override
    public T remove() {
        Node<T> removeItem=this.first;
        this.first=removeItem.pre;
        this.count--;
        return removeItem.item;
    }

    @Override
    public T poll() {
        return this.remove();
    }

    @Override
    public T element() {
        throw new UnsupportedOperationException();
//        return null;
    }

    @Override
    public T peek() {

        return this.first.item;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return this.count==0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        return new SelfIterator();
    }

    public class SelfIterator<T> implements Iterator<T>{

        Node<T> node;

        public SelfIterator(){
            this.node= (Node<T>) SelfQueue.this.first;
        }

        @Override
        public boolean hasNext() {
            return null!=this.node.pre;
        }

        @Override
        public T next() {
            Node<T> node= this.node;
            this.node=node.pre;
            return node.item;
        }
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {

    }

}
