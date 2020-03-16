package com.company;

import java.util.ArrayList;
import java.util.List;

public class Hospital implements Comparable<Hospital> {
    List<Resident> list;
    List<Resident> assignedRes;
    String nume;
    int capacity=0;
    int filled=0;


    public Hospital(String nume) {
        this.list = new ArrayList<>();
        this.nume=nume;
        this.assignedRes=new ArrayList<>();
    }
    public Hospital(){};
    public Hospital(String nume, int capacity) {
        this.list = new ArrayList<>();
        this.nume=nume;
        this.capacity=capacity;
        this.assignedRes=new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addResident(Resident resident)
    {
            list.add(resident);
    }

    public void addAsignedRes(Resident r)
    {
        assignedRes.add(r);
    }

    public void fillASpot(Resident r)
    {
        filled++;
        assignedRes.add(r);
    }

    public List<Resident> getAssignedRes() {
        return assignedRes;
    }

    public boolean capacityExceeded()
    {
        if(filled==capacity)
            return true;
        else
            return false;
    }

    public String getNume() {
        return nume;
    }

    @Override
    public int compareTo(Hospital o) {
        return this.getNume().compareTo(o.getNume());
    }

    public List<Resident> getList() {
        return list;
    }


}
