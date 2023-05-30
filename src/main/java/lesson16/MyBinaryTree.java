package lesson16;

public class MyBinaryTree {

    static class Vortex {
        Vortex left; // левая дочерняя
        Vortex right; // правая дочерняя
        int value; // значение вершины

        public Vortex(int value) {
            this.value = value;
        }

        public Vortex(Vortex left, Vortex right, int value) {
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
    }

    private Vortex root;

    public MyBinaryTree(Vortex root) {
        this.root = root;
    }

    public int depth() { //глубина дерева
        return root.depth();
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Vortex addRecursive(Vortex current, int value) {
        if (current == null)
            return new Vortex(value);
        if (value < current.value)
            current.left = addRecursive(current.left, value);
        else if (value > current.value)
            current.right = addRecursive(current.right, value);
        return current;
    }

    public boolean contains(int value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Vortex current, int value) {
        if (current == null)
            return false;
        if (value == current.value)
            return true;
        else if (value < current.value)
            return containsRecursive(current.left, value);
        return containsRecursive(current.right, value);

    }
    @Override
    public String toString() {
        return root.toString();
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    public Vortex deleteRecursive(Vortex current, int value) {
        if (current == null)
            return null;
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        else if (value > current.value) {
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

        int smallestValue = findSmallestValue(current.right);
        current.value = smallestValue;
        current.right = deleteRecursive(current.right, smallestValue);
        return current;
    }

    private int findSmallestValue(Vortex current) {
        return current.left == null ?
                current.value :
                findSmallestValue(current.left);
    }
}
