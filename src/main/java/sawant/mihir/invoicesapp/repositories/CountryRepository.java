package sawant.mihir.invoicesapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sawant.mihir.invoicesapp.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
