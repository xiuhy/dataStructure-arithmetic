package dataStructure.tree;

import org.testng.annotations.Test;

import java.util.Stack;

public class MinPriorityQueueTest {

    @Test
    public void testMain(){

            //创建最小优先队列对象
            MinPriorityQueue<String> queue = new MinPriorityQueue<String>(10);
            //往队列中存数据
            queue.insert("G");
            queue.insert("F");
            queue.insert("E");
            queue.insert("D");
            queue.insert("C");
            queue.insert("B");
            queue.insert("A");

            //通过循环获取最小优先队列中的元素
            while(!queue.isEmpty()){
                String min = queue.delMin();
                System.out.print(min+" ");
            }
    }

    @Test
    void test2(){

        String s="ac";
        long l = System.currentTimeMillis();
        int max=1;
        int min=0;
        if(s.length()<=1){
            System.out.println(s);
        }

        char[] saray=s.toCharArray();

        for (int i = 0; i < s.length()-1; i++) {
            for (int j = 1+i; j < s.length(); j++) {
                if(j-i+1>max&&check(saray,i,j)){
                    min=i;
                    max=j-i+1;
                }
            }
        }
        System.out.println(s.substring(min, min + max));
    }

    private boolean check(char[] array,int left,int right){

        while (left<right){
            if(array[left]!=(array[right])){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void testStack(){
        Stack<String> strings=new Stack<>();
        strings.push("a");
        strings.push("b");
        System.out.println(strings.peek());
        System.out.println(strings.peek());

    }
}