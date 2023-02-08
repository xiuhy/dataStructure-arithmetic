package dataStructure.graph;

import java.util.Iterator;

import static java.util.Optional.ofNullable;

/**
 * @author bigmoon
 * @date 2022/4/15
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class DepthFirstSearch {

    boolean[] marks;
    Graph g;

    public DepthFirstSearch(Graph g,int v){
        this.g=g;
        marks=new boolean[g.V()];
        dfs(v);
    }

    void dfs(int v){

        ofNullable(g.adj(v)).ifPresent(queues->{

            if(!marks[v]){

                marks[v]=true;
                System.out.println("开始搜索 顶点:"+v);
                Iterator<Integer> iterator=queues.iterator();
                while (iterator.hasNext()) {
                    Integer  next=iterator.next();

                    if(!marks[next]){
                        dfs(next);
                    }
                }
            }

        });







    }
}
