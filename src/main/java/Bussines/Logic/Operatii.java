package Bussines.Logic;

import Data.Models.Monom;
import Data.Models.Polinom;

import javax.management.modelmbean.ModelMBean;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


public class  Operatii {



    public static Polinom adunare(Polinom p1, Polinom p2)
    {
        Polinom suma= new Polinom();

        for(Map.Entry<Integer,Monom> entry: p1.getPolinom().entrySet())
        {
            Monom m=new Monom(entry.getValue().getCoeficient(), entry.getValue().getGrad());
            suma.addMonom(m);
        }

        for(Map.Entry<Integer,Monom> entry: p2.getPolinom().entrySet())
        {
            Monom m=new Monom(entry.getValue().getCoeficient(), entry.getValue().getGrad());
            if(suma.getPolinom().containsKey(entry.getKey()))
            {
                suma.getPolinom().get(entry.getKey()).addCoeficient(entry.getValue());
            }
            else
                suma.addMonom(m);
        }
        return suma;
    }


    public static Polinom scadere(Polinom p1, Polinom p2) {
        Polinom scadere= new Polinom();
        for(Map.Entry<Integer,Monom> entry: p1.getPolinom().entrySet())
        {
            Monom m=new Monom(entry.getValue().getCoeficient(), entry.getValue().getGrad());
            scadere.addMonom(m);
        }
        for(Map.Entry<Integer,Monom> entry: p2.getPolinom().entrySet())
        {
            Monom m=new Monom(entry.getValue().getCoeficient(), entry.getValue().getGrad());
            if(scadere.getPolinom().containsKey(entry.getKey()))
            {
                if(scadere.getPolinom().get(entry.getKey()).getCoeficient()-entry.getValue().getCoeficient()==0)
                {
                    scadere.getPolinom().remove(entry.getKey()); //scoate din map
                }
                else
                {
                    Monom aux=new Monom(scadere.getPolinom().get(entry.getKey()).getCoeficient()-entry.getValue().getCoeficient(), entry.getKey());
                    scadere.getPolinom().replace(entry.getKey(),aux); // daca nu se da replace si se pune rezultat
                }
            }
            else
            {
                scadere.addMonom(new Monom(0,entry.getKey()));
                scadere.getPolinom().get(entry.getKey()).subCoeficient(entry.getValue());
            }
        }
        return scadere;
    }

    public static Polinom derivare (Polinom p)
    {
        Polinom deriv=new Polinom();

        for(Map.Entry<Integer,Monom> entry: p.getPolinom().entrySet())
        {
            Monom m;
            if(entry.getKey()!=0) {
                m = new Monom(entry.getValue().getCoeficient() * entry.getValue().getGrad(), entry.getValue().getGrad() - 1);
                deriv.addMonom(m);
            }
        }
        return deriv;
    }

    public static String integrare(Polinom p1) // ca sa nu mai inlocuiesc in int
    {
        Map<Integer,Double> integrare =new HashMap<>();
        for(Map.Entry<Integer,Monom> entry: p1.getPolinom().entrySet())
        {
            Double coeficient = entry.getValue().getCoeficient().doubleValue();
            Double grad = entry.getValue().getGrad().doubleValue();
            integrare.put(entry.getValue().getGrad() + 1, coeficient / (grad + 1));
        }
        String s ="";
        for(Map.Entry<Integer,Double> entry: integrare.entrySet())
        {
            DecimalFormat df = new DecimalFormat("0.00");
            if(entry.getValue() >=0) s+="+";
            if(entry.getKey()>1)
                s+=df.format(entry.getValue()) + "*x^" + String.valueOf(entry.getKey());
            else
            if(entry.getKey()==1) {
                if(entry.getValue() ==1)
                    s+="x";
                else
                    s += df.format(entry.getValue()) + "*x";

            }
            else
                s+= df.format(entry.getValue());
        }
        return s;
    }
    public static Polinom inmultire (Polinom p1, Polinom p2)
    {
        Polinom inmultire = new Polinom();
        for(Map.Entry<Integer,Monom> entry: p1.getPolinom().entrySet())
        {
            Monom m1 = entry.getValue();
            for(Map.Entry<Integer,Monom>intrare: p2.getPolinom().entrySet()) {
                Monom m2 = intrare.getValue();
                Monom rez = new Monom(m2.getCoeficient() * m1.getCoeficient(), m2.getGrad() + m1.getGrad());
                if(inmultire.getPolinom().containsKey(rez.getGrad()))
                {
                    inmultire.getPolinom().get(rez.getGrad()).addCoeficient(rez);
                }
                else
                  inmultire.addMonom(rez);
            }
        }
        return inmultire;
    }

