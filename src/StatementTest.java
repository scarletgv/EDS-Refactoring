import org.junit.Test;
import static org.junit.Assert.*;

class StatementTest {
    @Test
    public void testStatement() {
        Customer scarlet = new Customer("Scarlet");

        Movie interstellar  = new Movie("Interstellar", 0);
        Movie bacurau = new Movie("Bacurau", 1);
        Movie grave_of_the_fireflies = new Movie("Grave of the Fireflies", 2);

        Rental interstellar_rental = new Rental(interstellar, 1);
        Rental bacurau_rental = new Rental(bacurau, 2);
        Rental fireflies_rental = new Rental(grave_of_the_fireflies, 3);

        assertEquals(scarlet.statement()
                     , "Rental Record for Scarlet\n"
                     + "Amount owed is 0.0\n"
                     + "You earned 0 frequent renter points");

        scarlet.addRental(fireflies_rental);
        assertEquals(scarlet.statement()
                     , "Rental Record for Scarlet\n"
                     + "\tGrave of the Fireflies\t1.5\n"
                     + "Amount owed is 1.5\n"
                     + "You earned 1 frequent renter points");

        scarlet.addRental(insterstellar_rental);
        assertEquals(scarlet.statement()
                     , "Rental Record for Scarlet\n"
                     + "\tGrave of the Fireflies\t1.5\n"
                     + "\tInterstellar\t2.0\n"
                     + "Amount owed is 3.5\n"
                     + "You earned 2 frequent renter points");

        scarlet.addRental(bacurau_rental);
        assertEquals(scarlet.statement()
                     , "Rental Record for Scarlet\n"
                     + "\tGrave of the Fireflies\t1.5\n"
                     + "\tInterstellar\t2.0\n"
                     + "\tBacurau\t9.0\n"
                     + "Amount owed is 12.5\n"
                     + "You earned 4 frequent renter points");
    }   
}
