package domain.pilha;

public class Car {

    public String owner;
    public boolean protocol;

    public Car(String owner, boolean protocol) {
        this.owner = owner;
        this.protocol = protocol;
    }

    public boolean isProtocol() {
        return protocol;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "owner='" + owner + '\'' +
                ", protocol=" + protocol +
                '}';
    }
}
