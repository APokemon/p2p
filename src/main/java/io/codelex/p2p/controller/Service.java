package io.codelex.p2p.controller;

import io.codelex.p2p.api.AddLoanRequest;
import io.codelex.p2p.model.Loan;

import java.util.List;

public interface Service {
    Loan addLoan (AddLoanRequest request);
    
    List<Loan> findAllLoans();
    
    Loan findLoanById(Long id);
    
    
}
