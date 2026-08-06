package pl.kacperkrupa.repair_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kacperkrupa.repair_service.model.Customer;
import pl.kacperkrupa.repair_service.repository.CustomerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
