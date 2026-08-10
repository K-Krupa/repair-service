package pl.kacperkrupa.repair_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "repair_orders")
@Getter
@Setter
@NoArgsConstructor

public class RepairOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Opis usterki nie może być pusty")
    @Size(max = 1000, message = "Opis może mieć maksymalnie 1000 znaków")
    @Column(nullable = false, length = 1000)
    private String description;

    @NotNull(message = "Status zlecenia jest wymagany")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RepairStatus status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @NotNull(message = "Cena naprawy jest wymagana")
    @PositiveOrZero(message = "Cena nie może być mniejsza niż 0")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;
}
