package decorator;

public class TomatoDecorator extends SandwichDecorator {
    public TomatoDecorator(Sandwich sandwich) {
        super(sandwich);
    }

    @Override
    public String make() {
        return sandwich.make() + " + Tomato";
    }
}
