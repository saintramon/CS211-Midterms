/**
 * NAME: Jasmin, Ramon Emmiel P.
 * DATE: 10 October 2023
 */
import java.util.LinkedList;

public class Polynomial {
    private LinkedList<Term> terms;

    public Polynomial()throws Exception{
        terms = new LinkedList<Term>();
    }

    public void addTerm(Term newTerm) throws Exception{
        int ctr;
        boolean found = false;
        Term currTerm = null;

        for (ctr = 0; ctr < terms.size(); ctr++){
            currTerm = terms.get(ctr);
            if (currTerm.getDegree() <= newTerm.getDegree()){
                found = true;
                break;
            }
        }

        if (!found){
            terms.add(newTerm);
        }else {
            if (currTerm.getDegree() < newTerm.getDegree()){
                terms.add(ctr,newTerm);
            }else {
                currTerm.setCoefficient(currTerm.getCoefficient() + newTerm.getCoefficient());
                if (currTerm.getCoefficient() == 0){
                    terms.remove(ctr);
                }
            }
        }
    }


    public String toString() {
        String s = "";
        if (terms == null)
            return " ";
        for (int ctr = 0; ctr < terms.size(); ctr++) {
            Term currTerm = terms.get(ctr);

            if (currTerm.getCoefficient() > 0) {
                if (ctr != 0) {
                    s = s + " +";
                }
            } else {
                s = s + " -";
            }
            if (currTerm.getCoefficient() != 1 || currTerm.getDegree() == 0) {
                s = s+" "+ Math.abs(currTerm.getCoefficient());
            }
            switch (currTerm.getDegree()) {
                case 0 :
                    break;
                case 1 :
                    s = s + (terms.get(0)).getLiteral();
                    break;
                default :
                    s = s + (terms.get(0)).getLiteral() +"^" + currTerm.getDegree();
            }
        }
        return s;
    }

    public double evaluate(double value) throws Exception{
        double sum = 0;
        for (int ctr = 0; ctr < terms.size(); ctr++){
            Term currTerm = terms.get(ctr);
            sum += currTerm.getCoefficient() * Math.pow(value,currTerm.getDegree());
        }
        return sum;
    }

    public void setTerms(LinkedList<Term> terms) {
        this.terms = terms;
    }

    public LinkedList<Term> getTerms() {
        return terms;
    }

    public Polynomial multiply(Polynomial other) throws Exception{
        Polynomial result = new Polynomial();

        for (int ctr = 0; ctr < this.getTerms().size(); ctr++){
            Term curr1 = this.getTerms().get(ctr);
            for (int ctr2 = 0; ctr2 < other.getTerms().size(); ctr2++){
                Term  curr2= other.getTerms().get(ctr2);
                double pCoef = curr2.getCoefficient()*curr1.getCoefficient();
                int pDegree = curr2.getDegree() + curr1.getDegree();

                result.addTerm(new Term(pCoef,curr1.getLiteral(), pDegree));
            }
        }

        if (result.getTerms().size() == 0){
            result.addTerm(new Term(0,'x',0));
        }
        return result;
    }

    public Polynomial add(Polynomial otherPolynomial) throws Exception{
        Polynomial result = new Polynomial();
        LinkedList<Term> resultTerms = new LinkedList<>();

        for (int ctr = 0; ctr < this.getTerms().size(); ctr++){
            Term curr = this.getTerms().get(ctr);
            resultTerms.add(new Term(curr.getCoefficient(), curr.getLiteral(),curr.getDegree()));
        }

        result.setTerms(resultTerms);

        for (int ctr2 = 0; ctr2 < otherPolynomial.getTerms().size(); ctr2++){
            Term curr = otherPolynomial.getTerms().get(ctr2);
            Term sTerm = new Term(curr.getCoefficient(), curr.getLiteral(), curr.getDegree());
            result.addTerm(sTerm);
        }

        if (result.getTerms().size() == 0){
            result.addTerm(new Term(0,'x',0));
        }
        return result;
    }

    public Polynomial subtract(Polynomial otherPolynomial) throws Exception{
        Polynomial result = new Polynomial();
        LinkedList<Term> resultTerms = new LinkedList<>();

        for (int ctr = 0; ctr < this.getTerms().size(); ctr++){
            Term curr = this.getTerms().get(ctr);
            resultTerms.add(new Term(curr.getCoefficient(), curr.getLiteral(),curr.getDegree()));
        }

        result.setTerms(resultTerms);

        for (int ctr2 = 0; ctr2 < otherPolynomial.getTerms().size(); ctr2++){
            Term curr = otherPolynomial.getTerms().get(ctr2);
            Term sTerm = new Term(curr.getCoefficient() * -1, curr.getLiteral(), curr.getDegree());
            result.addTerm(sTerm);
        }

        if (result.getTerms().size() == 0){
            result.addTerm(new Term(0,'x',0));
        }

        return result;
    }

    public Qoutient divide(Polynomial divisor) throws Exception{
        Qoutient result = new Qoutient();
        Polynomial qoutient = new Polynomial();
        Polynomial remainder = new Polynomial();
        LinkedList<Term> dividend = new LinkedList<Term>();
        Term qTerm;
        Polynomial subtrahend = new Polynomial();

        for (int ctr = 0; ctr < this.getTerms().size(); ctr++) {
            Term currentTerm = this.getTerms().get(ctr);
            dividend.add(new Term(currentTerm.getCoefficient(), currentTerm.getLiteral(), currentTerm.getDegree()));
        }
        remainder.setTerms(dividend);
        while (((remainder != null)) && ((remainder.getTerms().get(0)).getDegree() >= (divisor.getTerms().get(0)).getDegree())) {
            Term numTerm = remainder.getTerms().get(0);
            Term divTerm = divisor.getTerms().get(0);
            qTerm = new Term (numTerm.getCoefficient()/divTerm.getCoefficient(), numTerm.getLiteral(),
                    numTerm.getDegree()-divTerm.getDegree());
            qoutient.addTerm(qTerm);
            LinkedList<Term> pQTerm = new LinkedList<Term>();
            pQTerm.add(qTerm);
            Polynomial multiplier = new Polynomial();
            multiplier.setTerms(pQTerm);
            subtrahend = multiplier.multiply(divisor);
            remainder = remainder.subtract(subtrahend);
        }

        if(qoutient.getTerms().size() == 0){
            qoutient.addTerm(new Term(0,'x',0));
        }

        result.setQuotientP(qoutient);

        if (remainder.getTerms().size() == 0){
            remainder.addTerm(new Term(0,'x',0));
        }

        result.setRemainderP(remainder);

        return result;
    }
}
