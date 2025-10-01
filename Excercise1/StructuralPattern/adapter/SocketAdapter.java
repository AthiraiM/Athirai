package adapter;

public class SocketAdapter implements Socket {
    private final NewDevice device;

    public SocketAdapter(NewDevice device) {
        this.device = device;
    }

    @Override
    public void provideElectricity() {
        System.out.println("Converting 110V to 220V...");
        device.turnOn220V();
    }
}
