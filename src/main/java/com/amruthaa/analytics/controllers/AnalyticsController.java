package com.amruthaa.analytics.controllers;

import com.amruthaa.analytics.models.Sentiment;
import com.amruthaa.analytics.repositories.SentimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AnalyticsController {

    @Autowired
    SentimentRepository sentimentRepository;

    @RequestMapping("/")
    public String index() {
        return "Welcome to analytics API!";
    }

    @RequestMapping(method= RequestMethod.GET, value="/sentiments")
    public Iterable<Sentiment> sentiment() {
        return sentimentRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/sentiments")
    public String save(@RequestBody Sentiment sentiment) {
        sentimentRepository.save(sentiment);
        return sentiment.getId();
    }

    @RequestMapping(method=RequestMethod.GET, value="/sentiments/{id}")
    public Optional<Sentiment> get(@PathVariable String id) {
        return sentimentRepository.findById(id);
    }

}
