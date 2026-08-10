package pl.kacperkrupa.repair_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "devices")
@Getter
@Setter
@NoArgsConstructor

public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Typ sprzętu jest wymagany")
    @Column(name = "device_type", nullable = false)
    private String deviceType;

    @NotBlank(message = "Marka sprzętu jest wymagana")
    @Column(nullable = false)
    private String brand;

    @NotBlank(message = "Model sprzętu jest wymagany")
    @Column(nullable = false)
    private String model;

    @NotBlank(message = "Numer seryjny sprzętu jest wymagany")
    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
