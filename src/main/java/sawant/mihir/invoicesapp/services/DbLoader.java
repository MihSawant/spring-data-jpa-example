package sawant.mihir.invoicesapp.services;

import org.springframework.stereotype.Component;
import sawant.mihir.invoicesapp.entities.Country;
import sawant.mihir.invoicesapp.entities.Invoice;
import sawant.mihir.invoicesapp.repositories.CountryRepository;
import sawant.mihir.invoicesapp.repositories.InvoiceRepository;

import javax.annotation.PostConstruct;

@Component
public class DbLoader {
    private final CountryRepository countryRepo;
    private final InvoiceRepository invoiceRepo;

    public DbLoader(CountryRepository countryRepo, InvoiceRepository invoiceRepo){
        this.countryRepo = countryRepo;
        this.invoiceRepo = invoiceRepo;
    }

    @PostConstruct
    public void loadData(){
        Country c1 = new Country();
        c1.setName("India");
        c1.setCode("IN");

        Country c2 = new Country();
        c2.setName("Brazil");
        c2.setCode("BR");

        countryRepo.save(c1);
        countryRepo.save(c2);

        Invoice c1Invoice = new Invoice();
        c1Invoice.setBlNumber("IN0012");
        c1Invoice.setAaptaCertificate(true);
        c1Invoice.setCountry(c1);

        invoiceRepo.save(c1Invoice);
    }
}