    public static String impartire (Polinom p1, Polinom p2) {
        String s ="";
        if(p2.getPolinom().isEmpty()) {
            return "Eroare";
        }
            Map<Integer, Double> impartire = new HashMap<>();
            Map<Integer, Double> restt = new HashMap<>();
            Integer gradRest = 0;
            for (Map.Entry<Integer, Monom> entry : p1.getPolinom().entrySet()) {
                if (entry.getKey() > gradRest) {
                    gradRest = entry.getKey();
                }
                restt.put(entry.getKey(), Double.valueOf(entry.getValue().getCoeficient()));
            }
            while (gradRest >= p2.gradMax() && !restt.isEmpty()) {
                impartire.put(gradRest - p2.getPolinom().get(p2.gradMax()).getGrad(),
                        (restt.get(gradRest) / p2.getPolinom().get(p2.gradMax()).getCoeficient()));
                Map<Integer, Double> aux = new HashMap<>();
                for (Map.Entry<Integer, Monom> entry : p2.getPolinom().entrySet()) {
                    aux.put(entry.getKey() + gradRest - p2.gradMax(), entry.getValue().getCoeficient() * restt.get(gradRest) / p2.getPolinom().get(p2.gradMax()).getCoeficient());
                }
                Map<Integer, Double> scadere = new HashMap<>();
                for (Map.Entry<Integer, Double> entry : restt.entrySet()) {
                    scadere.put(entry.getKey(), entry.getValue());
                }
                for (Map.Entry<Integer, Double> entry : aux.entrySet()) {
                    if (scadere.containsKey(entry.getKey())) {
                        if (scadere.get(entry.getKey()) - entry.getValue() == 0) {
                            scadere.remove(entry.getKey()); //scoate din map
                        } else {
                            scadere.replace(entry.getKey(), scadere.get(entry.getKey()) - entry.getValue()); // daca nu se da replace si se pune rezultat
                        }
                    } else {
                        scadere.put(entry.getKey(), -entry.getValue());
                    }
                }
                restt = scadere;
                gradRest = 0;
                for (Map.Entry<Integer, Double> entry : restt.entrySet()) {
                    if (entry.getKey() > gradRest) {
                        gradRest = entry.getKey();
                    }
                }
            }

            for (Map.Entry<Integer, Double> entry : impartire.entrySet()) {
                DecimalFormat df = new DecimalFormat("0.00");
                if (entry.getValue() >= 0) s += "+";
                if (entry.getKey() > 1)
                    s += df.format(entry.getValue()) + "*x^" + String.valueOf(entry.getKey());
                else if (entry.getKey() == 1)
                {
                    if(entry.getValue() ==1)
                        s+="x";
                    else
                        s += df.format(entry.getValue()) + "*x";
                }
                else
                    s += df.format(entry.getValue());
            }

        return s;
    }

    public static String rest (Polinom p1, Polinom p2) {
        Map<Integer,Double> impartire=new HashMap<>();
        Map<Integer,Double> restt =new HashMap<>();
        Integer gradRest=0;

        for (Map.Entry<Integer, Monom> entry : p1.getPolinom().entrySet()) {
            if(entry.getKey()>gradRest)
            {
                gradRest=entry.getKey();
            }
            restt.put(entry.getKey(),Double.valueOf(entry.getValue().getCoeficient()));
        }
        while (gradRest >= p2.gradMax() && !restt.isEmpty()) {
            impartire.put(gradRest- p2.getPolinom().get(p2.gradMax()).getGrad(),
                    (restt.get(gradRest) /p2.getPolinom().get(p2.gradMax()).getCoeficient()));
            Map<Integer,Double>aux=new HashMap<>();
            for (Map.Entry<Integer, Monom> entry : p2.getPolinom().entrySet()) {
                aux.put(entry.getKey()+gradRest-p2.gradMax(),entry.getValue().getCoeficient()*restt.get(gradRest)/p2.getPolinom().get(p2.gradMax()).getCoeficient());
            }
            Map<Integer,Double> scadere =new HashMap<>();
            for(Map.Entry<Integer,Double> entry: restt.entrySet())
            {
                scadere.put(entry.getKey(), entry.getValue());
            }
            for(Map.Entry<Integer,Double> entry: aux.entrySet())
            {
                if(scadere.containsKey(entry.getKey()))
                {
                    if(scadere.get(entry.getKey())-entry.getValue()==0) {
                        scadere.remove(entry.getKey()); //scoate din map
                    }
                    else {
                        scadere.replace(entry.getKey(),scadere.get(entry.getKey())-entry.getValue()); // daca nu se da replace si se pune rezultat
                    }
                }
                else
                {
                    scadere.put(entry.getKey(),-entry.getValue());
                }
            }
            restt=scadere;
            gradRest=0;
            for (Map.Entry<Integer, Double> entry : restt.entrySet()) {
                if(entry.getKey()>gradRest)
                {
                    gradRest=entry.getKey();
                }
            }
        }
        if(restt.isEmpty())
            return "0";
        String s ="";
        for(Map.Entry<Integer,Double> entry: restt.entrySet())
        {
            DecimalFormat df = new DecimalFormat("0.00");
            if(entry.getValue() >=0) s+="+";
            if(entry.getKey()>1)
                s+=df.format(entry.getValue()) + "*x^" + String.valueOf(entry.getKey());
            else

            if(entry.getKey()==1)
            {
                if(entry.getValue() ==1)
                    s += "x";
                else
                    s += df.format(entry.getValue()) + "*x";

            }
            else
                s+= df.format(entry.getValue());
        }
        return s;
    }
}
