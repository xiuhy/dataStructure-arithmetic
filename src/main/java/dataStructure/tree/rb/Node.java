package dataStructure.tree.rb;

import java.util.StringJoiner;

/**
 * 红黑树节点
 * @author bigmoon
 * @date 2022/3/26
 * @return
 * @see [相关类/方法]（可选）
 * @since
 */
public class Node<K extends Comparable<K>,V> {

    private boolean redColor;
    private K key;
    private V value;
    private Node left;
    private Node right;

    public Node(boolean redColor, K key, V value, Node left, Node right) {
        this.redColor = redColor;
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public boolean isRedColor() {
        return redColor;
    }

    public void setRedColor(boolean redColor) {
        this.redColor = redColor;
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

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                .add("redColor=" + redColor)
                .add("key=" + key)
                .add("value=" + value)
                .add("left=" + left)
                .add("right=" + right)
                .toString();
    }
}
