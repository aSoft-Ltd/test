public record Person(
        String name,
        String email,
        Address address
) {
}

//data class Person(
//        val name: String,
//        val email: String
//)

//public class Person {
//    private String name;
//    private String email;
//
//    public Person(String name, String email) {
//        this.name = name;
//        this.email = email;
//    }
//
//    String getName() {
//        return this.name;
//    }
//
//    void setName(final String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Person[name=" + this.name + ",email=" + this.email + "]";
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//}