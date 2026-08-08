package pl.kacperkrupa.repair_service.controller;

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

public class RepairOrderController {
    private final RepairOrderService repairOrderService;

    @GetMapping
    public List<RepairOrder> getAllOrders() {
        return repairOrderService.getAllOrders();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RepairOrder createOrder(@RequestBody RepairOrder order) {
        return repairOrderService.createOrder(order);
    }

    @PatchMapping("/{id}/status")
    public RepairOrder changeStatus(@PathVariable Long id, @RequestParam RepairStatus status) {
        return repairOrderService.changeStatus(id, status);
    }
}
