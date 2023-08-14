package lesson16;

public class  MyGenericBinaryTree <T extends Comparable<T>> {

    public static class Vortex <T> {
        T value; // значение вершины
        Vortex<T> left; // левая дочерняя
        Vortex<T> right; // правая дочерняя

        public Vortex(T value) {
            this.value = value;
        }

        public Vortex(T value, Vortex<T> left, Vortex<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int depth() {
            /*
            int depthLeft = 0;
            int depthRight = 0;
            if(left != null)
                depthLeft = left.depth();
            if(right != null)
                depthRight = right.depth();
            return 1 + Math.max(depthLeft, depthRight);
             */
            return 1 + Math.max(
                    (left == null ? 0 : left.depth()),
                    (right == null ? 0 : right.depth()
                    )
            );
        }

        @Override
        public String toString() {
            StringBuilder b = new StringBuilder("{");
            b.append("\"left\":");
            b.append(left == null ? "{}" : left.toString());
            b.append(", \"value\":");
            b.append("\"" + value + "\"");
            b.append(", ");
            b.append("\"right\":");
            b.append(right == null ? "{}" : right.toString());
            b.append("}");
            return b.toString();
        }

        // до 21:40
        public int countVortexes() {
            return 1 +
                    (left == null ? 0 : left.countVortexes()) +
                    (right == null ? 0 : right.countVortexes())
                    ;
        }
    }

    private Vortex <T> root; // корень дерева

    public MyGenericBinaryTree(Vortex <T> root) {
        this.root = root;
    }

    public int depth() // глубина дерева
    {
        return root.depth();
    }


    public void add(T value) {
        root = addRecursive(root, value);
    }

    private Vortex<T> addRecursive(Vortex<T> current, T value) {
        if (current == null)
            return new Vortex<T>(value);
        if (value.compareTo(current.value) < 0)
            current.left = addRecursive(current.left, value);
        else if (value.compareTo(current.value) > 0)
            current.right = addRecursive(current.right, value);
        return current;
    }

    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    // до 20:52
    private boolean containsRecursive(Vortex<T> current, T value) {
        if (current == null)
            return false;
        if (value.compareTo(current.value) == 0)
            return true;
        else if (value.compareTo(current.value) < 0) {
            return containsRecursive(current.left, value);
        }
        return containsRecursive(current.right, value);
    }


    @Override
    public String toString() {
        return root.toString();
    }

    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    public Vortex<T> deleteRecursive(Vortex<T> current, T value) {
        if (current == null)
            return null;

        if (value.compareTo(current.value) < 0) {
            current.left = deleteRecursive(current.left, value);
            return current;
        } else if (value.compareTo(current.value) > 0) {
            current.right = deleteRecursive(current.right, value);
            return current;
        }
        // current.value == value - нужно удалить текущий элемент
        if (current.left == null && current.right == null)
            return null;
        else if (current.left == null) {
            return current.right;
        } else if (current.right == null) {
            return current.left;
        }

        T smallestValue = findSmallestValue(current.right);
        current.value = smallestValue;
        current.right = deleteRecursive(current.right, smallestValue);
        return current;
    }

    private T findSmallestValue(Vortex<T> current) {
        return current.left == null ?
                current.value :
                findSmallestValue(current.left);
    }

    public int countVortexes()
    {
        return root.countVortexes();
    }

}
