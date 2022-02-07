package dataStructure.linear.stack;

import dataStructure.linear.Node;

import java.util.Iterator;

/**
 * 链数据结构 自定义stack
 * @author bigmoon
 * @date 2022/1/4
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class LinkStack<T> implements Iterable<T>{

    private int size=0;
    protected Node<T> first=new Node<>(null,null);
    Node<T> currentIndex=null;

    public void push(T obj){
        Node<T> node=new Node<>(obj,null);
        size++;

        if(null==first.getNext()){
            first.setNext(node);
            node.pre=first;
        }else{
            currentIndex.setNext(node);
            node.pre=currentIndex;
        }

        currentIndex=node;

    }

    public T pop(){
        Node<T> last=currentIndex;
        currentIndex=currentIndex.pre;
        return null==last?null:last.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SelfIterator(this.first);
    }

    public static class SelfIterator<T> implements Iterator<T>{

        private Node<T> current;

        public SelfIterator(Node<T> current){
            this.current=current;
        }

        @Override
        public boolean hasNext() {
            return current.next!=null;
        }

        @Override
        public T next() {
            Node<T> next=current.next;
            current=current.next;
            return next.item;
        }
    }
}
