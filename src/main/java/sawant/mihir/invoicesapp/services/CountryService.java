package sawant.mihir.invoicesapp.services;

import org.springframework.stereotype.Service;
import sawant.mihir.invoicesapp.entities.Country;
import sawant.mihir.invoicesapp.repositories.CountryRepository;

import java.util.List;

@Service
public record CountryService(CountryRepository countryRepository) {
    public CountryService(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public Country getCountryByCode(String code){
        return countryRepository.findByCode(code);
    }
}
