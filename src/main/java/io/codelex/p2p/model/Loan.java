package io.codelex.p2p.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long LoanId;
    @Column(nullable = false)
    private BigDecimal issueAmount;
    @Column(nullable = false)
    private BigDecimal returnAmount;
    @Column(nullable = false)
    private LocalDate issueDate;
    @Column(nullable = false)
    private LocalDate returnDate;
    @OneToOne
    private Customer customer;
    @NotNull
    @Valid
    @OneToOne
    private LendingCompany lendingCompany;
    private boolean isItReturned;

    public Loan() {
    }

    public Loan(@NotEmpty BigDecimal issueAmount,
                @NotEmpty BigDecimal returnAmount,
                @NotEmpty LocalDate issueDate,
                @NotEmpty LocalDate returnDate,
                @Valid Customer customer,
                @NotNull @Valid LendingCompany lendingCompany,
                boolean isItReturned) {
        this.issueAmount = issueAmount;
        this.returnAmount = returnAmount;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.customer = customer;
        this.lendingCompany = lendingCompany;
        this.isItReturned = isItReturned;
    }


    public Long getLoanId() {
        return LoanId;
    }

    public void setLoanId(Long loanId) {
        LoanId = loanId;
    }

    public BigDecimal getIssueAmount() {
        return issueAmount;
    }

    public void setIssueAmount(BigDecimal issueAmount) {
        this.issueAmount = issueAmount;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LendingCompany getLendingCompany() {
        return lendingCompany;
    }

    public void setLendingCompany(LendingCompany lendingCompany) {
        this.lendingCompany = lendingCompany;
    }

    public boolean isItReturned() {
        return isItReturned;
    }

    public void setItReturned(boolean itReturned) {
        isItReturned = itReturned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return getLoanId().equals(loan.getLoanId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLoanId());
    }
}
