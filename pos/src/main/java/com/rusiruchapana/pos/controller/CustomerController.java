package com.rusiruchapana.pos.controller;

import com.rusiruchapana.pos.dto.CustomerDTO;
import com.rusiruchapana.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/text-1")
    public String getText(){
        return "Rusiru chapana";
    }

    @PostMapping("/save")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO customerDTO1 = customerService.addCustomer(customerDTO);

        return customerDTO1;
    }
}
