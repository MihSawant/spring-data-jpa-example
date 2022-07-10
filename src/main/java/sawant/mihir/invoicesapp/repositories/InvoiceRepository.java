package sawant.mihir.invoicesapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sawant.mihir.invoicesapp.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
