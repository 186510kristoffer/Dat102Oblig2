package del1;

public class Oppgave6Main {
    public static void main(String[] args) {
        ParentesSjekker sjekker = new ParentesSjekker();

        String[] tester = { "{ [ ( ) ] }", // Korrekt
                "{ [ ( ) }", // Ikke korrekt
                "[ ( ) ] }", // Ikke korrekt
                "{ [ ( ] ) }", // Ikke korrekt
                "class HelloWorld { public static void main(String[] args) { System.out.println("Hello World!"); } }" // Korrekt
        };

        for (String test : tester) {
            System.out.println("Tester: " + test);
            System.out.println("Resultat: " + sjekker.sjekkParenteser(test));
            System.out.println("---------------------");
        }
    }
}

