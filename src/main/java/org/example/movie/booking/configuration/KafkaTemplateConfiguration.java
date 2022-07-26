package org.example.movie.booking.configuration;

import org.example.movie.core.common.booking.BookingInformation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaTemplateConfiguration {
    @Bean
    public KafkaTemplate<String, BookingInformation> kafkaTemplateBookingInformation(
            ProducerFactory<String, BookingInformation> producerFactoryBookingInformation) {
        return new KafkaTemplate<>(producerFactoryBookingInformation);
    }
}
