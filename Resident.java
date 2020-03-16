package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Resident {
    List<Hospital> list;
    Hospital assignedHospital;
    String nume;

    Resident(String nume){
        list= new ArrayList<>();
        this.nume=nume;
    }

    public void setAssignedHospital(Hospital h){
        assignedHospital =new Hospital();
        assignedHospital=h;
    }

   public void addHospital(Hospital hospital)
    {
        list.add(hospital);
    }

   public String getNume(){return nume;}

    public List<Hospital> getList() {
        return list;
    }

    public Hospital getAssignedHospital() {return assignedHospital;
    }
}


class Byname implements Comparator<Resident>
{
    public int compare(Resident a, Resident b)
    {
        return a.getNume().compareTo(b.getNume());
    }
}
