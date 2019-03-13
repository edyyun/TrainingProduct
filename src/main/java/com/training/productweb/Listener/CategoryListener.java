package com.training.productweb.Listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.productweb.Entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CategoryListener {
    @Autowired

    private ObjectMapper objectMapper;

    @KafkaListener(topics="categories")
    public void ListenerTopicCategories(String json) throws Exception{
        Category category = objectMapper.readValue(json,Category.class);
        log.info(String.valueOf(category));
    }

}
