package demos.layeredarchitecturedemos.service;

import demos.layeredarchitecturedemos.dao.IProductDao;
import demos.layeredarchitecturedemos.dao.ProductDaoImpl;
import demos.layeredarchitecturedemos.entity.Product;
import demos.layeredarchitecturedemos.exceptions.InvalidArgumentException;
import demos.layeredarchitecturedemos.exceptions.ProductNotFoundException;

import java.util.Optional;

public class ProductServiceImpl implements IProductService {
    private IProductDao productDao = new ProductDaoImpl();

    private int generatedId;

    private int generateId() {
        return ++generatedId;
    }

    @Override
    public Product addProduct(String name, double price) throws InvalidArgumentException {
        name.toLowerCase().trim();
        validateStringNotBlank(name, "name can't empty");
        validateDoubleNotNegative(price, "price can bt smaller thnan zero");
        int newId = generateId();
        Product product = new Product();
        product.setId(newId);
        product.setName(name);
        product.setPrice(price);
        productDao.add(product);
        return product;
    }

    @Override
    public Product findById(int id) throws InvalidArgumentException, ProductNotFoundException {
        validateIntegerNOTotNegative(id, "id can't be smaller than zer");
        Optional<Product> optional = productDao.findById(id);
        if(optional.isEmpty()){
            throw new ProductNotFoundException("product not found for id="+id);
        }
        return optional.get();
    }

    @Override
    public Product changePrice(int id, double newPrice) throws InvalidArgumentException, ProductNotFoundException {
        validateIntegerNOTotNegative(id, "id can't be smaller than zer");
        validateDoubleNotNegative(newPrice,"newprice can't be negative");
        Product product=findById(id);
        product.setPrice(newPrice);
        return product;
    }

    void validateStringNotBlank(String input, String msg) throws InvalidArgumentException {
        if (input.isBlank()) {
            throw new InvalidArgumentException(msg);
        }
    }

    void validateDoubleNotNegative(double input, String msg) throws InvalidArgumentException {
        {
            if (input < 0) {
                throw new InvalidArgumentException(msg);
            }
        }
    }


    void validateIntegerNOTotNegative(int input, String msg) throws InvalidArgumentException {
        {
            if (input < 0) {
                throw new InvalidArgumentException(msg);
            }
        }
    }

}
