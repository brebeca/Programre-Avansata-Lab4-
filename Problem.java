package com.company;

import java.util.List;

public class Problem {
    Matching matching;

    public Problem() {
        matching=new Matching();
    }

    @Override
    public String toString() {
        return  matching.toString();
    }

/**
 * pt fiecare rezident r1 se verifica daca exista un spital pe care l ar fi preferat mai mult decat pe cel la care a fost asignat(cu indexul n)
 * pt fiecare astfel de spital (cu indexul 0..n-1) din lista preferintelor lui R se verifica daca exitsta un alt rezident r2 asa incat r1 sa fie mai preferat decat r2 caz in care NU ESTE STABIL
 * daca nu se gaseste atunci se considera ca ESTE STABIL*/

    public boolean isStable(){
        int n;
        Hospital hospitalTemp;
        Resident r1;
        for (Pair p :matching.getPairs())
        {
            r1=p.getResident();
            n=r1.getList().indexOf(p.getHospital());
            if(n!=0)
            {
                for(int i =0; i<n ;i++)
                {
                    hospitalTemp=r1.getList().get(i);
                    for(Resident r2 : hospitalTemp.getAssignedRes())
                    {
                        if(hospitalTemp.getAssignedRes().indexOf(r1)  <  hospitalTemp.getAssignedRes().indexOf(r2))
                            return false ;
                    }
                }

            }
        }
        return true;
    }

    /**
 * se creaza perechi printr-o asignare de tip Greedy :
 * pt fiecare spital in ordinea in care apar in lista se asigneaza cat de multi rezidenti incap
 * cand limita spitalului este depasita se trece la urmatorul
 *  fiecare asignare inseamna  ca se creaza cate o pereche care este adaugata in matching
 * bucla se opreste cand nu mai sunt rezidenti care sa fie asignati sau cand nu mai sunt spitale in liste
 * */
    public void createMatching(List<Resident> residents, List<Hospital> hospitals) {
        int hospitalNo=0, residentNo=0;
        boolean ok=true;
        while (ok)
        {
            if(residentNo>=residents.size()||hospitalNo>=hospitals.size())
                ok=false;
            else {
                if(hospitals.get(hospitalNo).capacityExceeded()==false) {
                    Pair pair= new Pair(residents.get(residentNo),hospitals.get(hospitalNo));
                    matching.addPair(pair);
                    hospitals.get(hospitalNo).fillASpot(residents.get(residentNo));
                    residents.get(residentNo).setAssignedHospital(hospitals.get(hospitalNo));
                    residentNo++;
                }
                else {
                    hospitalNo++;
                }
            }
        }
    }
}
