package com.company;
import com.github.javafaker.Faker;

import java.util.function.Predicate;
import java.util.*;

public class Main {


    public static void main(String[] args) {
	Resident resident0= new Resident("r0");
        Resident resident1= new Resident("r1");
        Resident resident2= new Resident("r2");
        Resident resident3= new Resident("r3");
        Hospital hospital0= new Hospital("h0",1);
        Hospital hospital1= new Hospital("h1",2);
        Hospital hospital2= new Hospital("h2",2);

        resident0.addHospital(hospital0);
        resident0.addHospital(hospital1);
        resident0.addHospital(hospital2);
        resident1.addHospital(hospital0);
        resident1.addHospital(hospital1);
        resident1.addHospital(hospital2);
        resident2.addHospital(hospital0);
        resident2.addHospital(hospital1);
        resident3.addHospital(hospital0);
        resident3.addHospital(hospital2);

        hospital0.addResident(resident3);
        hospital0.addResident(resident0);
        hospital0.addResident(resident1);
        hospital0.addResident(resident2);
        hospital1.addResident(resident0);
        hospital1.addResident(resident2);
        hospital1.addResident(resident1);
        hospital2.addResident(resident0);
        hospital2.addResident(resident1);
        hospital2.addResident(resident3);

        List<Hospital> hospitals =new ArrayList<>();
        hospitals.add(hospital0);
        hospitals.add(hospital1);
        hospitals.add(hospital2);

        List<Resident> residents= new ArrayList<>();
        residents.add(resident0);
        residents.add(resident1);
        residents.add(resident2);
        residents.add(resident3);
        Collections.sort(residents,new Byname());

        Set<Hospital> set =new TreeSet<>();
        set.add(hospital0);
        set.add(hospital1);
        set.add(hospital2);

        Map<Resident,List<Hospital>> residentPref = new HashMap<>();
        for(Resident temp : residents) {
                residentPref.put(temp, temp.getList());
        }
        /*for(Map.Entry<Resident,List<Hospital>> entry : residentPref.entrySet())
        {
            System.out.println(entry.getKey().getNume()+" -> ");
            for(Hospital h:entry.getValue())
            {
                System.out.print(" "+h.getNume());
            }
            System.out.println(" ");
        }

        SortedMap<Hospital,List<Resident>> hospitalPref =new TreeMap<>();
        for(Hospital temp : set){
                hospitalPref.put(temp,temp.getList());

        }
        for(Map.Entry<Hospital,List<Resident>> entry : hospitalPref.entrySet())
        {
            System.out.println(entry.getKey().getNume()+" -> ");
            for (Resident h: entry.getValue())
            {
                System.out.print(" "+h.getNume());
            }
            System.out.println(" ");
        }*/

        /**
         *Compulsory: Using Java Stream API, write queries that display the residents who find acceptable H0 and H2, and the hospitals that have R0 as their top preference.
         * */

       System.out.println(" residents who find acceptable H0 and H2");
       residents.stream()
               .filter(resident->resident.getList().contains(hospital0))
               .filter(resident->resident.getList().contains(hospital2))
               .forEach(resident->System.out.println(resident.getNume()));



        System.out.println(" hospitals that have R0 as their top preference");
        hospitals.stream()
                .filter(hospital -> hospital.getList().get(0).getNume()=="r0")
                .forEach(hospital->System.out.println(hospital.getNume()));



        /**
         * Optional: -Implement an algorithm for creating a matching
         * algoritm testat pe exemplul din laborator*/


        Problem problem1=new Problem();
        problem1.createMatching(residents,hospitals);
        //System.out.println(problem1.toString());

        /**
         * Optional: -Create random instances and test your algorithm.
         * */

        Faker f= new Faker();
        List<Resident> residentList= new ArrayList<>();
        List<Hospital> hospitalList=new ArrayList<>();
        for (int i = 0; i < 5; i++){
           Resident resident=new Resident(f.name().firstName());
           residentList.add(resident);
           Hospital hospital=new Hospital(" St. "+f.name().lastName(),i);
           hospitalList.add(hospital);
        }
        Problem problem2=new Problem();
        problem2.createMatching(residentList,hospitalList);
        System.out.println(problem2.toString());


        /**
         * Optional: -Verify if the matching produced by your algorithm is stable..
         * verific pe exempul din laborator si ar trebui sa afiseze false deoarece algoritmul nu urmareste preferintele
         * */
        System.out.println(problem1.isStable());

    }
}
