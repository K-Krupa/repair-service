package pl.kacperkrupa.repair_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kacperkrupa.repair_service.model.Device;
import pl.kacperkrupa.repair_service.repository.DeviceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }
}
