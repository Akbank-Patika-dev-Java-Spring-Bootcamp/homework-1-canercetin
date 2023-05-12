package com.example.bootcampdemo1;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CountryDao {
    List<Country> countriesDbTable = new ArrayList<>();
    {
        countriesDbTable.add(new Country(0,"Angola","João Lourenço"));
        countriesDbTable.add(new Country(1,"Papua New Guinea", "James Marape"));
        countriesDbTable.add(new Country(2, "Mozambique", "Filipe Nyusi"));
    }
    public List<CountryDTO> getAllCountries(){
        List<CountryDTO> allCountryDTOs = CountryMapper.INSTANCE.countriesToCountryDtos(countriesDbTable);
        return allCountryDTOs;
    }
    public CountryDTO getCountryById(int id){
        Country choosenCountry = countriesDbTable.get(id);
        CountryDTO choosenCountryDTO = CountryMapper.INSTANCE.countryToCountryDto(choosenCountry);
        return choosenCountryDTO;
    }
    public CountryDTO addCountry(CountryDTO countryDTO){
        Country newCountry = CountryMapper.INSTANCE.countryDtoToCountry(countryDTO);
        countriesDbTable.add(newCountry);
        return countryDTO;
    }
    public CountryDTO changePresidentName(int id, String presidentName) {
        Country chosenCountry = countriesDbTable.get(id);
        chosenCountry.setPresidentName(presidentName);
        CountryDTO chosenCountryDTO = CountryMapper.INSTANCE.countryToCountryDto(chosenCountry);
        return chosenCountryDTO;
    }
}
