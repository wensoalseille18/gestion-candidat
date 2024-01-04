 package projet_intra_s2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CandidatBaseD extends Candidat {

    private int bD, question1, question2;

    public CandidatBaseD(int bD, int question1, int question2, String code, String nomComplet, String sexe) {
        super(code, nomComplet, sexe);
        this.bD = bD;
        this.question1 = question1;
        this.question2 = question2;
    }

    public CandidatBaseD() {
    }

    void enrgistreBD() throws IOException {
        double moy;
        File fichBD = new File("FichCandidatBD.txt");
        try {
            if (fichBD.exists()) {
                System.out.println("");
            } else {
                fichBD.createNewFile();
            }
        } catch (IOException ex) {
            Logger.getLogger(CandidatBaseD.class.getName()).log(Level.SEVERE, null, ex);
        }
        String adFich;
        super.enregistreCandidat();

        System.out.println("Entrer la note obtenu pour la BD");
        bD = minPBD();
        System.out.println("Entrer la note pour la Question 1");
        question1 = quest23();
        System.out.println("Entrer la note pour la Question 2");
        question2 = quest23();
        moy = (((double) (bD + question1 + question2) / (300 + 250 + 250)) * 100);
        adFich = "" + super.getCode() + "~~" + super.getNomComplet() + "~~" + super.getSexe() + "~~" + bD + "~~" + question1 + "~~" + question2 + "~~" + moy + "\n";
        FileWriter wrt = new FileWriter(fichBD, true);
        wrt.write(adFich);
        wrt.close();
    }

    static int minPBD() {
        Scanner ent = new Scanner(System.in);
        int num = 0;
        boolean validInput = false;
        while (!validInput) {
            String input = ent.nextLine();
            boolean isNumber = true;
            for (int a = 0; a < input.length(); a++) {
                if (!Character.isDigit(input.charAt(a))) {
                    System.out.println("Vous avez entre un caractere. Vous devez entrer une note compris entre 0 et 300 ");
                    isNumber = false;
                    break;
                }

            }
            if (isNumber) {
                num = Integer.parseInt(input);
                if (num < 0 || num > 300) {
                    System.out.println("Erreur : Vous devez entrer une note compris entre 0 et 300 ");
                } else {
                    validInput = true;
                }
            }

        }
        return num;

    }

    static int quest23() {
        Scanner ent = new Scanner(System.in);
        int num = 0;
        boolean validInput = false;
        while (!validInput) {
            String input = ent.nextLine();
            boolean isNumber = true;
            for (int a = 0; a < input.length(); a++) {
                if (!Character.isDigit(input.charAt(a))) {
                    System.out.println("Vous avez entre un caractere. Vous devez entrer une note compris entre 0 et 250 ");
                    isNumber = false;
                    break;
                }
            }
            if (isNumber) {
                num = Integer.parseInt(input);
                if (num < 0 || num > 250) {
                    System.out.println("Erreur : Vous devez entrer une note compris entre 0 et 250 ");
                } else {
                    validInput = true;
                }
            }

        }
        return num;

    }

}
