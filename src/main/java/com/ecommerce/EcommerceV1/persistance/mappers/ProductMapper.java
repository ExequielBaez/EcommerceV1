package com.ecommerce.EcommerceV1.persistance.mappers;

import com.ecommerce.EcommerceV1.controller.dto.ProductDTO;
import com.ecommerce.EcommerceV1.persistance.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings(
            {
                    @Mapping(source = "idProduct", target = "idProduct"),
                    @Mapping(source = "nameProduct", target = "nameProduct"),
                    @Mapping(source = "code", target = "code"),
                    @Mapping(source = "description", target = "description"),
                    @Mapping(source = "price", target = "price"),
                    @Mapping(source = "urlImage", target = "urlImage"),
                    @Mapping(source = "userEntity.idUser", target = "idUser"),
                    @Mapping(source = "categoryEntity.idCategory", target = "idCategory")
            }
    )

    ProductDTO toProductDto(ProductEntity productEntity);
    List<ProductDTO> toProductDTOList(List<ProductEntity> productEntityIterable);

}
