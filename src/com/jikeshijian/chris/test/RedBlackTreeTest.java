package com.jikeshijian.chris.test;

import com.jikeshijian.chris.tree.RedBlackTree;

/**
 * This is description.
 *
 * @author Chris0710
 * @Email chrisleejing0710@gmail.com
 */
public class RedBlackTreeTest {
    public static void main(String[] args) {
        // 创建红黑树
        RedBlackTree<String, String> tree = new RedBlackTree<>();

        // 往树中插入元素
        tree.put("1", "张三");
        tree.put("2", "李四");
        tree.put("3", "王五");

        // 从树中获取元素
        String r1 = tree.get("1");
        System.out.println(r1);

        String r2 = tree.get("2");
        System.out.println(r2);

        String r3 = tree.get("3");
        System.out.println(r3);

        System.out.println("树的节点个数: " + tree.size());
    }
}
