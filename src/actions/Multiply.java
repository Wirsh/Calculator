package actions;

public class Multiply implements Action{
    @Override
    public double invoke(double first, double second) {
        return first*second;
    }
}
