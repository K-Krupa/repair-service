package pl.kacperkrupa.repair_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.kacperkrupa.repair_service.model.Device;
import pl.kacperkrupa.repair_service.service.DeviceService;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor

public class DeviceController {
    private final DeviceService deviceService;

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Device addDevice(@RequestBody Device device) {
        return deviceService.addDevice(device);
    }

}
