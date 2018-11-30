package com.amruthaa.analytics.models;

import com.google.gson.Gson;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document(collection = "sentiments")
@Data
public class Sentiment {
    @Id
    String id;
    String prediction;
    String confidence;

    public Sentiment(String s, String s1, String s2) {
        this.id = UUID.randomUUID().toString();
        this.prediction = s1;
        this.confidence = s2;
    }

    public Sentiment()
    {
        this.id=UUID.randomUUID().toString();
        this.setPrediction("1.0");
        this.setConfidence("positive");
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
