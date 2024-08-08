package com.luizromao.fiap.pettech.pettech.service;

import com.luizromao.fiap.pettech.pettech.dto.ProductDTO;
import com.luizromao.fiap.pettech.pettech.dto.form.ProductForm;
import com.luizromao.fiap.pettech.pettech.entity.Product;
import com.luizromao.fiap.pettech.pettech.infra.exception.ControllerNotFoundException;
import com.luizromao.fiap.pettech.pettech.repository.ProductRepository;
import com.luizromao.fiap.pettech.pettech.util.ConverterToDTO;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

  private final ProductRepository productRepository;
  private final ConverterToDTO converterToDTO;

  private Product save(Product product) {
    return productRepository.save(product);
  }

  public ProductDTO create(ProductDTO productDTO) {
    Product product =
        Product.builder()
            .name(productDTO.name())
            .price(productDTO.price())
            .description(productDTO.description())
            .urlImage(productDTO.urlImage())
            .build();

    return converterToDTO.toDto(save(product));
  }

  @Transactional(readOnly = true)
  public Collection<ProductDTO> findAll() {
    return productRepository.findAll().stream().map(converterToDTO::toDto).toList();
  }

  @Transactional(readOnly = true)
  public ProductDTO findById(Long id) {
    return converterToDTO.toDto(
        productRepository
            .findById(id)
            .orElseThrow(() -> new ControllerNotFoundException("Product not exists")));
  }

  public ProductDTO update(Long id, ProductForm product) {
    Product old =
        productRepository
            .findById(id)
            .orElseThrow(() -> new ControllerNotFoundException("Product not exists"));

    old.setName(product.name());
    old.setDescription(product.description());
    old.setPrice(product.price());
    old.setUrlImage(product.urlImage());

    return converterToDTO.toDto(save(old));
  }

  public void delete(Long id) {
    productRepository.deleteById(id);
  }
}
