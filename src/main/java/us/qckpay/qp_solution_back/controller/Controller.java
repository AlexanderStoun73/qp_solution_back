package us.qckpay.qp_solution_back.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.qckpay.qp_solution_back.dto.EmailRequest;
import us.qckpay.qp_solution_back.service.EmailService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000"})
public class Controller {

    EmailService emailService;

//    @RequestMapping(method = RequestMethod.OPTIONS)
//    public ResponseEntity<Void> handleOptions(HttpServletRequest request) {
//        System.out.println("OPTIONS request received for: " + request.getRequestURI());
//        return ResponseEntity.ok().build();
//    }

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendEmail(emailRequest);
        return ResponseEntity.ok("Email sent successfully!");
    }
}
