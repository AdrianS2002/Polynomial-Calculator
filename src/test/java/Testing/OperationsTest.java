package Testing;
import Bussines.Logic.Operatii;
import Data.Models.Monom;
import Data.Models.Polinom;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {

    @Test
    public void adunareTest(){
        Polinom p1,p2,rezultatObtinut,rezultatAsteptat;
        p1=new Polinom();
        p2=new Polinom();
        rezultatAsteptat=new Polinom();

        p1.addMonom(new Monom(-4,3));
        p1.addMonom(new Monom(2,2));
        p1.addMonom(new Monom(5,1));

        p2.addMonom(new Monom(2,2));
        p2.addMonom(new Monom(1,1));

        rezultatAsteptat.addMonom(new Monom(-4,3));
        rezultatAsteptat.addMonom(new Monom(4,2));
        rezultatAsteptat.addMonom(new Monom(6,1));
        rezultatObtinut= Operatii.adunare(p1,p2);
        assertEquals(rezultatAsteptat,rezultatObtinut);
    }

    @Test
    public void scadereTest(){
        Polinom p1,p2,rezultatObtinut,rezultatAsteptat;
        p1=new Polinom();
        p2=new Polinom();
        rezultatAsteptat=new Polinom();

        p1.addMonom(new Monom(-4,3));
        p1.addMonom(new Monom(2,2));
        p1.addMonom(new Monom(5,1));

        p2.addMonom(new Monom(2,2));
        p2.addMonom(new Monom(1,1));
        p2.addMonom(new Monom(1,3));

        rezultatAsteptat.addMonom(new Monom(-5,3));
        rezultatAsteptat.addMonom(new Monom(4,1));
        rezultatObtinut= Operatii.scadere(p1,p2);
        assertEquals(rezultatAsteptat,rezultatObtinut);
    }

    @Test
    public void inmultireTest(){
        Polinom p1,p2,rezultatObtinut,rezultatAsteptat;
        p1=new Polinom();
        p2=new Polinom();
        rezultatAsteptat=new Polinom();

        p1.addMonom(new Monom(-4,3));
        p1.addMonom(new Monom(2,2));
        p1.addMonom(new Monom(5,1));

        p2.addMonom(new Monom(2,2));
        p2.addMonom(new Monom(3,1));

        rezultatAsteptat.addMonom(new Monom(-8,5));
        rezultatAsteptat.addMonom(new Monom(-8,4));
        rezultatAsteptat.addMonom(new Monom(16,3));
        rezultatAsteptat.addMonom(new Monom(15,2));
        rezultatObtinut= Operatii.inmultire(p1,p2);
        assertEquals(rezultatAsteptat,rezultatObtinut);
    }
    @Test

    public void imparitreTest(){
        Polinom p1,p2;
        String rezultatObtinut,rezultatAsteptat;
        p1=new Polinom();
        p2=new Polinom();

        p1.addMonom(new Monom(1,2));
        p1.addMonom(new Monom(2,1));
        p1.addMonom(new Monom(1,0));

        p2.addMonom(new Monom(1,1));
        p2.addMonom(new Monom(1,0));
        rezultatObtinut= Operatii.impartire(p1,p2);
        rezultatAsteptat="+1,00+x";
        assertEquals(rezultatObtinut,rezultatAsteptat);
    }
    @Test
    public void restTest(){
        Polinom p1,p2;
        String rezultatObtinut,rezultatAsteptat;
        p1=new Polinom();
        p2=new Polinom();

        p1.addMonom(new Monom(1,5));
        p1.addMonom(new Monom(5,2));
        p1.addMonom(new Monom(5,0));

        p2.addMonom(new Monom(1,3));
        p2.addMonom(new Monom(1,2));
        p2.addMonom(new Monom(3,0));
        rezultatObtinut= Operatii.rest(p1,p2);
        rezultatAsteptat="+2,00+3,00*x+1,00*x^2";
        assertEquals(rezultatAsteptat,rezultatObtinut);
    }
    @Test
    public void derivareTest(){
        Polinom p1,rezultatObtinut,rezultatAsteptat;
        p1=new Polinom();
        rezultatAsteptat=new Polinom();

        p1.addMonom(new Monom(-4,3));
        p1.addMonom(new Monom(2,2));
        p1.addMonom(new Monom(5,1));

        rezultatAsteptat.addMonom(new Monom(-12,2));
        rezultatAsteptat.addMonom(new Monom(4,1));
        rezultatAsteptat.addMonom(new Monom(5,0));
        rezultatObtinut= Operatii.derivare(p1);
        assertEquals(rezultatAsteptat,rezultatObtinut);
    }
    @Test
    public void integrareTest(){
        Polinom p1,p2;
        String rezultatObtinut,rezultatAsteptat;
        p1=new Polinom();
        p1.addMonom(new Monom(1,5));
        p1.addMonom(new Monom(5,2));
        p1.addMonom(new Monom(5,0));

        rezultatObtinut= Operatii.integrare(p1);
        rezultatAsteptat="+5,00*x+1,67*x^3+0,17*x^6";
        assertEquals(rezultatAsteptat,rezultatObtinut);
    }


}
