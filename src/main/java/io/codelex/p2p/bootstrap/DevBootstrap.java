package io.codelex.p2p.bootstrap;

import io.codelex.p2p.model.Customer;
import io.codelex.p2p.model.LendingCompany;
import io.codelex.p2p.model.Loan;
import io.codelex.p2p.repository.CustomerRepository;
import io.codelex.p2p.repository.LendingCompanyRepository;
import io.codelex.p2p.repository.LoanRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
/*
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private LoanRepository loanRepository;
    private CustomerRepository customerRepository;
    private LendingCompanyRepository lendingCompanyRepository;

    public DevBootstrap(LoanRepository loanRepository,
                        CustomerRepository customerRepository,
                        LendingCompanyRepository lendingCompanyRepository) {
        this.loanRepository = loanRepository;
        this.customerRepository = customerRepository;
        this.lendingCompanyRepository = lendingCompanyRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Customer firstCustomer = createCustomer();
        customerRepository.save(firstCustomer);
        LendingCompany  firstLendingCompany = createLendingCompany();
        lendingCompanyRepository.save(firstLendingCompany);
        Loan firstLoan = new Loan(
                new BigDecimal(1000),
                new BigDecimal(1200),
                LocalDate.of(2019,4,1),
                LocalDate.of(2019,4,1).plusDays(14),
                firstCustomer,
                firstLendingCompany,
                false
        );
        loanRepository.save(firstLoan);
        
    }
    Customer createCustomer(){
        Set<Loan> loans= new HashSet<>();
        return new Customer(
                1L,
                "Andris",
                "Kivics",
                loans
        );
    }
    LendingCompany createLendingCompany(){
        Set<Loan> loans= new HashSet<>();

        return new LendingCompany(
                "Onzaem",
                loans,
                new BigDecimal(0)
        );
    }
}*/
