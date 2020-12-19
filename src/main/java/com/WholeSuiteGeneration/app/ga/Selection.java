package com.WholeSuiteGeneration.app.ga;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Random;

import com.WholeSuiteGeneration.app.ga.blocks.TestSuite;

public class Selection {
    
    static TestSuite tournamentSelection(ArrayList<TestSuite> candidates){
        ArrayList<TestSuite> c = new ArrayList<>(candidates);
        Collections.sort(c);
        return c.get(c.size() - 1);
    }

    static ArrayList<TestSuite> randomSelection(ArrayList<TestSuite> population, int size){
        ArrayList<TestSuite> ret = new ArrayList<>();
        Random rm = new Random(Calendar.getInstance().getTime().getTime());
        
        for (int i = 0; i < size; i++){
            ret.add(population.get(rm.nextInt(population.size())));
        }

        return ret;
    }

}
