package com.zanclus.api;

import com.zanclus.data.access.CustomerDAO;
import com.zanclus.data.entities.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by dphillips on 11/14/15.
 */
@RestController
@RequestMapping("/v1/customer")
@Slf4j
public class CustomerEndpoints {
    @Autowired
    private CustomerDAO dao;

    @RequestMapping(value="/", method=GET)
    public List<Customer> findAll() {
        return StreamSupport.stream(dao.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @RequestMapping(value="/{id}", method=GET)
    public Customer findById(@PathVariable("id") Long id) {
        return dao.findOne(id);
    }
}
