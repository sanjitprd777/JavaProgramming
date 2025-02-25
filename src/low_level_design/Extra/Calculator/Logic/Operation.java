package Calculator.Logic;

public class Operation implements Value {

    Expression expression;
    Value left;
    Value right;

    public Operation(Expression expression, Value left, Value right) {
        this.expression = expression;
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        double ans;
        switch (expression) {
            case ADD -> ans = left.evaluate() + right.evaluate();
            case DIVIDE -> ans = left.evaluate() / right.evaluate();
            case MULTIPLY -> ans = left.evaluate() * right.evaluate();
            case SUBTRACT -> ans = left.evaluate() - right.evaluate();
            default -> throw new AssertionError("Invalid expression");
        }
        return ans;
    }
}
