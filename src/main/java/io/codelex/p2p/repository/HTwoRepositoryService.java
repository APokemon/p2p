package io.codelex.p2p.repository;

import io.codelex.p2p.api.AddLoanRequest;
import io.codelex.p2p.controller.Service;
import io.codelex.p2p.model.Loan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HTwoRepositoryService implements Service {
    private CustomerRepository customerRepository;
    private LoanRepository loanRepository;

    public HTwoRepositoryService(CustomerRepository customerRepository, LoanRepository loanRepository) {
        this.customerRepository = customerRepository;
        this.loanRepository = loanRepository;
    }


    @Override
    public Loan addLoan(AddLoanRequest request) {
        Loan loan = new Loan();
        loan.setCustomer(null);
        loan.setLendingCompany(request.getLendingCompany());
        loan.setIssueAmount(request.getIssueAmount());
        loan.setReturnAmount(request.getReturnAmount());
        loan.setIssueDate(request.getIssueDate());
        loan.setReturnDate(request.getReturnDate());
        loan.setItReturned(false);
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> findAllLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Loan findLoanById(Long id) {
        return loanRepository.findById(id)
                .orElse(null);
    }
}
