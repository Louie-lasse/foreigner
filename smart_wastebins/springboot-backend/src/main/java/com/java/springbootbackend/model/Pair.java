package com.java.springbootbackend.model;


import java.util.Objects;

public class Pair<L, R> {

    private L left;
    private R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

    public void setLeft(L left) {
        this.left = left;
    }

    public void setRight(R right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "<" + left + "," + right + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Pair<?, ?> other)) {
            return false;
        }
        return this.getLeft().equals(other.getLeft()) && this.getRight().equals(other.getRight())
                || this.getLeft().equals(other.getRight()) && this.getRight().equals(other.getLeft());
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
