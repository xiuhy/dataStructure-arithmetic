package dataStructure.linear;

import java.util.ArrayDeque;

/**
 * josephus 问题
 * n 个人围圈，依次传土豆，经过M次得到的退出，然后从下一个继续开始。直到只剩下一个人
 * @author bigmoon
 * @date 2023/2/8
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class JosephusProblem {
    public static void main(String[] args) {
        //循环队列处理较好
        int c=0;
        int M=2;
        ArrayDeque<Integer> arrayDeque=new ArrayDeque<>();
        arrayDeque.add(1);
        arrayDeque.add(2);
        arrayDeque.add(3);
        arrayDeque.add(4);
        arrayDeque.add(5);
        arrayDeque.add(6);
        arrayDeque.add(7);
        arrayDeque.add(8);

        while (true){

            if(arrayDeque.size()<=1){
                System.out.println("最后的胜利者 " + arrayDeque.getFirst());
                break;
            }

            Integer pop = arrayDeque.pop();

            if(c>=M){
                c=0;
                System.out.println("remove " + pop);
            }else{
                c++;
                arrayDeque.addLast(pop);
            }
        }
    }
}
