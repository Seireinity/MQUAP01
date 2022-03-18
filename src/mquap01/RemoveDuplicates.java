/*
03/16/22 
 */
package mquap01;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 *
 * @author Janelle Achondo, Caryl Shainet Parro
 */
public class RemoveDuplicates extends ReadFile{

    private LinkedHashSet<String> linkedHashSet;
    private String[] arrWithoutDuplicates;
    private String[] stopwordsList;
    
    ReadFile f;
    
    
    public RemoveDuplicates() throws IOException{ //CONSTRUCTOR
        f = new ReadFile();
    }
    
    //------------------------------------ ENCAPSULATION FIELDS (GETTERS AND SETTERS)
    /**
     * @return the linkedHashSet
     */
    public LinkedHashSet<String> getLinkedHashSet() {
        return linkedHashSet;
    }

    /**
     * @param linkedHashSet the linkedHashSet to set
     */
    public void setLinkedHashSet(LinkedHashSet<String> linkedHashSet) {
        this.linkedHashSet = linkedHashSet;
    }

    /**
     * @return the arrWithoutDuplicates
     */
    public String[] getArrWithoutDuplicates() {
        return arrWithoutDuplicates;
    }

    /**
     * @param arrWithoutDuplicates the arrWithoutDuplicates to set
     */
    public void setArrWithoutDuplicates(String[] arrWithoutDuplicates) {
        this.arrWithoutDuplicates = arrWithoutDuplicates;
    }

    /**
     * @return the stopwordsList
     */
    public String[] getStopwordsList() {
        return stopwordsList;
    }

    /**
     * @param stopwordsList the stopwordsList to set
     */
    public void setStopwordsList(String[] stopwordsList) {
        this.stopwordsList = stopwordsList;
    }
    
    //------------------------------------ METHODS
    public void removeDuplicates(String[] stopwordsList){
        linkedHashSet = new LinkedHashSet<>( Arrays.asList(stopwordsList));
        arrWithoutDuplicates = linkedHashSet.toArray(new String[] {});
        //System.out.println(Arrays.toString(arrWithoutDuplicates));
    }
}
