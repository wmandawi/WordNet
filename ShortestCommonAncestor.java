import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.Cycle;
import edu.princeton.cs.algs4.In;
import java.util.ArrayList;

public class ShortestCommonAncestor {
    private Digraph g;
    // constructor takes a rooted DAG as argument
    public ShortestCommonAncestor(Digraph G) {
        g = new Digraph(G);
        //test if acyclic
        DirectedCycle c = new DirectedCycle(g);

        //find number of roots
        int r = 0;
        for(int i = 0; i < g.V(); i++) {
            if (!g.adj(i).iterator().hasNext())
            {
                r++;
            }
        }
        //if not rooted throw exception
        if (r > 1 || c.hasCycle())
        {
            throw new IllegalArgumentException("It is not rooted.");
        }
    }

    // length of shortest ancestral path between v and w
    public int length(int v, int w) {
        //return length(g.adj(v), g.adj(w));
        int [] r = distance(v, w);
        return r[1];
    }

    // a shortest common ancestor of vertices v and w
    public int ancestor(int v, int w) {
        int [] r = distance(v, w);
        return r[0];
    }

    private int[] distance(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        //             int distance;
        //             int ancestors;
        int distance;
        int ancestors;
        BreadthFirstDirectedPaths bfsA = new BreadthFirstDirectedPaths(g, subsetA);
        BreadthFirstDirectedPaths bfsB = new BreadthFirstDirectedPaths(g, subsetB);
        ArrayList<Integer> anc = new ArrayList<>();
        int root = -1;
        int dis = Integer.MAX_VALUE;

        for (int i = 0; i < g.V(); i++)
        {
            if(bfsA.hasPathTo(i) && bfsB.hasPathTo(i))
            {
                anc.add(i);
            }
        }

        for (int ancestor : anc) 
        {
            if( bfsA.distTo(ancestor) + bfsB.distTo(ancestor) < dis)
            {
                dis = (bfsA.distTo(ancestor) + bfsB.distTo(ancestor));
                root = ancestor;
            }
        }

        if (dis == Integer.MAX_VALUE)
        {
            distance = -1;
        } else
        {
            distance = dis;
        }
        ancestors = root;
        int[] r = {ancestors, distance};
        return r;
    }

    private int[] distance(int v, int w)
    {
        int distance;
        int ancestors;
        BreadthFirstDirectedPaths bfsA = new BreadthFirstDirectedPaths(g, v);
        BreadthFirstDirectedPaths bfsB = new BreadthFirstDirectedPaths(g, w);
        ArrayList<Integer> anc = new ArrayList<>();
        int root = -1;
        int dis = Integer.MAX_VALUE;

        for (int i = 0; i < g.V(); i++)
        {
            if(bfsA.hasPathTo(i) && bfsB.hasPathTo(i))
            {
                anc.add(i);
            }
        }

        for (int ancestor : anc) 
        {
            if( bfsA.distTo(ancestor) + bfsB.distTo(ancestor) < dis)
            {
                dis = (bfsA.distTo(ancestor) + bfsB.distTo(ancestor));
                root = ancestor;
            }
        }

        if (dis == Integer.MAX_VALUE)
        {
            distance = -1;
        } else
        {
            distance = dis;
        }
        ancestors = root;
        int[] r = {ancestors, distance};
        return r;
    }

    // length of shortest ancestral path of vertex subsets A and B
    public int length(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        int[] r = distance(subsetA, subsetB);
        return r[1];
    }

    // a shortest common ancestor of vertex subsets A and B
    public int ancestor(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        int[] r = distance(subsetA, subsetB);
        return r[0];
    }

    // do unit testing of this class
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        ShortestCommonAncestor sca = new ShortestCommonAncestor(G);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length   = sca.length(v, w);
            int ancestor = sca.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }
}