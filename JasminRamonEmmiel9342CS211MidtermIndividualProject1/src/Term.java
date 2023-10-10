/**
 * NAME: Jasmin, Ramon Emmiel P.
 * DATE: 10 October 2023
 */
public class Term implements Comparable<Term>{
    private double  coefficient;
    private int degree;
    private char literal;

    public Term(){
        this.coefficient = 0;
        this.degree = 0;
        this.literal = 'x';
    }

    public Term(double coefficient, char literal, int degree){
        this.coefficient = coefficient;
        this.literal = literal;
        this.degree = degree;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setLiteral(char literal) {
        this.literal = literal;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public int getDegree() {
        return degree;
    }

    public char getLiteral() {
        return literal;
    }

    @Override
    public int compareTo(Term o) {
        if (this.getDegree() == o.getDegree()){
            return 0;
        }else if (this.getDegree() > o.getDegree()){
            return -1;
        }else {
            return 1;
        }
    }

    public String toString() {
        if (coefficient == 0 )
            return "";
        else
        if (coefficient==1 && degree == 1)
            return ""+literal;
        else
        if (coefficient==1 && degree != 1)
            return ""+literal+"^"+degree;
        else
            return (coefficient+literal+"^"+degree);

    }
}
