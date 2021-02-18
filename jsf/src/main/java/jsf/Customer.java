package jsf;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Named
@SessionScoped
public class Customer implements Serializable {
    @NotBlank(message = "darf nicht leer sein")
    private String firstName;
    @Size(min = 2, max = 50, message = "muss zwischen 2 und 50 Zeichen haben")
    private String lastName;
    @Email(message = "keine valide Email")
    private String email;
    @Pattern(regexp = "\\d{5}", message = "muss 5 Ziffern haben")
    private String zipCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
