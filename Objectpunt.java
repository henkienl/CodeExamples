/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kbsfinalwerkmap;

/**
 *
 * @author Henk-Jan de Groot
 */
public class Objectpunt implements Comparable {
    
    private int xas;
    private int yas;
    private int k;
    private double graadwaarde;
    
    public Objectpunt(){}
    public Objectpunt(int xas,int yas, int k){
        this.xas = xas;
        this.yas = yas;
        this.k = k;
    }

    /**
     * @return the xas
     */
    public int getXas() {
        return xas;
    }

    /**
     * @return the yas
     */
    public int getYas() {
        return yas;
    }

    /**
     * @return the graadwaarde
     */
    public double getGraadwaarde() {
        return graadwaarde;
    }

    /**
     * @param graadwaarde the graadwaarde to set
     */
    public void setGraadwaarde(double graadwaarde) {
        this.graadwaarde = graadwaarde;
    }
    
    
    @Override
    public String toString(){
        return "x:"+xas+", y:"+yas+" k:"+k+" en "+graadwaarde+" graden";
    }

    /**
     * @return the k
     */
    public int getK() {
        return k;
    }

    /**
     * @param k the k to set
     */
    public void setK(int k) {
        this.k = k;
    }
   
    // Zorg dat het sorteerbaar is op graadwaarde
    public int compareTo(Object o1) {
        if (this.graadwaarde == ((Objectpunt) o1).graadwaarde)
            return 0;
        else if ((this.graadwaarde) > ((Objectpunt) o1).graadwaarde)
            return 1;
        else
            return -1;
    }
    
}
