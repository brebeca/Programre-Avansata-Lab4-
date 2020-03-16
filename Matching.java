package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class Matching {
    List<Pair> pairs;
    public void addPair(Pair pair){
        pairs.add(pair);
    }

    public Matching() {
        this.pairs = new ArrayList<>();
    }

    @Override
    public String toString() {
        String toPrint ="";
        for (Pair p :pairs)
        {
           toPrint=toPrint+"  ["+p.getHospital().getNume()+ "," +p.getResident().getNume()+"] ";
        }
        return "Matching{" +
                "pairs=" + toPrint +
                '}';
    }

   public List<Pair> getPairs(){return pairs;}
}
