package sawant.mihir.invoicesapp.services;

import org.springframework.stereotype.Service;
import sawant.mihir.invoicesapp.entities.Invoice;
import sawant.mihir.invoicesapp.repositories.InvoiceRepository;

import java.util.List;

@Service
public record InvoiceService(InvoiceRepository invoiceRepository) {
    public InvoiceService(InvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getAllInvoicesByCountry(Long country_id){
        return invoiceRepository.findByCountryId(country_id);
    }
}
