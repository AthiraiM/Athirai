package decorator;

public class CheeseDecorator extends SandwichDecorator {
    public CheeseDecorator(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String make() {
        return sandwich.make() + " + Cheese";
    }
}
