public class User {
    private String name;
    private String cpf;
    private Address address;

    public User(String name, String cpf, String state, String city, String street, int addressNumber, String complement) {
        this.name = name;
        this.cpf = cpf;
        this.address  = new Address(state, city, street, addressNumber, complement);
    }
}
