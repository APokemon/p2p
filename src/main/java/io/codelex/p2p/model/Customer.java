package io.codelex.p2p.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String firstName;
    private String lastName;
    private Long funds;
    @OneToMany
    private Set<Loan> loans;

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, Set<Loan> loans) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.loans = loans;
        this.funds = 0L;
    }

    public Long getId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    public Loan addLoan(Loan loan) {
        this.loans.add(loan);
        return loan;
    }

    public Long addFunds(Long funds) {
        this.funds += funds;
        return funds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getId().equals(customer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("Id=").append(customerId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", funds=").append(funds);
        sb.append(", loans=").append(loans);
        sb.append('}');
        return sb.toString();
    }
}
