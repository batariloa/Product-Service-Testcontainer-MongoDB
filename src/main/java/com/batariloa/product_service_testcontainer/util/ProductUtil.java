package product_service.util;

import product_service.dto.ProductResponse;
import product_service.model.Product;

public class ProductUtil {


    public static ProductResponse mapToProductResponse(Product product){

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();

    }

}
