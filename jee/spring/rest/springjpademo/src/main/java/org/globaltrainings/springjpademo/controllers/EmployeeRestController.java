package org.globaltrainings.springjpademo.controllers;

import org.globaltrainings.springjpademo.entity.Product;
import org.globaltrainings.springjpademo.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/products")
@RestController
public class EmployeeRestController {

    private IProductService service;

    public EmployeeRestController(IProductService service) {
        this.service = service;
    }


    //    /products/add
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add")
    public Product add(@RequestBody Product product) throws Exception {
        Product added = service.addProduct(product.getName(), product.getPrice());
        return added;
    }


    //     /products/byd/1
    // 200 ok
    @GetMapping("/byid/{id}")
    public Product fetchProductById(@PathVariable int id) throws Exception {
        Product product = service.findById(id);
        return product;
    }

    @GetMapping("/order/byprice")
    public List<Product> fetchAllByPrice() {
        List<Product> list = service.fetchProductsOrderByPrice();
        return list;
    }

    @PutMapping("/change/price")
    public Product changePrice(@RequestBody Product product) throws Exception {
        Product changed = service.changePrice(product.getId(), product.getPrice());
        return changed;
    }

}
