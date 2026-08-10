package pl.kacperkrupa.repair_service.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kacperkrupa.repair_service.model.RepairOrder;
import pl.kacperkrupa.repair_service.model.RepairStatus;
import pl.kacperkrupa.repair_service.repository.RepairOrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RepairOrderService {
    private final RepairOrderRepository repairOrderRepository;

    public List<RepairOrder> getAllOrders() {
        return repairOrderRepository.findAll();
    }

    public RepairOrder createOrder(RepairOrder order) {
        if (order.getStatus() == null) {
            order.setStatus(RepairStatus.NEW);
        }
        return repairOrderRepository.save(order);
    }

    @Transactional
    public RepairOrder changeStatus(Long orderId, RepairStatus newStatus) {
        RepairOrder order = repairOrderRepository.findById(orderId).orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("Nie znaleziono zlecenia o ID: " + orderId));

        order.setStatus(newStatus);

        return order;
    }
}
