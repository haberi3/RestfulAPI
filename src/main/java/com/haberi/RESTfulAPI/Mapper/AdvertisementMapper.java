package com.haberi.RESTfulAPI.Mapper;

import com.haberi.RESTfulAPI.DTO.AdvertisementDTO;
import com.haberi.RESTfulAPI.Entity.Advertisement;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mappolást végez az Advertisement entityn
 */
@Mapper(componentModel = "spring")
public interface AdvertisementMapper {

    AdvertisementMapper INSTANCE = Mappers.getMapper(AdvertisementMapper.class);

    Advertisement advertisementDtoToAdvertisement(AdvertisementDTO advertisementDTO);

    AdvertisementDTO advertisementToAdvertisementDto(Advertisement advertisement);
}
