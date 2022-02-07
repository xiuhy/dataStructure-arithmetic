package dataStructure.tree;

import java.util.StringJoiner;

/**
 * @author bigmoon
 * @date 2022/2/2
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class Node<K,V> {

    private K key;
    private V value;
    private Node<K,V> leftNode;
    private Node<K,V> rightNode;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public Node(K key, V value, Node leftNode, Node rightNode) {
        this.key = key;
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K,V> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node<K,V> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                .add("key=" + key)
                .add("value=" + value)
                .add("leftNode=" + leftNode)
                .add("rightNode=" + rightNode)
                .toString();
    }
}
