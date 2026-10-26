class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        // Do nothing for internal nodes
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue(); // Sum values of all leaves
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long result = 1;
    private final int MOD = 1000000007;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            result = (result * node.getValue()) % MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            result = (result * leaf.getValue()) % MOD;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int sumEvenDepthNonLeaves = 0;
    private int sumGreenLeaves = 0;

    public int getResult() {
        return Math.abs(sumEvenDepthNonLeaves - sumGreenLeaves);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            sumEvenDepthNonLeaves += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            sumGreenLeaves += leaf.getValue();
        }
    }
}
