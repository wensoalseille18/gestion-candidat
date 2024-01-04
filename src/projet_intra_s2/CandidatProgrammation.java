package projet_intra_s2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CandidatProgrammation extends Candidat {

    private int miniPr, question1, question2, question3;

    public CandidatProgrammation(int miniPr, int question1, int question2, int question3, String code, String nomComplet, String sexe) {
        super(code, nomComplet, sexe);
        this.miniPr = miniPr;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
    }

    public CandidatProgrammation() {
    }

    void enrgistre() throws IOException {
        double moy;
        File fichP = new File("FichCandidatPro.txt");
        try {
            if (fichP.exists()) {
                System.out.println("");
            } else {
                fichP.createNewFile();
            }
        } catch (IOException ex) {
            Logger.getLogger(CandidatProgrammation.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.enregistreCandidat();
        System.out.println("Entrer la note pour le mini Programme");
        miniPr = minProjet();
        System.out.println("Entrer la note pour la Question 1");
        question1 = qustion1();
        System.out.println("Entrer la note pour la Question 2");
        question2 = qustion2();
        System.out.println("Entrer la note pour la Question 3");
        question3 = qustion2();
        moy = (((double) (miniPr + question1 + question2 + question3) / (500 + 200 + 150 + 150)) * 100);
        String adFich = "" + super.getCode() + "~~" + super.getNomComplet() + "~~" + super.getSexe() + "~~" + miniPr + "~~" + question1 + "~~" + question2 + "~~" + question3 + "~~" + moy + "\n";
        FileWriter wrt = new FileWriter(fichP, true);
        wrt.write(adFich);
        wrt.close();
        CandidatProgrammation can = new CandidatProgrammation(miniPr, question1, question2, question3, super.getCode(), super.getNomComplet(), super.getSexe());
    }

    static int minProjet() {
        Scanner ent = new Scanner(System.in);
        int num = 0;
        boolean validInput = false;
        while (!validInput) {
            String input = ent.nextLine();
            boolean isNumber = true;
            for (int a = 0; a < input.length(); a++) {
                if (!Character.isDigit(input.charAt(a))) {
                    System.out.println("Vous avez entre un caractere. Vous devez entrer une note compris entre 0 et 500 ");
                    isNumber = false;
                    break;
                }
            }
            if (isNumber) {
                num = Integer.parseInt(input);
                if (num < 0 || num > 500) {
                    System.out.println("Erreur : Vous devez entrer une note compris entre 0 et 500 ");
                } else {
                    validInput = true;
                }
            }

        }
        return num;

    }

    static int qustion1() {
        Scanner ent = new Scanner(System.in);
        int num = 0;
        boolean validInput = false;
        while (!validInput) {
            String input = ent.nextLine();
            boolean isNumber = true;
            for (int a = 0; a < input.length(); a++) {
                if (!Character.isDigit(input.charAt(a))) {
                    System.out.println("Vous avez entre un caractere. Vous devez entrer une note compris entre 0 et 200 ");
                    isNumber = false;
                    break;
                }
            }
            if (isNumber) {
                num = Integer.parseInt(input);
                if (num < 0 || num > 200) {
                    System.out.println("Erreur : Vous devez entrer une note compris entre 0 et 200 ");
                } else {
                    validInput = true;
                }
            }

        }
        return num;

    }

    static int qustion2() {
        Scanner ent = new Scanner(System.in);
        int num = 0;
        boolean validInput = false;
        while (!validInput) {
            String input = ent.nextLine();
            boolean isNumber = true;
            for (int a = 0; a < input.length(); a++) {
                if (!Character.isDigit(input.charAt(a))) {
                    System.out.println("Vous avez entre un caractere. Vous devez entrer une note compris entre 0 et 150 ");
                    isNumber = false;
                    break;
                }
            }
            if (isNumber) {
                num = Integer.parseInt(input);
                if (num < 0 || num > 150) {
                    System.out.println("Erreur : Vous devez entrer une note compris entre 0 et 150 ");
                } else {
                    validInput = true;
                }
            }

        }
        return num;

    }
}
