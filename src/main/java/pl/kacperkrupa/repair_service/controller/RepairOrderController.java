package pl.kacperkrupa.repair_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.kacperkrupa.repair_service.model.RepairOrder;
import pl.kacperkrupa.repair_service.model.RepairStatus;
import pl.kacperkrupa.repair_service.service.RepairOrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Tag(name = "Zlecenia", description = "Zarządzanie bazą zleceń serwisu")

public class RepairOrderController {
    private final RepairOrderService repairOrderService;

    @Operation(summary = "Pobierz wszystkie zlecenia", description = "Zwraca pełną listę zleceń zapisanych w bazie")
    @GetMapping
    public List<RepairOrder> getAllOrders() {
        return repairOrderService.getAllOrders();
    }

    @Operation(summary = "Dodaj nowe zlecenie", description = "Tworzy nowe zlecenie w systemie")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RepairOrder createOrder(@Valid @RequestBody RepairOrder order) {
        return repairOrderService.createOrder(order);
    }

    @Operation(summary = "Aktualizuj status zlecenia", description = "Aktualizuje status zlecenia w systemie")
    @PatchMapping("/{id}/status")
    public RepairOrder changeStatus(@PathVariable Long id, @RequestParam RepairStatus status) {
        return repairOrderService.changeStatus(id, status);
    }
}
