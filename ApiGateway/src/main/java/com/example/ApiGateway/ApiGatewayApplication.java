package com.example.ApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("product_get", r -> r
						.path("/communication/product")
						.uri("http://productservice:8082"))

				.route("get_category_by_id", r -> r
						.path("/api/v1/management/getCategoryById/{id}")
						.filters(f -> f
								.setRequestHeader("Bearer", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkIiwiaWF0IjoxNzExMTA1ODU1LCJleHAiOjE3MTExOTIyNTV9.z2rslbzKUiwby5QfyWASXM6m2Id8kmeADcEHE2cHzDc")
						)
						.uri("http://productservice:8082"))

				.route("product_add",p->p
						.path("/communication/add")
						.uri("http://productservice:8082"))

				.route("get_product_by_id",p->p
						.path("/communication/getProductById/{productId}")
						.uri("http://productservice:8082"))

				.route("get_product_by_with_pagination",p->p
						.path("/communication/getAllProductsWithPagination/{no}/{size}")
						.uri("http://productservice:8082"))

				.route("get_product_by_sorting",p->p
						.path("/communication/getAllProductsWithPagination/{no}/{size}")
						.uri("http://productservice:8082"))

				.route("get_product_by_sorting",p->p
						.path("/communication/softDeleteById/{id}")
						.uri("http://productservice:8082"))

				.route("get_product_list",p->p
						.path("/saleApi/getProductList")
						.uri("http://saleservice:8080"))

				.route("make_sale",s->s
						.path("/saleApi/sale")
						.uri("http://saleservice:8080"))
				//try from this point
				.route("get_sale_list",s->s
						.path("/saleApi/getSaleList") //back here
						.uri("http://saleservice:8080"))

				.route("soft_delete_sale",s->s
						.path("/softDeleteSaleById/{id}")
						.uri("http://saleservice:8080"))

				.route("get_all_offers_with_pagination",s->s
						.path("/getAllOffersWithPagination/{pageNumber}/{pageSize}")
						.uri("http://saleservice:8080"))

				.route("get_offer_list_by_first_letter",s->s
						.path("/getOfferListByFirstLetter/{letter}")
						.uri("http://saleservice:8080"))

				.build();
	}
}
