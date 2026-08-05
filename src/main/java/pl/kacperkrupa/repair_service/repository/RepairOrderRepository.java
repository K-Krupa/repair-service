package pl.kacperkrupa.repair_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kacperkrupa.repair_service.model.RepairOrder;

@Repository
public interface RepairOrderRepository extends JpaRepository<RepairOrder, Long> {
}