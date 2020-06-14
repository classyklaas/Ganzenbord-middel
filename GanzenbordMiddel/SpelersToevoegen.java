package GanzenbordMiddel;

import java.util.Random;

public class SpelersToevoegen {

    public String naamVanSpeler;
    public int positieVanSpeler;


    public SpelersToevoegen(String naamVanSpeler, int positieVanSpeler) {
        this.naamVanSpeler = naamVanSpeler;
        this.positieVanSpeler = positieVanSpeler;
    }

    public String getNaamVanSpeler() {
        return naamVanSpeler;
    }

    public int updatePositieVanSpeler() {

        Random dobbelsteen = new Random();
        int nummer = 1 + dobbelsteen.nextInt(6);
        positieVanSpeler = nummer + positieVanSpeler;

        System.out.println(this.naamVanSpeler + ", je hebt " + nummer + " gegooid. Je staat nu dus op vakje " + positieVanSpeler + ".");
        if (positieVanSpeler == 23) {
            System.out.println(this.naamVanSpeler + ", je hebt verloren. Maar onthoud: het pad des acceptaties is een rustgevend pad. ");
        }
        if (positieVanSpeler == 63) {
            System.out.println(this.naamVanSpeler + ", je hebt gewonnen!");
        }

        if (positieVanSpeler == 25 || positieVanSpeler == 45) {
            System.out.println("Let wel: bij 25 en 45 moet je terug naar het startpunt. Je begint dus nu vanaf het begin.");
            positieVanSpeler = positieVanSpeler - positieVanSpeler;
        }
        if (positieVanSpeler % 10 == 0 && positieVanSpeler != 0) {
            positieVanSpeler = positieVanSpeler + nummer;
            System.out.println("Dat is een tiental. Je loopt nu het geworpen aantal nogmaals. Je staat nu dus op vakje nummer " + positieVanSpeler + ".");
        }
        if (positieVanSpeler > 63) {
            positieVanSpeler = 63 - (positieVanSpeler - 63);
            System.out.println("Echter: je mag niet hoger dan 63 gooien. Je moet nu het aantal teveel geworpen ogen terug vanaf vakje 63. Je staat nu dus op vakje " + positieVanSpeler + ".");
        }
        return positieVanSpeler;
    }

    public int getPositieVanSpeler() {
        return positieVanSpeler;
    }
}
