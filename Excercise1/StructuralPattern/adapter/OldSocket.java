package adapter;

public class OldSocket implements Socket {
    @Override
    public void provideElectricity() {
        System.out.println("Providing 110V electricity");
    }
}
