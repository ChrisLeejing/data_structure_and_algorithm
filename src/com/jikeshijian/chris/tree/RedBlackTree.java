package com.jikeshijian.chris.tree;


/**
 * This is description.
 *
 * @author Chris0710
 * @Email chrisleejing0710@gmail.com
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private int N;
    private static final boolean RED = true;
    public static final boolean BLACK = false;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int N;
        boolean color;

        Node(Key key, Value value, Node left, Node right, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            N = n;
            this.color = color;
        }
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    public int size() {
        return size(root);
    }

    /**
     * 判断一个结点和它的父结点之间的链接是否为红色.
     *
     * @param x
     * @return
     */
    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    /**
     * 左旋转: 当有一条红色的右链接时, 此时需要左旋转.
     *
     * @param h
     * @return
     */
    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);

        return x;
    }

    /**
     * 右旋转: 当某个结点的左子结点是红色, 且左子结点的左子结点也是红色时, 此时需要右旋转.
     *
     * @param h
     * @return
     */
    public Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);

        return x;
    }

    /**
     * 颜色转换: 当一个结点的左子结点和右子结点都为红色时, 此时需要颜色转换.
     *
     * @param h
     */
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    /**
     * 查找key, 找到则更新其值, 否则为它新建一个结点.
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    /**
     * 插入: 在指定数中进行插入, 插入完后, 返回添加元素后新的结点树.
     *
     * @param h
     * @param key
     * @param value
     * @return
     */
    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            return new Node(key, value, null, null, 1, RED);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        // 左旋转
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }

        // 右旋转
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }

        // 颜色转换
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol table
     * and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get(key) is null");
        }
        return get(root, key);
    }

    /**
     * value associated with the given key in subtree rooted at x; null if no such key.
     *
     * @return
     */
    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        }
        if (cmp > 0) {
            return get(x.right, key);
        }
        return x.value;
    }
}
