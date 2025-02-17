package del1;

import del1.ParentesSjekker;

public class Oppgave6Main {
    public static void main(String[] args) {
        ParentesSjekker sjekker = new ParentesSjekker();

        String[] tester = { 
                "{ [ ( ) ] }", // Korrekt
                "{ [ ( ) }",   // Ikke korrekt
                "[ ( ) ] }",   // Ikke korrekt
                "{ [ ( ] ) }", // Ikke korrekt
                "class HelloWorld { public static void main(String[] args) { System.out.println(\"Hello World!\"); } }" // Korrekt
        };

        for (String test : tester) {
            try {
                System.out.println("Tester: " + test);
                System.out.println("Resultat: " + sjekker.sjekkParenteser(test));
            } catch (Exception e) {
                System.out.println("Feil oppstod: " + e.getMessage());
            }
            System.out.println("---------------------");
        }
    }
}


