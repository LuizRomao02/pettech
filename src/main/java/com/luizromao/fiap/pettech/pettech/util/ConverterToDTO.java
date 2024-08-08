package com.luizromao.fiap.pettech.pettech.util;

import com.luizromao.fiap.pettech.pettech.dto.ProductDTO;
import com.luizromao.fiap.pettech.pettech.entity.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConverterToDTO {

  private final ModelMapper modelMapper;

  public ProductDTO toDto(final Product model) {
    return modelMapper.map(model, ProductDTO.class);
  }
}
