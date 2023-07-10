package lesson16;

public class MyBinaryTree<T extends Comparable<T>> {

    public class Vortex implements Comparable<Vortex> {
        Vortex left; // левая дочерняя
        Vortex right; // правая дочерняя
        T value; // значение вершины

        public Vortex(T value) {
            this.value = value;
        }

        public Vortex(Vortex left, Vortex right, T value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder b = new StringBuilder("{");
            b.append("\"left\":");
            b.append(left == null ? "{}" : left.toString());
            b.append(", \"value\":");
            b.append(value);
            b.append(", ");
            b.append("\"right\":");
            b.append(right == null ? "{}" : right.toString());
            b.append("}");
            return b.toString();
        }


        public int depth() {
            /*
            int depthLeft = 0;
            int depthRight = 0;
            if (left != null)
                depthLeft = left.depth();
            if (right != null)
                depthRight = right.depth();
            return 1 + Math.max(depthLeft, depthRight);
            */
            return 1 + Math.max(
                    left == null ? 0 : left.depth(),
                    right == null ? 0 : right.depth()
            );
        }
        public int countVortexes() {
            return 1 +
                    (left == null ? 0 : left.countVortexes()) +
                    (right == null ? 0 : right.countVortexes())
                    ;
        }

        @Override
        public int compareTo(Vortex o) {
            return value.compareTo(o.value);
        }
    }

    private Vortex root;

    public MyBinaryTree(Vortex root) {
        this.root = root;
    }

    public int depth() { //глубина дерева
        return root.depth();
    }

    public void add(T value) {
        root = addRecursive(root, value);
    }

    private Vortex addRecursive(Vortex current, T value) {
        if (current == null)
            return new Vortex(value);
        if (value.compareTo(current.value) < 0)
            current.left = addRecursive(current.left, value);
        else if (value.compareTo(current.value) > 0)
            current.right = addRecursive(current.right, value);
        return current;
    }

    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Vortex current, T value) {
        if (current == null)
            return false;
        if (value.equals(current.value))
            return true;
        else if (value.compareTo(current.value) < 0)
            return containsRecursive(current.left, value);
        return containsRecursive(current.right, value);

    }
    @Override
    public String toString() {
        return root.toString();
    }

    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    public Vortex deleteRecursive(Vortex current, T value) {
        if (current == null)
            return null;
        if (value.compareTo(current.value) < 0) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        else if (value.compareTo(current.value) > 0) {
            current.right = deleteRecursive(current.right, value);
            return current;
        }
        if (current.left == null && current.right == null)
            return null;
        else if (current.left == null) {
            return current.right;
        }
        else if (current.right == null) {
            return current.left;
        }

        T smallestValue = findSmallestValue(current.right);
        current.value = smallestValue;
        current.right = deleteRecursive(current.right, smallestValue);
        return current;
    }

    private T findSmallestValue(Vortex current) {
        return current.left == null ?
                current.value :
                findSmallestValue(current.left);
    }
}
