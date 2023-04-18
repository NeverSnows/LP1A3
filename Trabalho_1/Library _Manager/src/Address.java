public class Address {
    private String state;
    private String city ;
    private String street;
    private int number;
    private String complement;

    public Address(String state, String city, String street, int number, String complement) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.number = number;
        this.complement = complement;
    }

    public String getAddress(){
        if(complement != null) {
            return state + " " + city + " " + street + " " + number + " " + complement;
        }
        return state + " " + city + " " + street + " " + number;
    }


}
