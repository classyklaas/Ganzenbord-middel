package GanzenbordMiddel;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MainGanzenbordMiddel {

    public static void main(String[] args) {
        AtomicInteger winnerGeesePlate = new AtomicInteger();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hoi! Jullie gaan Ganzenbord spelen! Geef alsjeblieft aan met hoeveel personen jullie het spel willen spelen. ");
        int hoeveelheidPersonen = Integer.valueOf(scanner.nextLine());
        ArrayList<SpelersToevoegen> namen = new ArrayList<>();

        System.out.println("Vul nu alsjeblieft jullie " + hoeveelheidPersonen + " voornamen in. Druk op Enter na de laatste naam. ");


        while (namen.size() < hoeveelheidPersonen) {
            String naamVanSpeler = scanner.nextLine();
            namen.add(new SpelersToevoegen(naamVanSpeler, 0));
        }

        System.out.println("Jullie hebben een perfecte dag uitgekozen op Ganzenbord te spelen! Druk op (g) om de dobbelsteen te gooien. ");

        while (winnerGeesePlate.get() == 0) {
            namen.forEach(SpelersToevoegen -> {
                char gIngedrukt = scanner.next().charAt(0);
                    if (gIngedrukt == 'g') {

                    //SpelersToevoegen.getNaamVanSpeler();
                    SpelersToevoegen.updatePositieVanSpeler();
                    if (SpelersToevoegen.getPositieVanSpeler() == 23) {
                        winnerGeesePlate.getAndIncrement();
                        System.out.println(SpelersToevoegen.getNaamVanSpeler() + ", je zit nu in de gevangenis. Het spel is voorbij.");

                    }
                    if (SpelersToevoegen.getPositieVanSpeler() == 63) {
                        winnerGeesePlate.getAndIncrement();
                        System.out.println(SpelersToevoegen.getNaamVanSpeler() + ", je hebt gewonnen! Het spel is nu voorbij.");
                    }
                }
            });
        }
    }
}

