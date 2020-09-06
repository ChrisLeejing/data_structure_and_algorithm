package com.jikeshijian.chris;

/**
 * This is description.
 *
 * @author Chris0710
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private int N;

    private class Node {
        public Key key;
        public Value value;
        public Node left;
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public Node put(Node x, Key key, Value value) {
        // 1. if the x is null, then <key, value> element is the current new subTree(left subTree or right subTree).
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }

        // 2. if the x is not null, put the <key, value> element to the x tree.
        int i = key.compareTo(x.key);
        // 2.1 if key < x.key, then continue to find the left subTree.
        // 2.2 if key > x.key, then continue to find the right subTree.
        // 2.3 if key = x.key, then replace the x.value with value.
        if (i < 0) {
            x.left = put(x.left, key, value);
        } else if (i > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }

        return x;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        // 1. if the x is null, return null.
        if (x == null) {
            return null;
        }

        // 2. if the x is not null, return the value of x.
        int j = key.compareTo(x.key);
        // 2.1 if key < x.key, then continue to find the left subTree.
        // 2.2 if key > x.key, then continue to find the right subTree.
        // 2.3 if key = x.key, then return the value of x.
        if (j < 0) {
            return get(x.left, key);
        } else if (j > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    public void delete(Key key) {
        delete(root, key);
    }

    public Node delete(Node x, Key key) {
        // 1. if the x is null, return null.
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            N--;
            // 2. if x doesn't have the left subTree nor the right subTree.
            if (x.left == null) {
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }

            // 3. find the minNode of the right subTree.(or find the maxNode of the left subTree)
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            // 4. delete the minNode of the right subTree.
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }

            // 5.1 make the leftNode of originTree to be the leftNode of the minNode.
            // 5.2 make the rightNode of originTree to be the rightNode of the minNode.
            // 5.3 make the minNode to be the new x node.
            minNode.left = x.left;
            minNode.right = x.right;
            x = minNode;
        }

        return x;
    }

    public int size() {
        return N;
    }

}
