package br.com.spring.boot.service;

import org.springframework.mail.SimpleMailMessage;

import br.com.spring.boot.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
