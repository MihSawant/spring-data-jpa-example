package sawant.mihir.invoicesapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sawant.mihir.invoicesapp.entities.Country;
import sawant.mihir.invoicesapp.entities.Invoice;
import sawant.mihir.invoicesapp.services.CountryService;
import sawant.mihir.invoicesapp.services.InvoiceService;

import java.util.List;

@RestController
public record CountryInvoiceController(InvoiceService invoiceService, CountryService countryService) {

    public CountryInvoiceController(InvoiceService invoiceService, CountryService countryService){
        this.countryService = countryService;
        this.invoiceService = invoiceService;
    }

    @GetMapping("/countries")
    public List<Country> allCountries(){
        return countryService.getAllCountries();
    }

    @GetMapping("/invoices/{countryCode}")
    public List<Invoice> allInvoicesViaCountryCode(@PathVariable Long countryCode){
        return invoiceService.getAllInvoicesByCountry(countryCode);
    }
}
