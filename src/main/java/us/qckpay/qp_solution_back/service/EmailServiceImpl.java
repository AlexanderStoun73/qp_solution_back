package us.qckpay.qp_solution_back.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import us.qckpay.qp_solution_back.dto.EmailRequest;

import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailServiceImpl implements EmailService{

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    String fromAddress;

    public void sendEmail(EmailRequest emailRequest) {
        try {
            String senderAddress = emailRequest.getEmail(); // Введенный пользователем адрес
            String senderName = emailRequest.getName(); // Имя отправителя, например, "Иван Иванов"
            String subject = emailRequest.getService();
            String messageBody = emailRequest.getMessage();

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // Указываем имя отправителя
            helper.setFrom(fromAddress, senderName); // Отправитель с указанием имени
            helper.setReplyTo(senderAddress); // Адрес для ответа
            helper.setTo(fromAddress); // Получатель — order@qcksolve.us
            helper.setSubject(subject);
            helper.setText(messageBody, true);

            javaMailSender.send(message);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
