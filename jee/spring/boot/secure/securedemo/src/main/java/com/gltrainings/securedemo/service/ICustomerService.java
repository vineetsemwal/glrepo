package com.gltrainings.securedemo.service;

import com.gltrainings.securedemo.dto.AddCustomer;
import com.gltrainings.securedemo.dto.CustomerDetails;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface ICustomerService {

    CustomerDetails register(@Valid AddCustomer requestData);
    CustomerDetails findByUserName(String username);

}
