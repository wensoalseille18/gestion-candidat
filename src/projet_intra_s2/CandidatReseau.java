package projet_intra_s2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static projet_intra_s2.CandidatBaseD.minPBD;
import static projet_intra_s2.CandidatBaseD.quest23;
import static projet_intra_s2.CandidatProgrammation.qustion1;
import static projet_intra_s2.CandidatProgrammation.qustion2;

public class CandidatReseau extends Candidat {

    private int res, question1, question2, question3, question4;

    public CandidatReseau(int res, int question1, int question2, int question3, int question4, String code, String nomComplet, String sexe) {
        super(code, nomComplet, sexe);
        this.res = res;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.question4 = question4;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public int getQuestion1() {
        return question1;
    }

    public void setQuestion1(int question1) {
        this.question1 = question1;
    }

    public int getQuestion2() {
        return question2;
    }

    public void setQuestion2(int question2) {
        this.question2 = question2;
    }

    public int getQuestion3() {
        return question3;
    }

    public void setQuestion3(int question3) {
        this.question3 = question3;
    }

    public int getQuestion4() {
        return question4;
    }

    public void setQuestion4(int question4) {
        this.question4 = question4;
    }

    public CandidatReseau() {
    }

    void enrgistreR() throws IOException {
        double moy;
        String adFich;
        File fichR = new File("FichCandidatRes.txt");
        try {
            if (fichR.exists()) {
                System.out.println("");
            } else {
                fichR.createNewFile();
            }
        } catch (IOException ex) {
            Logger.getLogger(CandidatReseau.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.enregistreCandidat();
        System.out.println("Entrer la note obtenu pour le Reseau");
        res = quest23();
        System.out.println("Entrer la note pour la Question 1");
        question1 = qustion2();
        System.out.println("Entrer la note pour la Question 2");
        question2 = qustion1();
        System.out.println("Entrer la note pour la Question 3");
        question3 = quest23();
        System.out.println("Entrer la note pour la Question 4");
        question4 = minPBD();
        moy = (((double) (res + question1 + question2 + question3 + question4) / (250 + 150 + 200 + 250 + 300)) * 100);
        adFich = "" + super.getCode() + "~~" + super.getNomComplet() + "~~" + super.getSexe() + "~~" + res + "~~" + question1 + "~~" + question2 + "~~" + question3 + "~~" + question4 + "~~" + moy + "\n";
        FileWriter wrt = new FileWriter(fichR, true);
        wrt.write(adFich);
        wrt.close();
    }

}
