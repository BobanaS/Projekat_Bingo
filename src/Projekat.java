import java.util.Random;
import java.util.Scanner;

public class Projekat {
    public static void main(String[] args) {
        /* Postavljen zadatak tako da mi prvo upisujemo svoje brojeve potom dobijamo niz od 30 brojeva.
         */
        int[] mojniz = unesiSvoje();
        System.out.print("Vasi su ");
        stampajNiz(mojniz);
        System.out.print("Izvuceni su ");
        int[] niz = izgenerisi();
        stampajNiz(niz);

        izvlacenje(mojniz, niz);
    }

    //) izgenerisi() - ova metoda treba da izgenerise i vrati niz od 30 nasumicnih brojeva 0-50.
    //Uvedene dve petlje da bih dobila razlicitih 30 brojeva
    public static int[] izgenerisi() {
        int[] niz = new int[30];
        Random r = new Random();
        int broj;
        niz[0] = r.nextInt(0, 50);
        for (int i = 0; i < 30; i++) {
            broj = r.nextInt(0, 50);
            for (int j = 0; j < i; j++) {
                if (niz[j] == broj) {
                    i--;
                    break;
                } else {
                    niz[i] = broj;
                }
            }
        }
        return sortiranjeNiza(niz);
    }

    /*b) unesiSvoje() - unutar ove metode treba da unesete vasih 6 brojeva za pogadjanje(mozete da ih
    izgenerisete preko Random ili ubacite preko Scanner).
    */
    public static int[] unesiSvoje() {
        System.out.println("Unesite svojih 6 brojeva, u intervalu od 0 do 50.");
        Scanner skener = new Scanner(System.in);
        int[] niz = new int[6];
        for (int i = 0; i < niz.length; i++) {
            System.out.println("Unesite zeljene brojeve u svoj niz, tako sto cete nakon svakog unosa pritisnuti enter:");
            niz[i] = skener.nextInt();
            if (niz[i] > 50 || niz[i] < 0) {
                System.out.println("Broj mora biti izmedju 0 i 50. Probajte opet.");
                i--;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (niz[j] == niz[i]) {
                    System.out.println("Brojevi moraju biti razliciti. Probajte opet.");
                    i--;
                    continue;
                }

            }
        }
        return sortiranjeNiza(niz);
    }
    /* c) izvlacenje(int[] prviNiz, int[] drugiNiz) - unosite dva prethodno izgenerisana niz-a i ispisuje se poruka
    koliko je brojeva pogodjeno ukupno
    */
    //pomocu metode prebrojavanje odredjujemo broj pogodata
    public static int prebrojavanje(int[] prviNiz, int[] drugiNiz) {
        int brpogodaka = 0;
        for (int i = 0; i < prviNiz.length; i++) {
            for (int j = 0; j < drugiNiz.length; j++) {

                if (prviNiz[i] == drugiNiz[j]) {
                    brpogodaka++;
                }
            }
        }
        return brpogodaka;
    }

    public static void izvlacenje(int[] prviNiz, int[] drugiNiz) {
        int brpogodaka = prebrojavanje(prviNiz, drugiNiz);
        if (brpogodaka > 0 && brpogodaka < 6) {
            System.out.println("Uspesno ste pogodili broj " + brpogodaka + " puta.");
            int[] pogodjeni = new int[brpogodaka];
            int k = 0;
            System.out.print("I to su ");
            for (int i = 0; i < prviNiz.length; i++) {
                for (int j = 0; j < drugiNiz.length; j++) {
                    if (prviNiz[i] == drugiNiz[j]) {
                        //  for(int k=0; k<pogodjeni.length; k++){
                        pogodjeni[k] = prviNiz[i];
                        k++;
                    }
                }
            }
            stampajNiz(pogodjeni);
        } else if (brpogodaka == 6) {
            System.out.println("Bingo!Uspeli ste da pogodite svih 6 brojeva.");
        } else {
            System.out.println("Nazalost niste pogodili nijedan broj.");
        }
    }
    public static int[] sortiranjeNiza(int[] niz) {
        int sort = 0;
        int [] niz1=niz;
        for (int i = 0; i < niz.length; i++) {
            for (int j = 0; j < niz.length; j++) {
                if (niz[j] > niz[i]) {
                    sort = niz[i];
                    niz[i] = niz[j];
                    niz[j] = sort;

                }
            }
        }
        return niz1;
    }

    public static void stampajNiz(int[] niz) {
        System.out.println("sledeci brojevi:");
        for (int i = 0; i < niz.length; i++) {
            System.out.print(niz[i] + " ");
        }
        System.out.println();

    }
}