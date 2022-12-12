package org.globaltrainings.saleapp.service;


import org.globaltrainings.saleapp.customerms.dto.BuyProductRequest;
import org.globaltrainings.saleapp.customerms.dto.CustomerDetails;
import org.globaltrainings.saleapp.customerms.dto.RegisterCustomer;
import org.globaltrainings.saleapp.customerms.exceptions.CustomerNotFoundException;
import org.globaltrainings.saleapp.productms.exceptions.ProductNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
public interface ICustomerService {

    CustomerDetails register(@Valid RegisterCustomer register);

    CustomerDetails findCustomerDetailsById(@Min(1)long customerId) throws CustomerNotFoundException;

    CustomerDetails buyProduct(@Valid BuyProductRequest butRequest) throws CustomerNotFoundException, ProductNotFoundException;

}
