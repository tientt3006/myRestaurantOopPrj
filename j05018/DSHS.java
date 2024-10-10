/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codejava.j05018;

/**
 *
 * @author ADMIN
 */
public class DSHS implements Comparable<DSHS>{
    private String id, name, xl;
    private int ID;
    private float d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, tb;
    public DSHS(int index, String name, float d1, float d2, float d3, float d4, float d5, float d6, float d7, float d8, float d9, float d10){
        if(index < 10){
            this.id = "HS0" + Integer.toString(index);
        }
        else {
            this.id = "HS" + Integer.toString(index);
        }
        this.ID = index;
        this.name = name;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.d4 = d4;
        this.d5 = d5;
        this.d6 = d6;
        this.d7 = d7;
        this.d8 = d8;
        this.d9 = d9;
        this.d10 = d10;
        this.tb = (d1*2+d2*2+d3+d4+d5+d6+d7+d8+d9+d10)/12;
    }
    public int compareTo(DSHS o){
        if(this.tb > o.tb) return -1;
        else if(this.tb == o.tb) {
            if(this.ID > o.ID) return -1;
            else return 1;
        }
        else return 1;
    }
    @Override 
    public String toString(){
        if(tb < 5) xl = "YEU";
        if(tb >= 5 && tb < 7) xl = "TB";
        if(tb >= 7 && tb < 8) xl = "KHA";
        if(tb >= 8 && tb < 9) xl = "GIOI";
        if(tb >= 9) xl = "XUAT SAC";
        //return id + " " + name + " " + date + " " + tongd;
        return id + " " + name + " " + String.format("%.1f",tb) + " " + xl;
    }
}
