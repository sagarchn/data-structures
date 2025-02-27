package org.chn.utils.Collections;

import java.util.Comparator;
import java.util.Objects;

/**
 * 5
 * /    \
 * 3      8
 * \    /  \
 * 4   7    10
 * /
 * 9
 *
 * @param <T>
 */
public class BinaryTree<T> {

    private Node<T> root;
    private final Comparator<T> comparator;


    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public static class Node<T> {
        T val;
        Node<T> left;
        Node<T> right;

        Node(T val) {
            this.val = val;
        }

        boolean isLeafNode() {
            return null == left && null == right;
        }

        public void addLeft(T t, Comparator<T> comparator) {
            if (null == left) {
                left = new Node<>(t);
                return;
            }
            if (comparator.compare(left.val, t) > 0) {
                left.addLeft(t, comparator);
            } else {
                left.addRight(t, comparator);
            }
        }

        public void addRight(T t, Comparator<T> comparator) {
            if (null == right) {
                right = new Node<>(t);
                return;
            }
            if (comparator.compare(right.val, t) > 0) {
                right.addLeft(t, comparator);
            } else {
                right.addRight(t, comparator);
            }
        }

        public void value(StringBuilder sb) {
            if (null != left) {
                left.value(sb);
            }
            sb.append(this.val).append(", ");
            if (right != null) {
                right.value(sb);
            }
        }

        public Node<T> getLeftMostNodeFromRight() {
            if (null == right) {
                return left;
            }
            return right.getLeftMost();
        }

        private Node<T> getLeftMost() {
            if (null == left) {
                return this;
            }
            return left.getLeftMost();
        }

        public void removeLeft(T t, Comparator<T> comparator) {
            // root is safe
            if (null == left) {
                return;
            }
            if (Objects.equals(left.val, t)) { // to remove
                // if leaf node
                if (left.isLeafNode()) {
                    left = null;
                } else {
                    left = left.getLeftMostNodeFromRight();
                }
            } else { // keep searching
                if (comparator.compare(left.val, t) > 0) {
                    left.removeLeft(t, comparator);
                } else {
                    left.removeRight(t, comparator);
                }
            }

        }

        public void removeRight(T t, Comparator<T> comparator) {
            // root is safe
            if (null == right) {
                return;
            }
            if (Objects.equals(right.val, t)) { // to remove
                // if leaf node
                if (right.isLeafNode()) {
                    right = null;
                } else {
                    right = right.getLeftMostNodeFromRight();
                }
            } else { // keep searching
                if (comparator.compare(right.val, t) > 0) {
                    right.removeLeft(t, comparator);
                } else {
                    right.removeRight(t, comparator);
                }
            }

        }

        public Node<T> remove(Node<T> node, T val, Comparator<T> comparator) {
            if (node == null) return null;
            if (comparator.compare(node.val, val) > 0) { // remove from left
                node.left = remove(node.left, val, comparator);
            } else if (comparator.compare(node.val, val) < 0) { // remove from right
                node.right = remove(node.right, val, comparator);
            } else { // remove current
                if (null == node.left && null == node.right) { // if leaf node
                    return null;
                }
                if (null == node.left) { // if left is not there
                    return node.right;
                }
                if (null == node.right) { // if right is not there
                    return node.left;
                }

                Node<T> minNode = node.getLeftMostNodeFromRight();
                node.val = minNode.val;
                node.right = remove(node.right, minNode.val, comparator);
            }
            return node;
        }
    }

    public void add(T t) {
        if (null == root) { // initialize root
            root = new Node<>(t);
            return;
        }
        if (lessThanThis(t)) { // add to left
            root.addLeft(t, comparator);
        } else { // add to right
            root.addRight(t, comparator);
        }


    }

    public void remove(T t) {
        if (null == t) throw new NullPointerException("Cannot remove null !");
        if (null == root) {
            throw new NullPointerException("Nothing to remove!");
        }
        root = root.remove(root, t, comparator);

    }

    public void print() {

        if (null == root) {
            System.err.println("Tree is empty!");
        }

        StringBuilder sb = new StringBuilder();
        root.value(sb);

        System.out.println(sb.toString());


    }

    // true if less than root else false;
    private boolean lessThanThis(T elem) {
        return this.comparator.compare(this.root.val, elem) > 0;
    }

}
