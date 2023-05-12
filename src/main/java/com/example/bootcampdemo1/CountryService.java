package com.example.bootcampdemo1;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private CountryDao countryDao;
    public CountryService(CountryDao countryDao){
        this.countryDao = countryDao;
    }
    public Result<List<CountryDTO>> getAllCountries(){

        List<CountryDTO> allCountryDTOs = countryDao.getAllCountries();
        return new Result<>("Ok", allCountryDTOs);
    }
    public Result<CountryDTO> getCountryById(int id){
        Result<CountryDTO> result = new Result<>();
        try{
            CountryDTO returningCountryDTO = countryDao.getCountryById(id);
            result.setMessage("Ok");
            result.setResult(returningCountryDTO);
        }catch(IndexOutOfBoundsException e){
            result.setMessage(e.getMessage());
        }
        return result;
    }
    public Result<CountryDTO> addCountry(CountryDTO countryDTO){
        if(countryDTO.id() >= 0 && !countryDTO.name().isEmpty() && !countryDTO.presidentName().isEmpty()){
            countryDao.addCountry(countryDTO);
            return new Result<CountryDTO>("New country added.", countryDTO);
        } else
            return new Result<CountryDTO>("Entered parameters are invalid.");
    }
    public Result<CountryDTO> changePresident(int id, String presidentName) {

        Result<CountryDTO> result = new Result<>();

        if(presidentName.isEmpty()){
            result.setMessage("Entered predident name is empty.");
            return result;
        }
        try{
            countryDao.changePresidentName(id, presidentName);
            result.setMessage("President name changed.");
            CountryDTO choosenCountryDTO = countryDao.getCountryById(id);
            result.setResult(countryDao.getCountryById(id));

        }catch (IndexOutOfBoundsException e){
            result.setMessage(e.getMessage());
        }

        return result;
    }
}
