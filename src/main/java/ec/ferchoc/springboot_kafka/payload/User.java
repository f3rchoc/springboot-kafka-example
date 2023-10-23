package ec.ferchoc.springboot_kafka.payload;

public record User(Integer id, String firstName, String lastName) {

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
