package dataStructure.linear.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bigmoon
 * @date 2023/2/7
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class Main {

    public static void main(String[] args) {
//        printLost(new String[]{"adb","bcd","efg","cc"},new int[]{0,2,3,8});
        ArrayList<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        removeList(list);
    }

    /** P67 3.1
     * 打印出L集合中P集合元素作为L下标的元素
     * @author bigmoon
     * @params []
     * @return void
     * @see [相关类/方法]（可选）
     * @since
     */
    protected static void printLost(String[] l,int[] p){
        for (int i : p) {
            if(i<l.length){
                System.out.println(l[i]);
            }else{
                System.out.println("null");
            }
        }
    }

    protected static void removeList(List list){
        int size= list.size()/2;

        for (Object o : list) {
            list.remove(o);
        }

//        for (int i = 0; i < size; i++) {
//            list.remove(0);
//        }
    }
}
