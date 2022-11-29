package org.globaltrainings.springjpademo.service;


import org.globaltrainings.springjpademo.entity.Product;
import org.globaltrainings.springjpademo.exceptions.InvalidArgumentException;
import org.globaltrainings.springjpademo.exceptions.ProductNotFoundException;

public interface IProductService {

    Product addProduct(String name, double price) throws InvalidArgumentException;

    Product findById(int id) throws InvalidArgumentException, ProductNotFoundException;

    Product changePrice(int id, double newPrice) throws InvalidArgumentException,  ProductNotFoundException;


}
