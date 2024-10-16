package com.example.ProductModule.Controller;
import com.example.ProductModule.DAO.CategoryDAO;
import com.example.ProductModule.Models.Product;
import com.example.ProductModule.Models.ProductCategory;
import com.example.ProductModule.Service.ProductService.IProductService;
import com.example.ProductModule.Service.ProductService.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/management")
//@PreAuthorize("hasRole('ADMIN')")
public class ProductController {
    private static final Logger logger = LogManager.getLogger(ProductController.class);
//    private final IProductService productService;
//    public ProductController(ProductService productService){
//        this.productService=productService;
//    }
    @Autowired
    ProductService productService;
    @Autowired
    private CategoryDAO categoryDAO;
    @RequestMapping("helloWorld")
    public String helloWorld(){
        return "Hello World";
    }
    @PostMapping("add")
    public void addProduct(@RequestBody Product product){
        productService.AddProduct(product);
        logger.info("Product is inserted to the database !");
    }
    @GetMapping("product")
    public List<Product> GetListProduct(){
        List<Product> productList =productService.GetListProduct();
        logger.info("All products are listed on the screen !");
        return productList;
    }
    @GetMapping("getProductById/{productId}")
    public Optional<Product> getProductById(@PathVariable int productId){
        logger.info("Selected product by is on the screen");
        return productService.getProductById(productId);
    }
    @GetMapping("getAllProductsWithPagination/{no}/{size}")
    public List<Product> getAllProductsWithPagination(@PathVariable int no,
                                                      @PathVariable int size){
        logger.info("All products are on the pages");
        return productService.getAllProductsWithPagination(no,size);
    }
    @GetMapping("getAllProductsBySorting/{field}")
    public List<Product> getAllProductsBySorting(@PathVariable String field){
        logger.info("All products are sorted");
        return productService.getAllProductsBySorting(field);
    }
    @GetMapping("category")
    public List<ProductCategory> GetListCategory(){
        List<ProductCategory> categoryList =categoryDAO.GetList();
        logger.info("All categories are on the screen");
        return categoryList;
    }
    @GetMapping("getProductsByFirstLetter/{firstLetter}")
    public List<Product> GetListProductsByLetter(@PathVariable char firstLetter)
    {
        logger.info("Product is brought by its first letter ");
        List<Product> products= productService.GetListByFirstLetter(firstLetter);
        return products;
    }
    @GetMapping("getProductByName/{productName}")
    public Product getProductByName(@PathVariable String productName){
        logger.info("Product is brought by its name ");
        return productService.getProductByName(productName);
    }
    @GetMapping("softDeleteById/{id}")
    public void softDeleteProductById(@PathVariable int id){
        logger.info("product is marked as deleted");
        productService.softDeleteProduct(id);
    }
} 
