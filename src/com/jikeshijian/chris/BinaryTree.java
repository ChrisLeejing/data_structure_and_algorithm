package com.jikeshijian.chris;

import com.jikeshijian.chris.list1.Queue;

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

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x == null) {
            return null;
        }

        if (x.left != null) {
            return min(x.left);
        } else {
            return x;
        }
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x == null) {
            return null;
        }

        if (x.right != null) {
            return max(x.right);
        } else {
            return x;
        }
    }

    public Queue<Key> preErgodic() {
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    private void preErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
        keys.enqueue(x.key);

        if (x.left != null) {
            preErgodic(x.left, keys);
        }

        if (x.right != null) {
            preErgodic(x.right, keys);
        }
    }

    public Queue<Key> midErgodic() {
        Queue<Key> keys = new Queue<>();
        midErgodic(root, keys);
        return keys;
    }

    private void midErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
        if (x.left != null) {
            midErgodic(x.left, keys);
        }

        keys.enqueue(x.key);

        if (x.right != null) {
            midErgodic(x.right, keys);
        }
    }

    public Queue<Key> postErgodic() {
        Queue<Key> keys = new Queue<>();
        postErgodic(root, keys);
        return keys;
    }

    private void postErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
        if (x.left != null) {
            postErgodic(x.left, keys);
        }

        if (x.right != null) {
            postErgodic(x.right, keys);
        }

        keys.enqueue(x.key);
    }

    public Queue<Key> layerErgodic() {
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();

        nodes.enqueue(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.dequeue();
            keys.enqueue(node.key);

            if (node.left != null) {
                nodes.enqueue(node.left);
            }

            if (node.right != null) {
                nodes.enqueue(node.right);
            }
        }
        return keys;
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    public int maxDepth(Node x) {
        if (x == null) {
            return 0;
        }

        int max = 0;
        int maxLeft = 0;
        int maxRight = 0;

        if (x.left != null) {
            maxLeft = maxDepth(x.left);
        }
        if (x.right != null) {
            maxRight = maxDepth(x.right);
        }

        max = maxLeft > maxRight ? maxLeft + 1 : maxRight + 1;

        return max;
    }
}
