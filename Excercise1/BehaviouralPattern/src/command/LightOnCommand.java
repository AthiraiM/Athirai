package command;

// Concrete Command
public class LightOnCommand implements Command {
    private final Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.turnOn();
    }
}
