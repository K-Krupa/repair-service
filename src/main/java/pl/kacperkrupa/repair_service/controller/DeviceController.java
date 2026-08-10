package pl.kacperkrupa.repair_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.kacperkrupa.repair_service.model.Device;
import pl.kacperkrupa.repair_service.service.DeviceService;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
@Tag(name = "Urządzenia", description = "Zarządzanie bazą urządzeń serwisu")

public class DeviceController {
    private final DeviceService deviceService;

    @Operation(summary = "Pobierz wszystkie urządzenia", description = "Zwraca pełną listę urządzeń zapisanych w bazie")
    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @Operation(summary = "Dodaj nowe urządzenie", description = "Tworzy nowe urządzenie w systemie")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Device addDevice(@Valid @RequestBody Device device) {
        return deviceService.addDevice(device);
    }

}
