package com.example.cms.controller;
import com.example.cms.model.entities.Alcohol;
import com.example.cms.model.repositories.AlcoholRepository;
import com.example.cms.model.service.OpenAIService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import jdk.jfr.consumer.RecordedClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cms.controller.exceptions.BrandyNotFoundException;
import com.example.cms.model.entities.Brandy;
import com.example.cms.model.repositories.BrandyRepository;

import java.util.List;


@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private OpenAIService openAIService;

    @Autowired
    private AlcoholRepository alcoholRepository;

    @GetMapping
    public String getStructuredJSON(@RequestParam String message) {
        try {
            String Json_PROMPT =
                    "You are an assistant tasked with extracting the intended alcohol type and flavor from a user's query.\n\n" +
                            "Your output must be a JSON object with two keys: \"alcoholType\" as Integer and \"flavor\" as String. Use only these allowed values:\n\n" +
                            "Alcohol Types: 1:\"Beer\", 2:\"Wine\", 3:\"Spirit\", 4:\"Non-Alcoholic\"\n\n" +
                            "Flavors: \"Fruity\", \"Sweet\", \"Herbal\", \"Woody\"\n\n" +
                            "Analyze the user's query and select one valid value from each category. If the query does not clearly specify one of the values, " +
                            "choose the one that best fits the context. Return your answer strictly as JSON, without any extra text.";

            String Recommendation_PROMPT =
                    "You are a helpful alcohol recommendation assistant.\n\n" +
                            "Legal drinking age in Canada is 19 years old\n\n" +
                            "You will be given a list of available alcohol options from a database. This list includes each drink's name, main flavor, ABV (alcohol by volume), and price.\n\n" +
                            "The user will describe what they are looking for (e.g. flavor, type, alcohol strength, or price preference).\n\n" +
                            "**You must only recommend drinks that are in the provided list. Do NOT suggest drinks that are not explicitly listed.**\n\n" +
                            "Choose up to 3 drinks from the list that best match the user's preferences.\n" +
                            "For each selected drink, explain in 1–2 friendly sentences why it matches the user's request.\n\n" +
                            "Only use the data provided. Do not guess. Respond in natural language, but only refer to drinks that were listed.\n";



            String jsonResponse = openAIService.extractJsonResponse(message, Json_PROMPT);
            JsonObject json = new Gson().fromJson(jsonResponse, JsonObject.class);

            JsonElement flavorElement = json.get("flavor");
            JsonElement categoryIdElement = json.get("alcoholType");

            if (flavorElement.isJsonNull() || categoryIdElement.isJsonNull()) {
                return "I am unable to answer that question.";
            }

            String flavor = flavorElement.getAsString();
            Long categoryId = categoryIdElement.getAsLong();

            List<Alcohol> matches = alcoholRepository.findByCategoryIdAndTop1Flavor(categoryId, flavor);
            matches = matches.subList(0, Math.min(3, matches.size()));

            if (matches.isEmpty()){
                return "No Results Found";
            }

            String recommendedAlcohols = "";
            for (Alcohol alc : matches){
                recommendedAlcohols += String.format(
                        "%s | Flavor: %s | ABV: %.1f%% | Price: $%s\n",
                        alc.getName(),
                        alc.getTop1Flavor(),
                        alc.getAbv(),
                        alc.getPrice()
                );
            }

            String fullPrompt = Recommendation_PROMPT
                    + "\nAVAILABLE DRINKS:\n"
                    + recommendedAlcohols;

            return openAIService.extractJsonResponse(message, fullPrompt);

        } catch (Exception e) {
            return "Exception";
        }
    }
}
