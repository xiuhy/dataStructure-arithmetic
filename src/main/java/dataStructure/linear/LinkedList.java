package dataStructure.linear;

import java.util.Iterator;

/**
 * 单链表集合
 * @author bigmoon
 * @date 2021/11/8
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class LinkedList<T> implements Iterable<T>{

    private Node<T> head;
    protected int cnt=0;

    public LinkedList(){}

    public void clear(){
        this.cnt=0;
        this.head=null;

    }
    public boolean isEmpty(){
        return this.cnt==0;
    }

    public T get(int index){

        if(null==this.head){
            return null;
        }

        Node<T> node=this.head;

        for(int i=0;i<index;i++){
            if(null==node){
                break;
            }
            node=node.next;
        }
        return node.item;
    }
    public int size(){
        return this.cnt;
    }

    public void insert(T item){
        Node node=new Node(item,null);
        Node tmp=this.head;
        //单向链表寻找最后一个
        while(tmp!=null){
            if(tmp.next!=null){
                tmp=tmp.next;
            }else{
                break;
            }
        }

        if(null!=tmp){
            tmp.next=node;
        }else{
            this.head=node;
        }
        this.cnt++;
    }

    public void insert(int index,T item){
        Node tmp=this.head;
        Node newNode=new Node(item,null);
        for(int i=0;i<index-1;i++){
            if(null==tmp){
                break;
            }
            tmp=tmp.next;
        }

        if(null!=tmp){
            newNode.next=tmp.next;
            tmp.next=newNode;
        }
        this.cnt++;
    }

    public T remove(int index){
        Node<T> tmp=this.head;
        for(int i=0;i<index;i++){
            if(null==tmp){
                break;
            }

            tmp=tmp.next;
        }

        if(null!=tmp){
          tmp.next= tmp.next.next;
          this.cnt--;
          return tmp.item;

        }else{
            return null;
        }
    }

    public int indexOf(T item){
       int index=0;
        while(null==this.head.next){
            Node<T> tmp=this.head.next;
            if(tmp.item.equals(item)){
                break;
            }
        }
        return index;
    }

    public class Node<T> {

         T item;
         Node<T> next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SelfIterator();
    }

    protected class SelfIterator implements Iterator<T>{
        Node<T> domainHead=head;

        @Override
        public boolean hasNext() {
            return this.domainHead!=null;
        }

        @Override
        public T next() {
            T value= this.domainHead.item;
            this.domainHead=this.domainHead.next;
            return value;
        }
    }
}
