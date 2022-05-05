package actions;

public class Division implements Action{

    @Override
    public double invoke(double first, double second) {
        return first/second;
    }
}
