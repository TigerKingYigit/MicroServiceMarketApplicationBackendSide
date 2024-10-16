package com.example.SaleModule;

import com.example.SaleModule.Models.Product;
import com.example.SaleModule.Models.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ProductServiceClient {
    @Autowired
    private WebClient.Builder webClientBuilder;
    public List<Product> getProductList() {
        Flux<Product> products= webClientBuilder.build()
                .get()
                .uri("http://productservice:8082/communication/product")
                .retrieve()
                .bodyToFlux(Product.class);
        return products.collectList().block();
    }
    public Product getProductById(int productId) {
        Mono<Product> product = webClientBuilder.build()
                .get()
                .uri("http://productservice:8082/communication/getProductById/{productId}", productId)
                .retrieve()
                .bodyToMono(Product.class);

        return product.block();
    }
    public Product getProductByName(String productName){
        Mono<Product> product = webClientBuilder.build()
                .get()
                .uri("http://productservice:8082/communication/getProductByName/{productName}", productName)
                .retrieve()
                .bodyToMono(Product.class);

        return product.block();
    }
    public ProductCategory getCategoryById(int id) {
        Mono<ProductCategory> category = webClientBuilder.build()
                .get()
                .uri("http://productservice:8082/api/v4/getCategoryById/{id}", id)
                .retrieve()
                .bodyToMono(ProductCategory.class);
        return category.block();
    }
//    public List<Product> getProductListBySaleId(int saleId) {
//        Flux<Product> products= webClientBuilder.build()
//                .get()
//                .uri("http://localhost:8082/api/v4/getProductsBySaleId/{saleId}",saleId)
//                .retrieve()
//                .bodyToFlux(Product.class);
//        return products.collectList().block();
//    }

}
