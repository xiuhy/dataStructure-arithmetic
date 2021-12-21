package dataStructure.linear;

import java.util.Iterator;

/**
 * 双向列表
 * @see java.util.LinkedList
 * @author bigmoon
 * @date 2021/11/21
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class TwoWayLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> last;
    protected int cnt=0;
    public TwoWayLinkedList(){}

    public void clear(){
        this.cnt=0;
        this.head=null;
        this.last=null;
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
        //A 来自jdk LinkedList.
        //思路重点：当有且只有一个节点时，last和first指向一个节点
        Node<T> l=this.last;
        //尾部追加，则是在pre=last
        Node<T> newNode=new Node(item,null,l);
        this.last=newNode;

        if(null==l){
            this.head=newNode;
        }else{
            //上街last节点的下一个。注：l和this.last不一定是一个内容
            l.next=newNode;
        }

        //B
//        if(null==this.head){
//            this.head=newNode;
//        }else{
//            if(null!=this.last){
//                this.last.next=newNode;
//                this.last=newNode;
//            }else{
//                this.last=newNode;
//                this.head.next=this.last;
//            }
//        }
        this.cnt++;
    }

    /**
     * 指定下标插入
     *
     * @author bigmoon
     * @params [index, item]
     * @return void
     * @see [相关类/方法]（可选）
     * @since
     */
    public void insert(int index,T item){
        Node tmp=this.head;
        Node newNode=new Node(item,null);
        //遍历获取指定下标前一个节点
        for(int i=0;i<index-1;i++){
            if(null==tmp){
                break;
            }
            tmp=tmp.next;
        }
        //==null，表示head是空，第一个数据
        if(null==tmp){
            this.head=newNode;
        }else{
            //将前一个节点下一个链接给新节点，前一个节点下一个节点设置为新节点
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

        if(null==tmp){
           return null;
        }else if(tmp.equals(this.last)){
            this.cnt--;
            Node<T> removeNode=this.last;
            this.last=removeNode.pre;
            return removeNode.item;
        }else{
           tmp.pre=tmp.next;
           this.cnt--;
           return tmp.item;
        }
    }

    public int indexOf(T item){
        int index=0;
        Node<T> tmp=this.head;

        while(null!=tmp){
            index++;
            if(tmp.item.equals(item)){
                break;
            }else{
                tmp=tmp.next;
            }
        }
        return index;
    }

    public static class Node<T> {

        T item;
        Node<T> next;
        Node<T> pre;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
            this.pre=null;
        }

        public Node(T item, Node next,Node pre) {
            this.item = item;
            this.next = next;
            this.pre=pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node<T> getPre() {
            return pre;
        }

        public void setPre(Node<T> pre) {
            this.pre = pre;
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
            //TODO 是返回head指针当前内容，还是下一个内容？
            T value= this.domainHead.item;
            this.domainHead=this.domainHead.next;
            return value;
        }
    }
}
