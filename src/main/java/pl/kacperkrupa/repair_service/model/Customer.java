package pl.kacperkrupa.repair_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Imię nie może być puste")
    @Size(min = 2, max = 50, message = "Imię musi mieć od 2 do 50 znaków")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Nazwisko nie może być puste")
    @Size(min = 2, max = 50, message = "Nazwisko musi mieć od 2 do 50 znaków")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Email jest wymagany")
    @Email(message = "Niepoprawny format adresu email")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Numer telefonu jest wymagany")
    @Pattern(regexp = "^\\d{9}$", message = "Numer telefonu musi składać się z 9 cyfr")
    @Column(name = "phone_number")
    private String phoneNumber;
}