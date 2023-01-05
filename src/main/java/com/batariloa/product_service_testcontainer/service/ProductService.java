package product_service.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import product_service.dto.ProductRequest;
import product_service.dto.ProductResponse;
import product_service.model.Product;
import product_service.repository.ProductRepository;
import product_service.util.ProductUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    final ProductRepository productRepository;


    public void createProduct(ProductRequest productRequest){

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product is saved. ID: "+ product.getId());
    }


    public List<ProductResponse> getAllProducts() {

        List<Product> products = productRepository.findAll();

        return products.stream().map(ProductUtil::mapToProductResponse).toList();
    }
}
