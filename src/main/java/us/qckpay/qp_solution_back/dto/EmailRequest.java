package us.qckpay.qp_solution_back.dto;

import lombok.Data;

@Data
public class EmailRequest {
    private String name;
    private String email;
    private String service;
    private String message;
}
