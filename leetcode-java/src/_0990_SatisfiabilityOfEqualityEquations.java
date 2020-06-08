/**
 * 并查集数据结构
 * Created by goto456 on 2020/6/8.
 */
public class _0990_SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        // 表示每个节点在连通集中的父节点
        int[] parent = new int[26];
        // 初始化一个包含26个字母的数组，每个节点父节点指向自己，表示各自属于一个连通集
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // 将所有相当的数进行连通
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }

        // 遍历所有的不等式，如果2个字符在同一个相等连通集中，则返回false
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                // 根节点为同一个，则表示在同一个连通集中
                if (findRoot(parent, index1) == findRoot(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 对两个字符进行连通，放到同一个连通集中
     */
    private void union(int[] parent, int index1, int index2) {
        parent[findRoot(parent, index1)] = findRoot(parent, index2);
    }

    //

    /**
     * 寻找某个字符所在连通集的根节点，利用隔代压缩降低树的高度
     */
    private int findRoot(int[] parent, int index) {
        while (parent[index] != index) {
            // 隔代压缩
            parent[index] = parent[parent[index]];
            // 相等连通集中，相等具有传递性
            index = parent[index];
        }
        return index;
    }
}
