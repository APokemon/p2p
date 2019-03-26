package io.codelex.p2p.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
public class LendingCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lendingCompanyId;
    private String companyName;
    @OneToMany
    private Set<Loan> loans;
    private BigDecimal funds;

    public LendingCompany() {
    }

    public LendingCompany(String companyName, Set<Loan> loans, BigDecimal funds) {
        this.companyName = companyName;
        this.loans = loans;
        this.funds = funds;
    }

    public Long getId() {
        return lendingCompanyId;
    }

    public void setId(Long id) {
        this.lendingCompanyId = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    public BigDecimal getFunds() {
        return funds;
    }

    public void setFunds(BigDecimal funds) {
        this.funds = funds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LendingCompany that = (LendingCompany) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LendingCompany{");
        sb.append("id=").append(lendingCompanyId);
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", loans=").append(loans);
        sb.append(", funds=").append(funds);
        sb.append('}');
        return sb.toString();
    }
}
