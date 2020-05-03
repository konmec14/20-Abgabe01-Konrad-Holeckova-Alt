package at.fhj.iit;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

    @DisplayName("Testing SimpleDrink implementation")
    public class SimpleDrinkTest {
        private Liquid water, cherryLiquer;
        private SimpleDrink s1,s2;
        /**
         * inits simpledrinks and respective liquid for EACH test
         */
        @BeforeEach
        void setup() {
            // SETUP PHASE
            water = new Liquid("Wasser", 0.5, 0);
            cherryLiquer= new Liquid("Cherry liquer", 0.1, 35);
            s1=new SimpleDrink("Cool water", water);
            s2= new SimpleDrink("Cherry shot", cherryLiquer);
        }

        @Test
        @DisplayName("Testing constructor simpledrink 1")
        public void testConstructorNonAlcoholic(){
            assertEquals(s1.getVolume(), 0.5);
            assertEquals(s1.getAlcoholPercent(), 0.0, 0.001);
            assertEquals(s1.isAlcoholic(), false);
        }
        @Test
        @DisplayName("Testing constructor simpledrink 2")
        public void testConstructorAlcoholic(){
            assertEquals(s2.getVolume(), 0.1);
            assertEquals(s2.getAlcoholPercent(), 35.0, 0.001);
            assertEquals(s2.isAlcoholic(), true);
        }
    }
