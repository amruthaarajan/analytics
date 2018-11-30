package com.amruthaa.analytics.repositories;

import com.amruthaa.analytics.models.Sentiment;
import org.springframework.data.repository.CrudRepository;

public interface SentimentRepository extends CrudRepository<Sentiment, String> {

    @Override
    void delete(Sentiment deleted);
}