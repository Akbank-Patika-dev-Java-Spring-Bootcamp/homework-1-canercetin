package com.example.bootcampdemo1;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);
    CountryDTO countryToCountryDto(Country country);
    Country countryDtoToCountry(CountryDTO countryDTO);
    List<CountryDTO> countriesToCountryDtos(List<Country> countries);

}
