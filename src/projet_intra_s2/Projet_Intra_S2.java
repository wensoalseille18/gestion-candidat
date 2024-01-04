package projet_intra_s2;

import java.io.IOException;
import java.util.Scanner;
import static projet_intra_s2.Candidat.choix;

public class Projet_Intra_S2 {

    public static void main(String[] args) {
        int chx;
        String rep, re;
        Scanner stri = new Scanner(System.in);
        Scanner ent = new Scanner(System.in);
        CandidatBaseD objBD = new CandidatBaseD();
        CandidatReseau objR = new CandidatReseau();
        CandidatProgrammation objP = new CandidatProgrammation();
        Candidat obj = new Candidat();
        System.out.println("Bienvenu dans le Programme");
        do {
            chx = choix();
            try {
                switch (chx) {
                    case 1: {
                        objP.enrgistre();
                    }
                    break;
                    case 2: {
                        objR.enrgistreR();
                    }
                    break;
                    case 3: {
                        objBD.enrgistreBD();
                    }
                    break;
                }
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Projet_Intra_S2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            System.out.println("Voulez vous inserer d'autre Candidat?\n O ou o pour Oui n ou N pour Non");
            re = stri.nextLine();
        } while (re.equalsIgnoreCase("O"));
        do {
            System.out.println("1.- Pour afficher tous les candidats");
            System.out.println("2.- Pour afficher les 05 Laureats");
            System.out.println("3.- Pour un domaine precis");
            System.out.println("4.- Pour afficher le Laureat des Laureats");
            System.out.println("5.- Pour Supprimer les 04 derniers");
            int ch = ent.nextInt();
            switch (ch) {
                case 1: {
                    obj.affichTouDom();
                }
                break;
                case 2: {
                    obj.laureat5();
                }
                break;
                case 3: {
                    obj.affichSaisir();
                }
                break;
                case 4: {
                    obj.laureat();
                }
                break;
                case 5: {
                    obj.supprimer4();
                }
                break;
                default:
                    System.out.println("Vous avez fait un mauvais !");
                    break;
            }
            System.out.println("Si vous voulez continuer entrer O pour Oui N pour Non");
            rep = stri.nextLine();

        } while (rep.equalsIgnoreCase("O"));
        System.out.println("Merci de bien vouloir visiter notre programme");
    }
}
