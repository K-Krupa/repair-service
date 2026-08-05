package pl.kacperkrupa.repair_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kacperkrupa.repair_service.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
}