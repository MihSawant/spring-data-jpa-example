package sawant.mihir.invoicesapp.services;

import org.springframework.stereotype.Component;
import sawant.mihir.invoicesapp.entities.Country;
import sawant.mihir.invoicesapp.entities.Invoice;
import sawant.mihir.invoicesapp.repositories.CountryRepository;
import sawant.mihir.invoicesapp.repositories.InvoiceRepository;

import javax.annotation.PostConstruct;
import java.util.List;

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
        var c1 = new Country();
        c1.setName("India");
        c1.setCode("IN");

        var c2 = new Country();
        c2.setName("Brazil");
        c2.setCode("BR");

        var c3 = new Country();
        c3.setName("UAE");
        c3.setCode("AE");

        var c4 = new Country();
        c4.setName("USA");
        c4.setCode("US");

        var c5 = new Country();
        c5.setName("Turkey");
        c5.setCode("TR");



        countryRepo.saveAll(List.of(c1, c2, c3, c4, c5));

        var c1Invoice = new Invoice();
        c1Invoice.setBlNumber("IN0012");
        c1Invoice.setAaptaCertificate(true);
        c1Invoice.setCountry(c1);

        var c12Invoice = new Invoice();
        c12Invoice.setBlNumber("IN0014");
        c12Invoice.setAaptaCertificate(false);
        c12Invoice.setCountry(c1);

        var c4Invoice = new Invoice();
        c4Invoice.setBlNumber("US0091");
        c4Invoice.setAaptaCertificate(false);
        c4Invoice.setCountry(c4);

        var c3Invoice = new Invoice();
        c3Invoice.setBlNumber("AE0041");
        c3Invoice.setAaptaCertificate(true);
        c3Invoice.setCountry(c3);

        var c31Invoice = new Invoice();
        c31Invoice.setBlNumber("AE0056");
        c31Invoice.setCountry(c3);

        invoiceRepo.saveAllAndFlush(List.of(c1Invoice, c12Invoice, c3Invoice, c31Invoice, c4Invoice));

        c31Invoice.setAaptaCertificate(false);


        System.out.println("----------> Data Loaded into the DB <----------");


    }
}
