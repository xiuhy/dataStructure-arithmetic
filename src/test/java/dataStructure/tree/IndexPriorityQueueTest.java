package dataStructure.tree;

public class IndexPriorityQueueTest {

    public static void main(String[] args) {
        String[]arr={"S","O","R","T","E","X","A","M","P","L","E"};
        IndexPriorityQueue<String>indexMinPQ=new IndexPriorityQueue<>(20);//插入
        for(int i=0;i<arr.length;i++){
            indexMinPQ.insert(i,arr[i]);
        }

        System.out.println(indexMinPQ.size());
        //获取最小值的索引
        System.out.println(indexMinPQ.minIndex());

        indexMinPQ.changeItem(0,"Z");
        //测试删除
        while(!indexMinPQ.isEmpty()){
            int index = indexMinPQ.delMin();
            System.out.print(index+" ");
        }
    }

}