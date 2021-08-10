package ch.hslu.mobpro.comandcon;

import java.util.List;

public class AcronymDef {
    private String sf;
    private List<LongForm> lfs;

    public static class LongForm{
        public String lf;
        public int freq;
        public int since;
        public List<Variation> vars;
    }

    public static class Variation {
        public String lf;
        public int freq;
        public int since;
    }

    @Override
    public String toString() {
        return this.sf + " " + this.lfs.get(0);
    }
}
