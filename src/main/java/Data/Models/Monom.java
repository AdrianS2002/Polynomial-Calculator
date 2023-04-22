package Data.Models;

import java.util.Objects;

public class Monom {
    private Integer coeficient;
    private Integer grad;

    public Monom (Integer coeficient, Integer grad)
    {
        this.coeficient=coeficient;
        this.grad=grad;

    }


    public void addCoeficient(Monom m) {this.coeficient+=m.getCoeficient();}

    public void subCoeficient(Monom m) {this.coeficient -= m.getCoeficient();}

    public Integer getCoeficient() {
        return coeficient;
    }

    public Integer getGrad() {return grad;}

    public void setGrad(Integer grad) {this.grad = grad;}

    @Override
    public String toString() {
        return "Monom{" +
                "coeficient=" + coeficient +
                ", grad=" + grad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monom monom = (Monom) o;
        return Objects.equals(coeficient, monom.coeficient) && Objects.equals(grad, monom.grad);
    }

}
