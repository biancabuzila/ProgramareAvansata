package Entities;

import java.io.Serializable;
import static java.lang.Math.pow;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CITIES")
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
    @NamedQuery(name = "City.findById", query = "SELECT c FROM City c WHERE c.id = :id"),
    @NamedQuery(name = "City.findByName", query = "SELECT c FROM City c WHERE c.name = :name"),
    @NamedQuery(name = "City.findByCapital", query = "SELECT c FROM City c WHERE c.capital = :capital"),
    @NamedQuery(name = "City.findByLatitude", query = "SELECT c FROM City c WHERE c.latitude = :latitude"),
    @NamedQuery(name = "City.findByLongitude", query = "SELECT c FROM City c WHERE c.longitude = :longitude")})
public class City implements Serializable {

    @Transient
    private long startTime;
    @Transient
    private long endTime;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "cities_sequence")
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "CAPITAL")
    private short capital;
    @Column(name = "LATITUDE")
    private BigDecimal latitude;
    @Column(name = "LONGITUDE")
    private BigDecimal longitude;
    @JoinColumn(name = "ID_COUNTRY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Country idCountry;

    public City() {
    }

    public City(BigDecimal id) {
        this.id = id;
    }

    public City(BigDecimal id, String name, short capital) {
        this.id = id;
        this.name = name;
        this.capital = capital;
    }

    public City(String name, short capital, Country idCountry) {
        this.name = name;
        this.capital = capital;
        this.idCountry = idCountry;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getCapital() {
        return capital;
    }

    public void setCapital(short capital) {
        this.capital = capital;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Country getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Country idCountry) {
        this.idCountry = idCountry;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "City: id=" + id + ", name=" + name + ", capital=" + capital + "\n";
    }

    @PrePersist
    public void logStartTime() {
        startTime = System.nanoTime();
    }

    @PostPersist
    public void logEndTime() {
        endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("City " + name + " added in " + totalTime / pow(10, 9) + " seconds.");
    }
}
