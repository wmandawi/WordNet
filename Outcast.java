public class Outcast {

    private WordNet wn;

    public Outcast(WordNet wordnet) {        // constructor takes a WordNet object
        wn = wordnet;
    }

    public String outcast(String[] nouns) {  // given an array of WordNet nouns, return an outcast
        String outcast = null;
        int dis = 0;
        int maxd = 0;
        for(int i = 0; i < nouns.length; i++) {
            for(int j = 0; j < nouns.length; j++) {
                dis = wn.distance(nouns[i], nouns[j]);
                dis++;

                if (dis > maxd) {
                    maxd = dis;
                    outcast = nouns[i];
                }
            }
        }
        return outcast;
    }

    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println(args[t] + ": " + outcast.outcast(nouns));
        }
    }
}