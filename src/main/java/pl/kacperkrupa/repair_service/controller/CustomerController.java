package pl.kacperkrupa.repair_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.kacperkrupa.repair_service.model.Customer;
import pl.kacperkrupa.repair_service.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Tag(name = "Klienci", description = "Zarządzanie bazą klientów serwisu")

public class CustomerController {
    private final CustomerService customerService;

    @Operation(summary = "Pobierz wszystkich klientów", description = "Zwraca pełną listę klientów zapisanych w bazie")
    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @Operation(summary = "Dodaj nowego klienta", description = "Tworzy nowego klienta w systemie")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@Valid @RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
}
