package Data.Models;
import Data.Models.Monom;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {

    private Monom monom;
    private Map<Integer,Monom> polinom ;//cheia e puterea si valoarea e monomul

    public Polinom()
    {
        polinom=new HashMap<Integer,Monom>();

    }

    public Polinom(String s)
    {
        polinom=new HashMap<Integer,Monom>();
       // String exp ="2x^3+4x^2+5x-42";

        Pattern pattern = Pattern.compile("([+\\-]?)(\\d*)[\\*]?(x)?\\^?(\\d+)?");

        Matcher matcher = pattern.matcher(s);
        while(matcher.find())
        {

            Integer c= 0;
            if(matcher.group(1).equals("") && matcher.group(2).equals("") && matcher.group(4)==null && matcher.group(3)==null)
                continue;
            if(matcher.group(1).equals("+") || matcher.group(1).equals("")) //numarul e pozitiv
            {

                if(matcher.group(2).equals(""))
                {
                    c=1;
                }
                else
                    c=Integer.valueOf(matcher.group(2));
            }
            else {            //numarul e negativ
                if(matcher.group(2).equals(""))
                {
                    c=-1;
                }
                else
                    c=-Integer.valueOf(matcher.group(2));
            }
            Integer putere=0;

            if(matcher.group(3)!=null && matcher.group(3).equals("x")) //putere de la 1 in sus
            {
                if(matcher.group(4)==null)

                    putere=1;
                else
                    putere=Integer.valueOf(matcher.group(4));
            }
            else //puterea 0
            {
                putere=0;
            }

            if(c!=0)
                addMonom(new Monom(c,putere));

        }

    }
    public  Integer gradMax()
    {
        Integer max=0;
        for(Map.Entry<Integer,Monom> entry: polinom.entrySet())
        {
            if(max<entry.getKey())
                max=entry.getKey();

        }
        return max;
    }

    public void addMonom(Monom m)
    {
        polinom.put(m.getGrad(),m);
    }
    public Map<Integer, Monom> getPolinom() {
        return polinom;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polinom polinom1 = (Polinom) o;
        return Objects.equals(monom, polinom1.monom) && Objects.equals(polinom, polinom1.polinom);
    }

    @Override
    public String toString() {
        String s= "";
        if(polinom.isEmpty())
            return "0";
        for(Map.Entry<Integer,Monom> entry: polinom.entrySet())
        {
            if(entry.getValue().getCoeficient()>=0) s+="+";
            if(entry.getValue().getGrad()>1)
                s+=String.valueOf(entry.getValue().getCoeficient())+"*x^"+ String.valueOf(entry.getValue().getGrad());
            else
                if(entry.getValue().getGrad()==1) {
                    if(entry.getValue().getCoeficient()==1)
                        s+="x";
                    else
                     s += String.valueOf(entry.getValue().getCoeficient()) + "*x";
                }
                else
                     s+=String.valueOf(entry.getValue().getCoeficient());
        }
        return  s;
    }
}
