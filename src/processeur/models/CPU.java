package processeur.models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class CPU {
    public static final double UNKNOWN_MIPS = -1;
    private final String nom;
    private int annee;
    private long transistors;
    private double mips;

    public CPU(String nom, int annee, long transistors, double mips) {
        this.nom = nom;
        this.annee = annee;
        this.transistors = transistors;
        this.mips = mips;
    }

    public CPU(String nom, long transistors) {
        this.nom = nom;
        this.transistors = transistors;
    }

    public String toString() {
        String retour = "";
        DecimalFormat formatage = new DecimalFormat("#,###");
        DecimalFormat formatageMips = new DecimalFormat("#,##0.00");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        DecimalFormatSymbols point = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('\'');
        point.setDecimalSeparator('.');
        point.setGroupingSeparator('\'');
        formatage.setDecimalFormatSymbols(symbols);
        formatageMips.setDecimalFormatSymbols(point);
        if (getMips() == UNKNOWN_MIPS) {
            retour = "En " + annee + " le CPU " + nom + " avec " + formatage.format(transistors) + " transitors et une puissance de calcul incronnue.";
        } else {
            retour = "En " + annee + " le CPU " + nom + " avec " + formatage.format(transistors) + " transitors et une puissance de calcul de " + formatageMips.format(mips) + " mips.";
        }
        return retour;
    }

    public int getAnnee() {
        return annee;
    }

    public double getMips() {
        return mips;
    }

    public String getNom() {
        return nom;
    }

    public long getTransistors() {
        return transistors;
    }
}
