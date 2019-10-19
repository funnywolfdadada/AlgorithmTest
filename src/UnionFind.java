import java.util.Arrays;

public class UnionFind {
    public static void main(String[] args) {
        int[][] links = {
                {4, 3},
                {3, 8},
                {6, 5},
                {9, 4},
                {2, 1},
                {8, 9},
                {5, 0},
                {7, 2},
                {6, 1},
                {1, 0},
                {6, 7},
        };

        BaseUF baseUF = new PressedWeightedQuickUnionUF(10);
        for (int[] link : links) {
            baseUF.union(link[0], link[1]);
        }
        System.out.println(baseUF.toString());
    }

    abstract static class BaseUF {
        int[] values;
        int count;

        BaseUF(int n) {
            count = n;
            values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = i;
            }
        }

        public int count() {
            return count;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        abstract public int find(int p);

        abstract public void union(int p, int q);

        @Override
        public String toString() {
            return count + " " + Arrays.toString(values);
        }
    }

    static class QuickFindUF extends BaseUF {

        QuickFindUF(int n) {
            super(n);
        }

        @Override
        public int find(int p) {
            return values[p];
        }

        @Override
        public void union(int p, int q) {
            int pValue = find(p);
            int qValue = find(q);
            if (pValue == qValue) { return; }
            count--;
            for (int i = 0; i < values.length; i++) {
                if (find(i) == pValue) {
                    values[i] = qValue;
                }
            }
        }
    }

    static class QuickUnionUF extends BaseUF {

        QuickUnionUF(int n) {
            super(n);
        }

        @Override
        public int find(int p) {
            while (p != values[p]) { p = values[p]; }
            return p;
        }

        @Override
        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) { return; }
            count--;
            values[pRoot] = qRoot;
        }

    }

    static class WeightedQuickUnionUF extends BaseUF {

        private int[] sizes;

        WeightedQuickUnionUF(int n) {
            super(n);
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
                sizes[i] = 1;
            }
        }

        @Override
        public int find(int p) {
            while (p != values[p]) { p = values[p]; }
            return p;
        }

        @Override
        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) { return; }
            count--;
            if (sizes[pRoot] < sizes[qRoot]) {
                values[pRoot] = qRoot;
                sizes[qRoot] += sizes[pRoot];
            } else {
                values[qRoot] = pRoot;
                sizes[pRoot] += sizes[qRoot];
            }
        }

    }

    static class PressedWeightedQuickUnionUF extends WeightedQuickUnionUF {

        PressedWeightedQuickUnionUF(int n) {
            super(n);
        }

        @Override
        public int find(int p) {
            int result = super.find(p);
            while (values[p] != result) {
                p = values[p];
                values[p] = result;
            }
            return result;
        }

    }

}
