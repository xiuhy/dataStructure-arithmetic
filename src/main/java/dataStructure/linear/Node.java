package dataStructure.linear;

import static java.util.Optional.ofNullable;

/**
 * 链表结构
 * 特点：除首尾节点不连接任何对象，其他节点都链接节点地址
 *
 * @author bigmoon
 * @date 2021/11/8
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class Node<T> {

    public T item;
    public Node next;
    public Node pre;

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

    public static void main(String[] args) {
        Node<String> node = new Node<>("鸡头", null);
        Node<String> node2 = new Node<>("凤尾", null);
        Node<String> node3 = new Node<>("不上不下", null);
        node.setNext(node2);
        node2.setNext(node3);
        inlineLoop(node);
    }

    protected static void inlineLoop(Node node) {

        ofNullable(node).ifPresent(tempNode -> {
            System.out.println("当前节点 data=" + tempNode.item);
            ofNullable(tempNode.next).ifPresent(nextNode -> {
//                System.out.println("下节点 data=" + nextNode.item);
                inlineLoop(tempNode.next);
            });
        });
    }

    // 快慢指针
    public static <T> boolean isCircle(Node<T> head){
        Node fast=head;
        Node slow=head;

        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            if(fast.equals(slow)){
                //说明有交集
                System.out.println("slow:"+slow.item+",fast:"+fast.item);
                return true;
            }
        }
        return false;
    }

    // 快慢指针查找循环切入点
    public static <T> Node circlePoint(Node<T> head){
        Node fast=head;
        Node slow=head;
        Node point=null;

        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            if(fast.equals(slow)){
                //说明有交集,开始接入第三个指针从头开始
                point=head;
                continue;
            }

            if(null!=point){
                point=point.next;
                if(slow.equals(point)){
                    return point;
                }
            }
        }

        return point;
    }

//    @Override
//    public String toString() {
//        return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
//                .add("item=" + item)
//                .add("next=" + next)
//                .add("pre=" + pre)
//                .toString();
//    }
}
