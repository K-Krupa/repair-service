package pl.kacperkrupa.repair_service.service;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kacperkrupa.repair_service.model.RepairOrder;
import pl.kacperkrupa.repair_service.model.RepairStatus;
import pl.kacperkrupa.repair_service.repository.RepairOrderRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RepairOrderServiceTest {

    @Mock
    private RepairOrderRepository repairOrderRepository;

    @InjectMocks
    private RepairOrderService repairOrderService;

    @Test
    void shouldChangeStatusSuccessfully() {
        Long orderId = 1L;
        RepairOrder existingOrder = new RepairOrder();
        existingOrder.setId(orderId);
        existingOrder.setStatus(RepairStatus.NEW);

        when(repairOrderRepository.findById(orderId)).thenReturn(Optional.of(existingOrder));

        RepairOrder updatedOrder = repairOrderService.changeStatus(orderId, RepairStatus.IN_PROGRESS);

        assertNotNull(updatedOrder);
        assertEquals(RepairStatus.IN_PROGRESS, updatedOrder.getStatus());
        verify(repairOrderRepository, times(1)).findById(orderId);
    }

    @Test
    void shouldThrowExceptionWhenOrderNotFound() {
        Long nonExistingOrderId = 99L;

        when(repairOrderRepository.findById(nonExistingOrderId)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            repairOrderService.changeStatus(nonExistingOrderId, RepairStatus.IN_PROGRESS);
        });

        assertEquals("Nie znaleziono zlecenia o ID: " + nonExistingOrderId, exception.getMessage());

        verify(repairOrderRepository, times(1)).findById(nonExistingOrderId);
    }
}