package Graphical.User.Interface;
import Bussines.Logic.Operatii;
import Data.Models.Polinom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionController {
    private Interfata i;
    public ActionController(Interfata i)
    {
        this.i=i;
        i.setAddListener(new AddListener());
        i.setSubListener(new SubListener());
        i.setMulListener(new MullListener());
        i.setDivListener(new DivListener());
        i.setDerivListener(new DerivListener());
        i.setIntegListener(new IntegListener());
        i.setRestListener(new RestListener());
    }
    class AddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom p1= new Polinom(i.getP1());
            Polinom p2= new Polinom(i.getP2());
            Polinom rez= Operatii.adunare(p1,p2);
            i.setRezultat(rez.toString());
        }
    }
    class SubListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom p1= new Polinom(i.getP1());
            Polinom p2= new Polinom(i.getP2());
            Polinom rez= Operatii.scadere(p1,p2);
            i.setRezultat(rez.toString());
        }
    }
    class MullListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom p1= new Polinom(i.getP1());
            Polinom p2= new Polinom(i.getP2());
            Polinom rez= Operatii.inmultire(p1,p2);
            i.setRezultat(rez.toString());
        }
    }
    class DivListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom p1= new Polinom(i.getP1());
            Polinom p2= new Polinom(i.getP2());
            String rez= Operatii.impartire(p1,p2);
            i.setRezultat(rez);
        }
    }
    class DerivListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom p1= new Polinom(i.getP1());
            Polinom rez= Operatii.derivare(p1);
            i.setRezultat(rez.toString());
        }
    }

    class RestListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom p1= new Polinom(i.getP1());
            Polinom p2= new Polinom(i.getP2());
            String rez= Operatii.rest(p1,p2);
            i.setRezultat(rez);
        }
    }
    class IntegListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Polinom p1= new Polinom(i.getP1());
            String rez= Operatii.integrare(p1);
            i.setRezultat(rez);
        }
    }
}
