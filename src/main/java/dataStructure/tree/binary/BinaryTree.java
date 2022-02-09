package dataStructure.tree.binary;

import dataStructure.tree.Node;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringJoiner;

import static java.util.Optional.ofNullable;

/**
 * @author bigmoon
 * @date 2022/2/2
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class BinaryTree<K extends Comparable<K>, V> {

    private Node<K, V> root;
    private int count;

    public void put(K key, V value) {
        this.root = put(root, key, value);
    }

    public Node put(Node<K, V> node, K key, V value) {

        if (null == node) {
            this.count++;
            node = new Node<>(key, value);
            return node;
        }

        int i = key.compareTo(node.getKey());

        if (i < 0) {
            //key小于当前节点
            node.setLeftNode(put(node.getLeftNode(), key, value));
        } else if (i > 0) {
            //key 大于当前节点
            node.setRightNode(put(node.getRightNode(), key, value));
        } else {
            //key 等于当前节点
            node.setValue(value);
        }
        return node;
    }

    public V get(K key) {
        return get(this.root, key);

    }

    public V get(Node<K, V> node, K key) {

        if (null == node) {
            return null;
        }

        int i = key.compareTo(node.getKey());

        if (i < 0) {
            //key小于当前节点
            return get(node.getLeftNode(), key);
        } else if (i > 0) {
            //key 大于当前节点
            return get(node.getRightNode(), key);
        } else {
            //key 等于当前节点
            return node.getValue();
        }
    }

    public void del(K key) {
        del(this.root, key);
    }

    public Node<K, V> del(Node<K, V> node, K key) {
        if (null == node) {
            return null;
        }

        int i = key.compareTo(node.getKey());

        if (i < 0) {
            //key小于当前节点
            node.setLeftNode(del(node.getLeftNode(), key));
        } else if (i > 0) {
            //key 大于当前节点
            node.setRightNode(del(node.getRightNode(), key));
        } else {
            //key 等于当前节点
            this.count--;

            if (node.getRightNode() == null) {
                //此处是直接使用左侧节点顶替可以(也可以使用右侧节点最小节点)
                return node.getLeftNode();
            }

            if (node.getLeftNode() == null) {
                //此处直接用rightNode 顶替可以(也可以使用右侧节点最小节点)
                return node.getRightNode();
            }

            Node<K, V> rightNode = node.getRightNode();
            Node<K, V> minNodeParent = null;
            //获取最左侧节点和上一个节点
            while (rightNode != null) {

                //如果不存在左侧节点则直接返回
                if (null == rightNode.getLeftNode()) {
                    break;
                }

                //获取最小节点的上一个节点
                if (rightNode.getLeftNode() != null && rightNode.getLeftNode().getLeftNode() == null) {
                    minNodeParent = rightNode;
                }
                rightNode = rightNode.getLeftNode();
            }

            //先删除最小节父级关系
            if (null != minNodeParent) {
                minNodeParent.setLeftNode(null);
            }
            //其次，替换被删除节点左右节点
            rightNode.setLeftNode(node.getLeftNode());
            rightNode.setRightNode(node.getRightNode());
            //重新替换
            node = rightNode;
        }
        return node;
    }

    public V min() {
        return min(this.root).getValue();
    }

    /**
     * 通过制定节点查询最小值
     *
     * @return dataStructure.tree.Node<K, V>
     * @author bigmoon
     * @params [node]
     * @see [相关类/方法]（可选）
     * @since
     */
    private Node<K, V> min(Node<K, V> node) {

        if (node == null) {
            return null;
        }

        //A:通过递归方式实现
//        if (node.getLeftNode() != null) {
//            return min(node.getLeftNode());
//        }else{
//            return node;
//        }

        //region#B:通过循环实现
        Node<K, V> node1 = node;

        while (null != node1.getLeftNode()) {

            if (node1.getLeftNode() != null) {
                node1 = node1.getLeftNode();
            } else {
                break;
            }
        }
        return node1;

    }

    /**
     * 获取最大节点值
     *
     * @return V
     * @author bigmoon
     * @params []
     * @see [相关类/方法]（可选）
     * @since
     */
    public V max() {
        return max(root).getValue();
    }

    protected Node<K, V> max(Node<K, V> node) {

        if (node == null) {
            return null;
        }

        //A 递归
//        if (node.getRightNode() != null) {
//            return max(node.getRightNode());
//        }else{
//            return node;
//        }

        //B 循环
        Node<K, V> node1 = node;
        while (null != node1.getRightNode()) {

            if (node1.getRightNode() != null) {
                node1 = node1.getRightNode();
            } else {
                break;
            }
        }
        return node1;
    }

    /**
     * 前序遍历树形结构所有key
     *
     * @return java.util.Queue<K>
     * @author bigmoon
     * @params []
     * @see [相关类/方法]（可选）
     * @since
     */
    public Queue<K> preErgodic() {
        Queue<K> keys = new ArrayDeque<>();
        preErgodic(this.root, keys);
        return keys;
    }

    private void preErgodic(Node<K, V> node, Queue<K> keys) {

        if (node == null) {
            return;
        }
        //前序遍历先插入根节点
        keys.add(node.getKey());

        //然后判断左子树，存在则遍历
        if (node.getLeftNode() != null) {
            preErgodic(node.getLeftNode(), keys);
        }
        //最后判断是否存在右子树，存在则遍历
        if (node.getRightNode() != null) {
            preErgodic(node.getRightNode(), keys);
        }
    }

    /**
     * 中序遍历树形结构所有key
     * 左子树 -->根节点 -->右子树
     *
     * @return java.util.Queue<K>
     * @author bigmoon
     * @params []
     * @see [相关类/方法]（可选）
     * @since
     */
    public Queue<K> midErgodic() {
        Queue<K> keys = new ArrayDeque<>();
        midErgodic(this.root, keys);
        return keys;
    }

    private void midErgodic(Node<K, V> node, Queue<K> keys) {

        if (node == null) {
            return;
        }

        //中序遍历，则优先遍历左子树

        if (node.getLeftNode() != null) {
            midErgodic(node.getLeftNode(), keys);
        }
        //插入 根节点
        keys.add(node.getKey());

        //遍历右子树
        if (node.getRightNode() != null) {
            midErgodic(node.getRightNode(), keys);
        }
    }


    /**
     * 后序遍历树形结构所有key
     * 左子树 -->右子树 -->根节点
     *
     * @return java.util.Queue<K>
     * @author bigmoon
     * @params []
     * @see [相关类/方法]（可选）
     * @since
     */
    public Queue<K> afterErgodic() {
        Queue<K> keys = new ArrayDeque<>();
        afterErgodic(this.root, keys);
        return keys;
    }

    private void afterErgodic(Node<K, V> node, Queue<K> keys) {

        if (node == null) {
            return;
        }

        //后序序遍历，则优先遍历左子树
        if (node.getLeftNode() != null) {
            afterErgodic(node.getLeftNode(), keys);
        }

        //遍历右子树
        if (node.getRightNode() != null) {
            afterErgodic(node.getRightNode(), keys);
        }

        //插入 根节点
        keys.add(node.getKey());
    }

    //二叉树层序遍历，一层一层遍历，从左往右
    public Queue<K> layerErgodic() {
        Queue<K> kQueue = new ArrayDeque<>();
        Queue<Node<K, V>> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(this.root);

        while (!nodeQueue.isEmpty()) {

            Node<K, V> tmpNode = nodeQueue.poll();

            ofNullable(tmpNode).ifPresent(item -> {
                kQueue.add(item.getKey());

                if (tmpNode.getLeftNode() != null) {
                    nodeQueue.add(tmpNode.getLeftNode());
                }
                if (tmpNode.getRightNode() != null) {
                    nodeQueue.add(tmpNode.getRightNode());
                }
            });
        }
        return kQueue;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BinaryTree.class.getSimpleName() + "[", "]")
                .add("root=" + root)
                .add("count=" + count)
                .toString();
    }
}
