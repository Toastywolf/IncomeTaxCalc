package code.toastywolf.incometaxcalc;

public class TaxInformation {
    public static int FILING_SINGLE = 0;
    public static int FILING_JOINTLY = 1;
    public static int FILING_HEAD_OF_HOUSEHOLD = 2;
    public static int FILING_SEPERATELY = 3;

    public double income;
    public int filing_as;

    public TaxInformation(double income, int filing_as) {
        this.income = income;
        this.filing_as = filing_as;
    }

    public double getIncome(){
        return income;
    }
}
