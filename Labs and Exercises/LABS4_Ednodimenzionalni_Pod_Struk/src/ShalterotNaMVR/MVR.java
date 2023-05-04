package ShalterotNaMVR;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class MVR {

    public static int presmetaj(Gragjanin gragjanin) {

        int brojac = 1;

        if (gragjanin.getlKarta() == 1)
            brojac += 3;
        else if (gragjanin.getPasosh() == 1)
            brojac += 2;
        else if (gragjanin.getVozacka() == 1)
            brojac++;

        return brojac;

    }

    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);
        int N = Integer.parseInt(br.nextLine());

        ArrayList<Gragjanin> lugje = new ArrayList<Gragjanin>();

        for (int i = 1; i <= N; i++) {
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime, lKarta, pasos, vozacka);
            lugje.add(covek);
        }

        for (int i = 0; i < N; i++) {
            if (i + 2 != N) {
                if (presmetaj(lugje.get(i)) >= presmetaj(lugje.get(i + 1))) {
                    System.out.println(lugje.get(i).getImePrezime());

                    if (presmetaj(lugje.get(i + 1)) == presmetaj(lugje.get(i + 2))) {
                        System.out.println(lugje.get(i + 1).getImePrezime());
                        System.out.println(lugje.get(i + 2).getImePrezime());
                    } else if (presmetaj(lugje.get(i + 1)) > presmetaj(lugje.get(i + 2)))
                        System.out.println(lugje.get(i + 1).getImePrezime());
                    else
                        System.out.println(lugje.get(i + 2).getImePrezime());

                }
            } else break;
        }
    }
}

class Gragjanin {

    private final String imePrezime;
    private final int lKarta;
    private final int pasosh;
    private final int vozacka;

    public Gragjanin(String imePrezime, int lKarta, int pasosh, int vozacka) {
        this.imePrezime = imePrezime;
        this.lKarta = lKarta;
        this.pasosh = pasosh;
        this.vozacka = vozacka;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public int getlKarta() {
        return lKarta;
    }

    public int getPasosh() {
        return pasosh;
    }

    public int getVozacka() {
        return vozacka;
    }
}
