package com.gltrainings.securedemo.util;

import com.gltrainings.securedemo.dto.CustomerDetails;
import com.gltrainings.securedemo.entity.Customer;
import com.gltrainings.securedemo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtil {

    public CustomerDetails customerDetails(Customer customer) {
        User user = customer.getUser();
        CustomerDetails desired = new CustomerDetails();
        desired.setCustomerId(customer.getId());
        desired.setRoles(user.getRoles());
        desired.setUsername(user.getUsername());
        return desired;
    }

}
