package org.globaltrainings.springjpademo.controllers;

import org.globaltrainings.springjpademo.dto.AddProduct;
import org.globaltrainings.springjpademo.dto.ChangePriceRequestDto;
import org.globaltrainings.springjpademo.dto.ProductDetails;
import org.globaltrainings.springjpademo.entity.Product;
import org.globaltrainings.springjpademo.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
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
    public ProductDetails add(@RequestBody @Valid AddProduct requestData) throws Exception {
        ProductDetails response = service.addProduct(requestData);
        return response;
    }


    //     /products/byd/1
    // 200 ok
    @GetMapping("/byid/{id}")
    public ProductDetails fetchProductById(@PathVariable @Min(1) int id) throws Exception {
        ProductDetails response = service.findProductDetailsById(id);
        return response;
    }

    @GetMapping("/order/byprice")
    public List<ProductDetails> fetchAllByPrice() {
        List<ProductDetails> response = service.fetchProductsOrderByPrice();
        return response;
    }

    @PutMapping("/change/price")
    public ProductDetails changePrice(@RequestBody @Valid ChangePriceRequestDto requestData) throws Exception {
        ProductDetails response = service.changePrice(requestData);
        return response;
    }


}
