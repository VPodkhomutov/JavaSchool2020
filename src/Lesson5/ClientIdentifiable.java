package Lesson5;

public class ClientIdentifiable extends Client {
    private  String name;
    private  int idClient;

    public ClientIdentifiable(String name, int idClient) {
        this.name = name;
        this.idClient = idClient;
    }

    public ClientIdentifiable() {
    }

    @Override
    public String toString() {
        return "ClientIdentifiable{" +
                "name='" + name + '\'' +
                ", idClient=" + idClient +
                '}';
    }
}
