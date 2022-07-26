package org.example.movie.booking.adapter;

import lombok.AllArgsConstructor;
import org.example.movie.core.common.booking.BookingInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerAdapter {

    @Value("${kafka.movieBookingApi.checkSeatInventory.topic.request}")
    private String seatInventoryTopicName;

    private KafkaTemplate<String, BookingInformation> kafkaTemplate;

    @Autowired
    public void setKafkaTemplate(KafkaTemplate<String, BookingInformation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendBookingInformationMessage(String uniqueId, BookingInformation message) {
        kafkaTemplate.send(seatInventoryTopicName, uniqueId, message);
    }

}
