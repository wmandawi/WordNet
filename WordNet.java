import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import java.util.HashMap;
import java.util.ArrayList;

public class WordNet {
    //id to synset
    private HashMap<Integer, String> nTOi;
    //noun to id
    private HashMap<String, ArrayList<Integer>> iTOn;
    private ShortestCommonAncestor sca;
    //private Digraph g;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null) 
        {
            throw new NullPointerException("synests is null.");
        }

        if (hypernyms == null) 
        {
            throw new NullPointerException("hypernyms is null.");
        }
        nTOi= new HashMap <Integer, String>();
        iTOn = new HashMap<String, ArrayList<Integer>>();
        int synsnum = synsets(synsets);
        Digraph g = hypernyms(hypernyms, synsnum);

        sca = new ShortestCommonAncestor(g);
    }
    //read in the file and build appropriate data structures 
    //Record the number of synsets for use when constructing the underlying digraph
    //from the hypernyms file
    private int synsets (String syns) {
        int synsnum = 0;

        In in = new In(syns);
        while (!in.isEmpty())
        {
            String[] a = in.readLine().split(",");
            Integer id = Integer.valueOf(a[0]);
            String noun = a[1];
            nTOi.put(id, noun);

            String[] nouns = noun.split(" ");

            for (String n : nouns) 
            {
                    ArrayList<Integer> list = iTOn.get(n);
                    if (list == null)
                    {
                        list = new ArrayList<>();
                    }
                    list.add(id);
                    iTOn.put(n, list);
            }
            synsnum++;
        }
        return synsnum;
    }
    //read in the hypernyms file and bulid a Digraph
    private Digraph hypernyms(String hyp, int synsnum) {
        Digraph digraph = new Digraph(synsnum);
        //digraph = g;
        In in = new In(hyp);
        while (!in.isEmpty()) 
        {
            String[] a = in.readLine().split(",");
            Integer sId = Integer.valueOf(a[0]);
            //ArrayList<Integer> list = new ArrayList<Integer>();

            for (int i = 1; i < a.length; i++) 
            {
                Integer id = Integer.valueOf(a[i]);
                //list.add(new Integer(id));
                digraph.addEdge(sId, id);
            }

        }
        return digraph;
    }
    // all WordNet nouns
    public Iterable<String> nouns() {
        return iTOn.keySet();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        if (word == null)
        {
            return false;
        }

        return(iTOn.containsKey(word));

    }

    // a synset (second field of synsets.txt) that is a shortest common ancestor
    // of noun1 and noun2 (defined below)
    public String sca(String noun1, String noun2) {
        if (noun1 == null) {
            throw new NullPointerException("noun1 is null."); 
        }

        if (noun2 == null) {
            throw new NullPointerException("noun2 is null.");
        }

        if (!isNoun(noun1) || !isNoun(noun2)) 
        {
            throw new IllegalArgumentException
            ("Noun1, Noun2 or both are not WordNet nouns.");
        }

        ArrayList<Integer> n1 = iTOn.get(noun1);
        ArrayList<Integer> n2 = iTOn.get(noun2);
        int ans = sca.ancestor(n1, n2);
        return nTOi.get(ans);
    }

    // distance between noun1 and noun2 (defined below)
    public int distance(String noun1, String noun2) {
        if (noun1 == null) 
        {
            throw new NullPointerException("noun1 is null."); 
        }

        if (noun2 == null) 
        {
            throw new NullPointerException("noun2 is null.");
        }

        if (!isNoun(noun1) || !isNoun(noun2)) 
        {
            throw new IllegalArgumentException
            ("Noun1, Noun2 or both are not WordNet nouns.");
        }

        ArrayList<Integer> n1 = iTOn.get(noun1);
        ArrayList<Integer> n2 = iTOn.get(noun2);

        return sca.length(n1, n2); 
    }

    // do unit testing of this class
    public static void main(String[] args) {
    }
}