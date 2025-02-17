package del1;

	import org.junit.jupiter.api.Test;
	import static org.junit.jupiter.api.Assertions.*;


	class ParentesSjekkerTest {

	    private final ParentesSjekker sjekker = new ParentesSjekker();

	    @Test
	    void testKorrektParenteser() {
	        assertTrue(sjekker.sjekkParenteser("{ [ ( ) ] }"), "Skal være korrekt");
	        assertTrue(sjekker.sjekkParenteser("class HelloWorld { public static void main(String[] args) { System.out.println(\"Hello World!\"); } }"), "Skal være korrekt");
	    }

	    @Test
	    void testManglerSluttParentes() {
	        assertFalse(sjekker.sjekkParenteser("{ [ ( ) }"), "Mangler sluttparentes");
	    }

	    @Test
	    void testManglerStartParentes() {
	        assertFalse(sjekker.sjekkParenteser("[ ( ) ] }"), "Mangler startparentes");
	    }

	    @Test
	    void testFeilRekkefølge() {
	        assertFalse(sjekker.sjekkParenteser("{ [ ( ] ) }"), "Feil rekkefølge på parenteser");
	    }
	}


