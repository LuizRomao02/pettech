package com.luizromao.fiap.pettech.pettech.controller;

import com.luizromao.fiap.pettech.pettech.dto.ProductDTO;
import com.luizromao.fiap.pettech.pettech.dto.form.ProductForm;
import com.luizromao.fiap.pettech.pettech.service.ProductService;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Collection<ProductDTO>> findAll() {
    return ResponseEntity.ok(productService.findAll());
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
    return ResponseEntity.ok(productService.findById(id));
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO product) {
    return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(productService.create(product));
  }

  @PutMapping(
      value = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductDTO> update(
      @PathVariable Long id, @RequestBody ProductForm productForm) {
    return ResponseEntity.ok(productService.update(id, productForm));
  }

  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    productService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
