package io.codelex.p2p.repository;

import io.codelex.p2p.api.AddLoanRequest;
import io.codelex.p2p.controller.Service;
import io.codelex.p2p.model.Customer;
import io.codelex.p2p.model.Loan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RepositoryService implements Service {
    private CustomerRepository customerRepository;
    private LoanRepository loanRepository;
    private LendingCompanyRepository lendingCompanyRepository;
    private PasswordEncoder passwordEncoder;

    public RepositoryService(CustomerRepository customerRepository,
                             LoanRepository loanRepository,
                             LendingCompanyRepository lendingCompanyRepository,
                             PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.customerRepository = customerRepository;
        this.loanRepository = loanRepository;
        this.lendingCompanyRepository = lendingCompanyRepository;
    }


    public boolean isCustomerRegistered(String email) {
        return customerRepository.isThereAEmail(email);

    }

    public Customer saveCustomer(String email, String password) {

        return customerRepository.save(new Customer(
                email,
                passwordEncoder.encode(password)));

    }
    public Optional<Customer> findByEmail(String email){
        return customerRepository.findByEmail(email);
    }
    public boolean isPasswordMatching(Customer customer, String password){ 
        return passwordEncoder.matches(password,customer.getPassword());
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
