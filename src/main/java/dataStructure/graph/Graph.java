package dataStructure.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 图
 * @author bigmoon
 * @date 2022/4/15
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class Graph {

    /**
     * 顶点数量
     */
    private int V;

    /**
     * 边数量
     */
    private int E;

    /**
     * 邻接表
     */
    private Queue<Integer>[] queues;

    /**
     * 初始化
     * @param v
     */
    public Graph(int v){
        this.V=v;
        this.E=0;
        queues=new Queue[V];
        for (int i=0;i<V;i++){
            queues[i]=new ArrayDeque<>(V);
        }
    }


    //获取顶点数目
    public int V(){
        return V;
    }

    //获取边的数目
    public int E(){
        return E;
    }

    //向图中添加一条边 v-w
    public void addEdge(int v, int w) {
        //在无向图中，边是没有方向的，所以该边既可以说是从v到w的边，又可以说是从w到v的边，
        // 因此，需要让w出现在v的邻接表中，并且还要让v出现在w的邻接表中
        queues[v].offer(w);
        queues[w].offer(v);
        E++;
    }

    //获取和顶点v相邻的所有顶点
    public Queue<Integer> adj(int v){
        return queues[v];
    }
}
