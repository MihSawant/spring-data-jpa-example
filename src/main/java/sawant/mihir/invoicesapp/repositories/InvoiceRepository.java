package sawant.mihir.invoicesapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sawant.mihir.invoicesapp.entities.Invoice;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findByCountryId(Long country_id);
}
