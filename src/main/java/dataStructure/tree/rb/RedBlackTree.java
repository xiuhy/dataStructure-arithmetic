package dataStructure.tree.rb;

import java.util.StringJoiner;

/**
 * @author bigmoon
 * @date 2022/3/26
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class RedBlackTree<K extends Comparable<K>,V> {

    private Node<K,V> root;
    private int count;
    private static final boolean RED=true;

    public RedBlackTree(){}

    public boolean isRed(Node node){

        if (node == null) {
            return false;
        }

        return node.isRedColor();
    }

    /**
     * 坐旋转:执行条件，发生右侧有一个红色节点
     * @author bigmoon
     * @params [root]
     * @return void
     * @see [相关类/方法]（可选）
     * @since
     */
    public Node rotateLeft(Node node){
        /**
         * 1. 获取右节点
         * 2. 右节点左节点给当前右
         * 3. 右节点的左节点等于当前节点
         * 4. 当前节点红色
         * 5. 返回右节点
         */

        Node right=node.getRight();
        node.setRight(right.getLeft());
        right.setLeft(node);

        //颜色变更更换
        right.setRedColor(node.isRedColor());
        node.setRedColor(true);
        return right;
    }

    public Node rotateRight(Node node){

        //获取左侧节点
        Node left=node.getLeft();
        //左侧节点右侧节点为当前节点的左侧节点
        node.setLeft(left.getRight());
        //左节点的右子节点=当前节点
        left.setRight(node);
        //颜色变更 这里不太懂 ?
        node.setRedColor(left.isRedColor());
        left.setRedColor(node.isRedColor());
        return left;
    }

    /**
     * 颜色翻转
     * 当前节点红色，左右子节点黑色
     * @author bigmoon
     * @params [node]
     * @return void
     * @see [相关类/方法]（可选）
     * @since
     */
    public void  flipColor(Node node){
        node.setRedColor(true);
        node.getLeft().setRedColor(false);
        node.getRight().setRedColor(false);
    }

    public void put(K key,V value){
       this.root= put(root,key,value);
       //根节点总是黑色
       this.root.setRedColor(false);
    }

    public Node put(Node node,K key, V value){

        if (node == null) {
            this.count++;
            return new Node(true,(Comparable) key,value,null,null);
        }

        int i = node.getKey().compareTo(key);

        if(i>0){
            //左边插入
            node.setLeft(put(node.getLeft(),key,value));
        }else if(i<0){
            //右边插入
            node.setRight(put(node.getRight(),key,value));
        }else{
            //更新当前值
            node.setValue(value);
        }

        //考虑是否需要左右旋转
        //左旋转:node左边是黑色节点右边是红色节点
        if(!isRed(node.getLeft())&&isRed(node.getRight())){
            node=rotateLeft(node);
        }
        //右旋转;左边连续连词红色节点
        if(null!=node.getLeft()&&isRed(node.getLeft())&&isRed(node.getLeft().getLeft())){
            //右旋转
            node= rotateRight(node);
        }

        //todo 颜色翻转？
        //左右两边都是红色就颜色翻转
        if(null!=node.getLeft()&&null!=node.getRight()&&isRed(node.getLeft())&&isRed(node.getRight())){
            flipColor(node);
        }
        return node;
    }

    public Node get(K key){
        return get(root,key);
    }

    public Node get(Node<K,V> node,K key){

        //根据当前节点和key递归查询

        if(null==node) return null;
        int compareResult = key.compareTo(node.getKey());

        if (compareResult>0) {
            //right node
            return get(node.getRight(),key);
        }else if(compareResult<0){
            //left node
            return get(node.getLeft(),key);
        }else if(compareResult==0){
            return node;
        }else{
            return null;
        }
    }

    public int size(){
        return this.count;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RedBlackTree.class.getSimpleName() + "[", "]")
                .add("root=" + root)
                .add("count=" + count)
                .toString();
    }
}
