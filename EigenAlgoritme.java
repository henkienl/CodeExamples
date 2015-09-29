package kbsfinalwerkmap;

import java.util.*;
import java.lang.Math.*;

/**
 *
 * @author Henk-Jan de Groot
 */
public class EigenAlgoritme {

    private KBSmagazijn magazijn;
    private ArrayList<Objectpunt> list;
    private double xMiddelpunt = 0;
    private double yMiddelpunt = 0;
    private int robot = 0;
    
    public EigenAlgoritme(KBSmagazijn kbsm, int robot){
        this.magazijn = kbsm;
        this.robot = robot;
    }

    public void BerekenEigen(ArrayList<Objectpunt> list) {
        // sla de lijst met te sorteren objecten lokaal op
        this.list = list;
        BerekenMiddelpunt();
        berekenGraad();
        sorteerGraad();         
    }

    // Uiteindelijk is gekozen voor statische middelpunten.
    public void BerekenMiddelpunt() {

        if(robot == 0){
            this.xMiddelpunt = 5.5;
            this.yMiddelpunt = 5.5;
            
        }
        if(robot == 1){
            this.xMiddelpunt = 15.5;
            this.yMiddelpunt = 5.5;
        }


    }

    // Bereken de graadwaarde van elk object en sla deze op bij het object
    public void berekenGraad() {
        double graadwaarde = 0;

        // Bereken de graadwaarde met behulp van tangens
        for (Objectpunt o : list) {
            graadwaarde = Math.toDegrees(Math.atan(
                    (double) (o.getXas() - xMiddelpunt)
                    / (double) (o.getYas() - yMiddelpunt)));
            
            // Wanneer 1 van de berekeningen of delen daarvan negatief uitvalt
            // Moet hier 360 of 180 graden bij opgeteld worden
            if (graadwaarde < 0) {
                if(((double) (o.getXas() - xMiddelpunt)) < 0){
                    graadwaarde += 360;
                }
                else{
                    graadwaarde += 180;
                }
            }
            else if(((double) (o.getYas() - yMiddelpunt)) < 0){
                graadwaarde += 180;
            }
            
            o.setGraadwaarde(graadwaarde);
            
        }
    }

    // Sorteer de lijst aan de hand van de graadwaarden van 0-360
    public void sorteerGraad() {
        Collections.sort(list);
        
        // Sla dit vervolgens op in de gesorteerde lijst van het magazijn
        // Elke robot heeft daar een aparte lijst
         if (robot == 0){
                magazijn.sortedListRobot0 = list;
            }
            else{        
                magazijn.sortedListRobot1 = list;
            }
        
    }

}
