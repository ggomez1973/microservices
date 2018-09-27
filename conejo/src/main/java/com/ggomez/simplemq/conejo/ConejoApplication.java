package com.ggomez.simplemq.conejo;

<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConejoApplication {
	private static final Logger logger = LoggerFactory.getLogger(ConejoApplication.class);
	static final String topicExchangeName = "spring-amqp-exchange";
	static final String queueName = "q1";
	static final String routingKey = "q1";
	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}
	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}
	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	}
	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}
	@Bean
	MessageListenerAdapter listenerAdapter(ConejoReceiver receiver) {
		return new MessageListenerAdapter(receiver, "recibirMensaje");
	}

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ConejoApplication.class, args).close();
=======
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ConejoApplication {
	@Bean
	public CommandLineRunner tutorial() {
		return new RabbitAmqpRunner();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConejoApplication.class, args);
>>>>>>> 9a0339c807cd45f42d056f70cba23fa81ab753cb
	}
}
