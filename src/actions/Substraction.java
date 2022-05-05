package actions;

public class Substraction implements Action{
    @Override
    public double invoke(double first, double second) {

        return first-second;
    }
}
