package io.codelex.p2p.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.codelex.p2p.model.Customer;
import io.codelex.p2p.model.LendingCompany;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AddLoanRequest {
    private BigDecimal issueAmount;
    private BigDecimal returnAmount;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private Customer customer;
    private LendingCompany lendingCompany;
    @JsonCreator
    public AddLoanRequest(@JsonProperty("issueAmount") BigDecimal issueAmount,
                          @JsonProperty("returnAmount")BigDecimal returnAmount,
                          @JsonProperty("issueDate")LocalDate issueDate,
                          @JsonProperty("returnDate")LocalDate returnDate,
                          @JsonProperty("customer")Customer customer,
                          @JsonProperty("lendingCompany")LendingCompany lendingCompany) {
        this.issueAmount = issueAmount;
        this.returnAmount = returnAmount;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.customer = customer;
        this.lendingCompany = lendingCompany;
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
}
