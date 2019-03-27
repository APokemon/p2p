package io.codelex.p2p.controller;

import io.codelex.p2p.api.AddLoanRequest;
import org.springframework.stereotype.Component;

@Component
class RequestValidator {
    boolean isAddLoanRequestValid(AddLoanRequest request) {
        if (request.getReturnAmount().compareTo(request.getIssueAmount()) < 0) {
            return false;
        }
        if (request.getIssueDate().isAfter(request.getReturnDate())) {
            return false;
        }
        if (request.getIssueDate().isEqual(request.getReturnDate())) {
            return false;
        } else return true;

    }
}
