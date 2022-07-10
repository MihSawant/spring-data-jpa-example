package sawant.mihir.invoicesapp.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Invoice")
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    private String blNumber;


    private boolean aaptaCertificate;

    @ManyToOne
    @JoinColumn(name = "country_id", foreignKey = @ForeignKey(name = "COUNTRY_FK_ID"))
    private Country country;

    public Invoice(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlNumber() {
        return blNumber;
    }

    public void setBlNumber(String blNumber) {
        this.blNumber = blNumber;
    }

    public boolean isAaptaCertificate() {
        return aaptaCertificate;
    }

    public void setAaptaCertificate(boolean aaptaCertificate) {
        this.aaptaCertificate = aaptaCertificate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return aaptaCertificate == invoice.aaptaCertificate && Objects.equals(id, invoice.id) && Objects.equals(blNumber, invoice.blNumber) && Objects.equals(country, invoice.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, blNumber, aaptaCertificate, country);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", blNumber='" + blNumber + '\'' +
                ", aaptaCertificate=" + aaptaCertificate +
                ", country=" + country +
                '}';
    }
}
