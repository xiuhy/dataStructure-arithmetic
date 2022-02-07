package dataStructure.tree.binary;

import dataStructure.tree.Node;

import java.util.StringJoiner;

/**
 * @author bigmoon
 * @date 2022/2/2
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class BinaryTree<K extends Comparable<K>,V> {

    private Node<K,V> root;
    private int count;

    public void put(K key,V value){
        this.root=put(root,key,value);
    }

    public Node put(Node<K,V> node,K key,V value){

        if(null==node){
            this.count++;
            node=new Node<>(key,value);
            return node;
        }

        int i = key.compareTo(node.getKey());

        if(i<0){
            //key小于当前节点
            node.setLeftNode(put(node.getLeftNode(),key,value));
        }else if(i>0){
            //key 大于当前节点
           node.setRightNode(put(node.getRightNode(),key,value));
        }else{
            //key 等于当前节点
            node.setValue(value);
        }
        return node;
    }

    public V get(K key){
      return get(this.root,key);

    }

    public V get(Node<K,V> node, K key){

        if(null==node){
            return null;
        }

        int i = key.compareTo(node.getKey());

        if(i<0){
            //key小于当前节点
            return get(node.getLeftNode(),key);
        }else if(i>0){
            //key 大于当前节点
            return get(node.getRightNode(),key);
        }else{
            //key 等于当前节点
           return node.getValue();
        }
    }

    public void del(K key){
        del(this.root,key);
    }

    public Node<K,V> del(Node<K,V> node,K key){
        if(null==node){
            return null;
        }

        int i = key.compareTo(node.getKey());

        if(i<0){
            //key小于当前节点
            node.setLeftNode(del(node.getLeftNode(),key));
        }else if(i>0){
            //key 大于当前节点
            node.setRightNode(del(node.getRightNode(),key));
        }else{
            //key 等于当前节点
            this.count--;

            if(node.getRightNode()==null){
                //此处是直接使用左侧节点顶替可以(也可以使用右侧节点最小节点)
                return node.getLeftNode();
            }

            if (node.getLeftNode()==null){
                //此处直接用rightNode 顶替可以(也可以使用右侧节点最小节点)
                return node.getRightNode();
            }

            Node<K, V> rightNode = node.getRightNode();
            Node<K,V> minNodeParent=null;
            //获取最左侧节点和上一个节点
            while (rightNode!=null){

                //如果不存在左侧节点则直接返回
                if(null==rightNode.getLeftNode()){
                    break;
                }

                //获取最小节点的上一个节点
                if(rightNode.getLeftNode()!=null&&rightNode.getLeftNode().getLeftNode()==null){
                    minNodeParent=rightNode;
                }
                rightNode=rightNode.getLeftNode();
            }

            //先删除最小节父级关系
            if(null!=minNodeParent){
               minNodeParent.setLeftNode(null);
            }
            //其次，替换被删除节点左右节点
            rightNode.setLeftNode(node.getLeftNode());
            rightNode.setRightNode(node.getRightNode());
            //重新替换
            node=rightNode;
        }
        return node;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", BinaryTree.class.getSimpleName() + "[", "]")
                .add("root=" + root)
                .add("count=" + count)
                .toString();
    }
}
