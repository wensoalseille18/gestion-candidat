package projet_intra_s2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Candidat {

    private String code, nomComplet = null, sexe = null;
    static ArrayList<String> listCand = new ArrayList<>();
    ArrayList<Candidat> list = new ArrayList<>();
    static ArrayList<String> laureatcinq = new ArrayList<>();
    static ArrayList<String> linss = new ArrayList<>();
    Scanner stri = new Scanner(System.in);
    Scanner ent = new Scanner(System.in);

    public Candidat() {
    }

    public Candidat(String code, String nomComplet, String sexe) {
        this.code = code;
        this.nomComplet = nomComplet;
        this.sexe = sexe;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    void enregistreCandidat() {
        System.out.println("Entrer ton Nom Complet");
        nomComplet = stri.nextLine();
        while (nomComplet == null || nomComplet.trim().isEmpty()) {
            System.out.println("Veuillez entrer votre Nom Complet");
            nomComplet = stri.nextLine();
        }
        System.out.println("Entrer votre Sexe");
        sexe = stri.nextLine();
        while (sexe == null || sexe.trim().isEmpty()) {
            System.out.println("Veuillez entrer votre Sexe: ");
            sexe = stri.nextLine();
        }
        Random r = new Random();
        code = nomComplet.substring(0, 1) + r.nextInt(1000) + sexe.substring(0, 1);
    }

    void affichTouDom() {
        File fic = new File("FichCandidatPro.txt");
        File ficRes = new File("FichCandidatRes.txt");
        File fichBD = new File("FichCandidatBD.txt");
        try {
            Scanner p = new Scanner(fic);
            Scanner r = new Scanner(ficRes);
            Scanner b = new Scanner(fichBD);
            while (p.hasNextLine()) {
                String affi[] = p.nextLine().split("~~");
                String code = affi[(affi.length - 1) - 7];
                String nomcomplet = affi[(affi.length - 1) - 6];
                String sexe = affi[(affi.length - 1) - 5];
                String question1 = affi[(affi.length - 1) - 4];
                String question2 = affi[(affi.length - 1) - 3];
                String question3 = affi[(affi.length - 1) - 2];
                String question4 = affi[(affi.length - 1) - 1];
                String moyenne = affi[(affi.length - 1) - 0];
                System.out.println("Code        : " + code + "\nNom Complet : " + nomcomplet + "\nSexe        : " + sexe + "\nMini Projet : " + question1 + "\nQuestion #1 : " + question2 + "\nQuestion #2 : " + question3 + "\nQuestion #3 : " + question4 + "\nMoyenne     : " + moyenne + "\n");
            }
            while (r.hasNextLine()) {
                String affi[] = r.nextLine().split("~~");
                String code = affi[(affi.length - 1) - 8];
                String nomcomplet = affi[(affi.length - 1) - 7];
                String sexe = affi[(affi.length - 1) - 6];
                String minRes = affi[(affi.length - 1) - 5];
                String question1 = affi[(affi.length - 1) - 4];
                String question2 = affi[(affi.length - 1) - 3];
                String question3 = affi[(affi.length - 1) - 2];
                String question4 = affi[(affi.length - 1) - 1];
                String moyenne = affi[(affi.length - 1) - 0];
                System.out.println("Code        : " + code + "\nNom Complet : " + nomcomplet + "\nSexe        : " + sexe + "\nMini Projet : " + minRes + "\nQuestion #1 : " + question1 + "\nQuestion #2 : " + question2 + "\nQuestion #3 : " + question3 + "\nQuestion #4 : " + question4 + "\nMoyenne     : " + moyenne + "\n");
            }
            while (b.hasNextLine()) {
                String affi[] = b.nextLine().split("~~");
                String code = affi[(affi.length - 1) - 6];
                String nomcomplet = affi[(affi.length - 1) - 5];
                String sexe = affi[(affi.length - 1) - 4];
                String minPro = affi[(affi.length - 1) - 3];
                String question1 = affi[(affi.length - 1) - 2];
                String question2 = affi[(affi.length - 1) - 1];
                String moyenne = affi[(affi.length - 1) - 0];
                System.out.println("Code        : " + code + "\nNom Complet : " + nomcomplet + "\nSexe        : " + sexe + "\nMini Projet : " + minPro + "\nQuestion #1 : " + question1 + "\nQuestion #2 : " + question2 + "\nMoyenne     : " + moyenne + "\n");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Candidat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void affichSaisir() {
        int dom;
        int i = 1;
        dom = choix();
        switch (dom) {
            case 1: {

                System.out.println("Les candidats en Programmation sont : ");
                File fic = new File("FichCandidatPro.txt");
                try {

                    Scanner sc = new Scanner(fic);
                    while (sc.hasNextLine()) {
                        System.out.println("\tCandidat " + i);
                        String affi[] = sc.nextLine().split("~~");
                        String code = affi[(affi.length - 1) - 7];
                        String nomcomplet = affi[(affi.length - 1) - 6];
                        String sexe = affi[(affi.length - 1) - 5];
                        String question1 = affi[(affi.length - 1) - 4];
                        String question2 = affi[(affi.length - 1) - 3];
                        String question3 = affi[(affi.length - 1) - 2];
                        String question4 = affi[(affi.length - 1) - 1];
                        String moyenne = affi[(affi.length - 1) - 0];
                        System.out.println("Code        : " + code + "\nNom Complet : " + nomcomplet + "\nSexe        : " + sexe + "\nMini Projet : " + question1 + "\nQuestion #1 : " + question2 + "\nQuestion #2 : " + question3 + "\nQuestion #3 : " + question4 + "\nMoyenne     : " + moyenne + "\n");
                        i += 1;
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Candidat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 2: {
                System.out.println("Les candidats en Reseaux sont : ");
                File ficRes = new File("FichCandidatRes.txt");
                try {
                    Scanner sc = new Scanner(ficRes);
                    while (sc.hasNextLine()) {

                        String affi[] = sc.nextLine().split("~~");
                        String code = affi[(affi.length - 1) - 8];
                        String nomcomplet = affi[(affi.length - 1) - 7];
                        String sexe = affi[(affi.length - 1) - 6];
                        String minRes = affi[(affi.length - 1) - 5];
                        String question1 = affi[(affi.length - 1) - 4];
                        String question2 = affi[(affi.length - 1) - 3];
                        String question3 = affi[(affi.length - 1) - 2];
                        String question4 = affi[(affi.length - 1) - 1];
                        String moyenne = affi[(affi.length - 1) - 0];
                        System.out.println("Code        : " + code + "\nNom Complet : " + nomcomplet + "\nSexe        : " + sexe + "\nMini Projet : " + minRes + "\nQuestion #1 : " + question1 + "\nQuestion #2 : " + question2 + "\nQuestion #3 : " + question3 + "\nQuestion #4 : " + question4 + "\nMoyenne     : " + moyenne + "\n");
                        i += 1;
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Candidat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 3: {

                System.out.println("Les candidats en Base de donnees sont : ");
                File fic = new File("FichCandidatBD.txt");
                try {
                    Scanner sc = new Scanner(fic);
                    while (sc.hasNextLine()) {
                        String affi[] = sc.nextLine().split("~~");
                        String code = affi[(affi.length - 1) - 6];
                        String nomcomplet = affi[(affi.length - 1) - 5];
                        String sexe = affi[(affi.length - 1) - 4];
                        String minPro = affi[(affi.length - 1) - 3];
                        String question1 = affi[(affi.length - 1) - 2];
                        String question2 = affi[(affi.length - 1) - 1];
                        String moyenne = affi[(affi.length - 1) - 0];
                        System.out.println("Code        : " + code + "\nNom Complet : " + nomcomplet + "\nSexe        : " + sexe + "\nMini Projet : " + minPro + "\nQuestion #1 : " + question1 + "\nQuestion #2 : " + question2 + "\nMoyenne     : " + moyenne + "\n");
                        i += 1;
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Candidat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
        }
    }

    void laureat() {
        String aFfich = "";
        aFfich = laureatR("FichCandidatPro.txt");
        laureatcinq.add(aFfich);
        aFfich = laureatR("FichCandidatBD.txt");
        laureatcinq.add(aFfich);
        aFfich = laureatR("FichCandidatRes.txt");
        laureatcinq.add(aFfich);
        double moye = 0;
        double aMoye;

        for (String c : laureatcinq) {
            String[] tab = c.split("~~");
            for (int i = 0; i < tab.length; i++) {
                if (i == (tab.length - 1)) {
                    aMoye = Double.parseDouble(tab[i]);
                    if (moye < aMoye) {
                        moye = aMoye;
                    }
                }
            }
        }

        for (String af : laureatcinq) {
            String[] tabl = af.split("~~");
            for (int i = 0; i < tabl.length; i++) {
                if (i == (tabl.length - 1)) {
                    aMoye = Double.parseDouble(tabl[i]);
                    if (aMoye == moye) {
                        if (tabl.length == 8) {
                            String code = tabl[(tabl.length - 1) - 7];
                            String nomcomplet = tabl[(tabl.length - 1) - 6];
                            String sexe = tabl[(tabl.length - 1) - 5];
                            String question1 = tabl[(tabl.length - 1) - 4];
                            String question2 = tabl[(tabl.length - 1) - 3];
                            String question3 = tabl[(tabl.length - 1) - 2];
                            String question4 = tabl[(tabl.length - 1) - 1];
                            String moyenne = tabl[(tabl.length - 1) - 0];
                            System.out.println("Code        : " + code + "\nNom Complet : " + nomcomplet + "\nSexe        : " + sexe + "\nMini Projet : " + question1 + "\nQuestion #1 : " + question2 + "\nQuestion #2 : " + question3 + "\nQuestion #3 : " + question4 + "\nMoyenne     : " + moyenne + "\n");
                        }
                        if (tabl.length == 9) {
                            String code = tabl[(tabl.length - 1) - 8];
                            String nomcomplet = tabl[(tabl.length - 1) - 7];
                            String sexe = tabl[(tabl.length - 1) - 6];
                            String minRes = tabl[(tabl.length - 1) - 5];
                            String question1 = tabl[(tabl.length - 1) - 4];
                            String question2 = tabl[(tabl.length - 1) - 3];
                            String question3 = tabl[(tabl.length - 1) - 2];
                            String question4 = tabl[(tabl.length - 1) - 1];
                            String moyenne = tabl[(tabl.length - 1) - 0];
                            System.out.println("Code        : " + code + "\nNom Complet : " + nomcomplet + "\nSexe        : " + sexe + "\nMini Projet : " + minRes + "\nQuestion #1 : " + question1 + "\nQuestion #2 : " + question2 + "\nQuestion #3 : " + question3 + "\nQuestion #4 : " + question4 + "\nMoyenne     : " + moyenne + "\n");
                        }
                        if (tabl.length == 7) {
                            String code = tabl[(tabl.length - 1) - 6];
                            String nomcomplet = tabl[(tabl.length - 1) - 5];
                            String sexe = tabl[(tabl.length - 1) - 4];
                            String minPro = tabl[(tabl.length - 1) - 3];
                            String question1 = tabl[(tabl.length - 1) - 2];
                            String question2 = tabl[(tabl.length - 1) - 1];
                            String moyenne = tabl[(tabl.length - 1) - 0];
                            System.out.println("Code        : " + code + "\nNom Complet : " + nomcomplet + "\nSexe        : " + sexe + "\nMini Projet : " + minPro + "\nQuestion #1 : " + question1 + "\nQuestion #2 : " + question2 + "\nMoyenne     : " + moyenne + "\n");
                        }
                        System.out.println("\n");
                    }
                }
            }

        }
    }

    static String laureatR(String nom) {
        String aFfich = "";
        double moye = 0;
        //int posi=0;
        double aMoye;
        ArrayList<String> laureatR = new ArrayList<String>();
        try {
            File fic = new File(nom);
            Scanner sc = new Scanner(fic);
            String r;
            if (nom == "FichCandidatPro.txt") {
                aFfich = "0~~0~~0~~0~~0~~0~~0~~0.0";
            }
            if (nom == "FichCandidatRes.txt") {
                aFfich = "0~~0~~0~~0~~0~~0~~0~~0~~0.0";
            }
            if (nom == "FichCandidatBD.txt") {
                aFfich = "0~~0~~0~~0~~0~~0~~0.0";
            }
            while (sc.hasNextLine()) {
                r = sc.nextLine();
                String[] tab = r.split("~~");
                for (int i = 0; i < tab.length; i++) {
                    if (i == (tab.length - 1)) {
                        aMoye = Double.parseDouble(tab[i]);
                        if (moye < aMoye) {
                            moye = aMoye;
                        }
                    }
                }

                laureatR.add(r);
                listCand.add(r);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Candidat.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (String af : laureatR) {
            String[] tabl = af.split("~~");
            for (int i = 0; i < tabl.length; i++) {
                if (i == (tabl.length - 1)) {
                    aMoye = Double.parseDouble(tabl[i]);
                    if (aMoye == moye) {
                        aFfich = af;
                        break;
                    }
                }
            }

        }
        return aFfich;
    }

    ArrayList<String> fichArray() {
        String ficP = "FichCandidatPro.txt";
        String ficRes = "FichCandidatRes.txt";
        String fichBD = "FichCandidatBD.txt";
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader fi1;
        BufferedReader fi2;
        BufferedReader fi3;
        System.out.println();
        try {
            String li;
            fi1 = new BufferedReader(new FileReader(ficP));
            fi2 = new BufferedReader(new FileReader(fichBD));
            fi3 = new BufferedReader(new FileReader(ficRes));
            while ((li = fi1.readLine()) != null || (li = fi2.readLine()) != null || (li = fi3.readLine()) != null) {
                lines.add(li);
            }

        } catch (IOException ex) {
            Logger.getLogger(Candidat.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lines;
    }

    void supprimer4() {
        ArrayList<String> fiPZ = new ArrayList<>();
        ArrayList<String> fiPZbd = new ArrayList<>();
        ArrayList<String> fiPZre = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> lnss = new ArrayList<>();
        lines = fichArray();
        for (String b : lines) {
            String[] lns = b.split("~~");
            String aff = "";
            for (int i = 0; i < lns.length; i++) {
                aff += lns[(((lns.length) - 1) - i)] + "~~";
            }
            lnss.add(aff);
        }
        Collections.sort(lnss);
        int qt = 0;
        for (String as : lnss) {
            qt += 1;
            String[] lns = as.split("~~");
            for (int i = lns.length - 1; i > 0; i--) {
                linss.add(lns[lns.length - 1]);
                break;
            }
            if (qt == 4) {
                break;
            }
        }
        try {
            File file = new File("FichCandidatPro.txt");
            Scanner sca = new Scanner(file);
            while (sca.hasNextLine()) {
                fiPZ.add(sca.nextLine());
            }
        } catch (IOException ex) {
            Logger.getLogger(Candidat.class.getName()).log(Level.SEVERE, null, ex);
        }
        int o = -1;
        for (String ppA : linss) {
            for (String po : fiPZ) {
                String code[] = po.split("~~");
                if (ppA.equals(code[0])) {
                    o = fiPZ.indexOf(po);
                    break;
                }
            }
            if (o != -1) {
                fiPZ.remove(o);
                o = -1;
            }
        }
        System.out.println("Supprimer avec succes");
        File fichPP = new File("FichCandidatPro.txt");
        try {
            FileWriter wrt = new FileWriter(fichPP);
            wrt.close();
        } catch (IOException ex) {
            Logger.getLogger(Candidat.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (String p : fiPZ) {
            try {
                p += "\n";
                FileWriter wrt = new FileWriter(fichPP, true);
                wrt.write(p);
                wrt.close();
            } catch (IOException ex) {
                Logger.getLogger(Candidat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            File file = new File("FichCandidatRes.txt");
            Scanner sca = new Scanner(file);
            while (sca.hasNextLine()) {
                fiPZre.add(sca.nextLine());
            }
        } catch (IOException ex) {
            Logger.getLogger(Candidat.class.getName()).log(Level.SEVERE, null, ex);
        }
        o = -1;
        for (String ppA : linss) {
            for (String po : fiPZre) {
                String code[] = po.split("~~");
                if (ppA.equals(code[0])) {
                    o = fiPZre.indexOf(po);
                    break;
                }
            }
            if (o != -1) {
                fiPZre.remove(o);
                o = -1;
            }
        }
        File fichP = new File("FichCandidatRes.txt");
        try {
            FileWriter wrt = new FileWriter(fichP);
            wrt.close();
        } catch (IOException ex) {
            Logger.getLogger(Candidat.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (String p : fiPZre) {
            try {
                p += "\n";
                FileWriter wrt = new FileWriter(fichP, true);
                wrt.write(p);
                wrt.close();
            } catch (IOException ex) {
                Logger.getLogger(Candidat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            File file = new File("FichCandidatBD.txt");
            Scanner sca = new Scanner(file);
            while (sca.hasNextLine()) {
                fiPZbd.add(sca.nextLine());
            }
        } catch (IOException ex) {
            Logger.getLogger(Candidat.class.getName()).log(Level.SEVERE, null, ex);
        }
        o = -1;
        for (String ppA : linss) {
            for (String po : fiPZbd) {
                String code[] = po.split("~~");
                if (ppA.equals(code[0])) {
                    o = fiPZbd.indexOf(po);
                    break;
                }
            }
            if (o != -1) {
                fiPZbd.remove(o);
                o = -1;
            }
        }
        File fich = new File("FichCandidatBD.txt");
        try {
            FileWriter wrt = new FileWriter(fich);
            wrt.close();
        } catch (IOException ex) {
            Logger.getLogger(Candidat.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (String p : fiPZbd) {
            try {
                p += "\n";
                FileWriter wrt = new FileWriter(fich, true);
                wrt.write(p);
                wrt.close();
            } catch (IOException ex) {
                Logger.getLogger(Candidat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void laureat5() {
        ArrayList<String> lines = new ArrayList<>();
        lines = fichArray();
        ArrayList<String> lnss = new ArrayList<>();
        ArrayList<Double> linss = new ArrayList<>();
        for (String b : lines) {
            String[] lns = b.split("~~");
            String aff = "";
            for (int i = 0; i < lns.length; i++) {
                aff += lns[(((lns.length) - 1) - i)] + "~~";
            }
            lnss.add(aff);

        }
        Collections.sort(lnss);
        Collections.reverse(lnss);
        int qt = 0;
        for (String as : lnss) {
            qt += 1;
            String[] lns = as.split("~~");
            linss.add(Double.parseDouble(lns[0]));
            if (qt == 5) {
                break;
            }
        }
        Collections.sort(linss);
        Collections.reverse(linss);
        for (Double g : linss) {
            for (String b : lines) {
                String p[] = b.split("~~");
                if (g == Double.parseDouble(p[p.length - 1])) {
                    System.out.println(b);
                }
            }
        }
    }

    static int choix() {
        Scanner ent = new Scanner(System.in);
        int num = 0;
        boolean validInput = false;
        System.out.println("En Quel domaine vous voulez saisir un Candidat?");
        System.out.println("1.- En Programmation");
        System.out.println("2.- En Reseau");
        System.out.println("3.- En Base de Donnees");
        while (!validInput) {
            String input = ent.nextLine();
            boolean isNumber = true;
            for (int a = 0; a < input.length(); a++) {
                if (!Character.isDigit(input.charAt(a))) {
                    System.out.println("Vous avez entre un caractere. Vous devez faire un choix compris entre 1 et 3 ");
                    isNumber = false;
                    break;
                }
            }
            if (isNumber) {
                num = Integer.parseInt(input);
                if (num < 1 || num > 3) {
                    System.out.println("Erreur : Vous devez faire un choix compris entre 1 et 3 ");
                } else {
                    validInput = true;
                }
            }
        }
        return num;
    }
}
