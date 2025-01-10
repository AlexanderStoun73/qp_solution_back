package us.qckpay.qp_solution_back.service;

import us.qckpay.qp_solution_back.dto.EmailRequest;

public interface EmailService {
    void sendEmail(EmailRequest emailRequest);
}
