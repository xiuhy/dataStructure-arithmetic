package dataStructure.linear;

/**
 * 约瑟夫环问题
 * 41人做成环，从1开始报数，到3提出。然后重新1开始报数。直到无法到3。求最后剩下的人的序号
 * 答案：当最后剩下16，31时是最后两个人
 * @author bigmoon
 * @date 2021/12/29
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class JosephusQuestion {

    public static void main(String[] args) {

        Node head=null;
        Node preNode=null;

        for (int i=1;i<=41;i++){
            Node<Integer> node=new Node<>(Integer.valueOf(i),null);
            if(i==1){
                head=node;
                preNode=node;
                continue;
            }

            preNode.setNext(node);
            preNode=node;

            if(i==41){
                node.setNext(head);
            }
        }

        System.out.println("完成创建约瑟夫环，下面开始验证");
        int cnt=0;
        preNode=head;
        while(preNode.next!=null){
            System.out.println(preNode.item);
            if(preNode.item.equals(1)){
                cnt++;
            }

            if(cnt>=2){
                System.out.println("完成验证");
                break;
            }
            preNode=preNode.next;
        }

        killedGame(head);
    }

    static void killedGame(Node head){
        Node temp=head;
        int remanent=41;
        Node tmp=null;
        int start=1;
        while(temp!=null&&temp.getNext()!=null){

            if(remanent<3){
                break;
            }

            if(start==3){
                //当前节点删除
                System.out.println("当前节点数到3咯，必须自杀："+temp.item);
                if(tmp!=null){
                    tmp.setNext(temp.getNext());
                }
                start=1;
                remanent--;
            }else{
                start++;
            }
            tmp=temp;
            temp=temp.getNext();
        }

        System.out.println("约瑟夫环问题已经结束");
        System.out.println(""+temp.item+","+temp.getNext().item);
    }
}
