package com.example.bootcampdemo1;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CountryController {

    private CountryService countryService;
    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public Result<List<CountryDTO>> getAllCountries(){
        return countryService.getAllCountries();
    }
    @GetMapping("/countries/{id}")
    public Result<CountryDTO> getCountryById(@PathVariable int id){
        return countryService.getCountryById(id);
    }
    @PostMapping("/countries")
    public Result<CountryDTO> addCountry(CountryDTO countryDTO){
        return countryService.addCountry(countryDTO);
    }
    @PutMapping("/countries/president/{id}")
    public Result<CountryDTO> changePresident(@PathVariable int id, @RequestBody String president) {
        return countryService.changePresident(id, president);
    }
}
