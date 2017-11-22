package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public List<Customer> getAll() {
        List<Customer> list = new ArrayList<>();
        Iterable<Customer> customers = repository.findAll();

        customers.forEach(list::add);
        return list;
    }

    @RequestMapping(value = "/findall")
    public String findAll() {
        String result = "";
        for(Customer cust : repository.findAll()) {
            result += cust.toString() + "<br>";
        }
        return result;
    }

    @PostMapping(value = "/postcustomer")
    public Customer postCustomer(@RequestBody Customer customer) {
        customer = repository.save(new Customer(customer.getFirstName(), customer.getLastName()));
        return customer;
    }

    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName) {
        String result = "";

        for (Customer cust: repository.findByLastName(lastName)) {
            result += cust.toString() + "<br>";
        }
        return result;
    }


}
