package com.amazon.ask.rolldice.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.dispatcher.request.handler.impl.IntentRequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.request.Predicates;
import java.util.Map;
import java.util.Optional;

public class RollDiceIntentHandler implements IntentRequestHandler {

    @Override
    public boolean canHandle(HandlerInput input, IntentRequest intentRequest) {
        //return input.matches(Predicates.intentName("RollDiceIntent"));
        return intentRequest.getIntent().getName().equals("RollDiceIntent");
    }

    @Override
    public Optional<Response> handle(HandlerInput input, IntentRequest intentRequest) {
        Map<String, Slot> slots = intentRequest.getIntent().getSlots();
        Slot diceSizeSlot = slots.get("DiceSize");
        int diceSize = Integer.parseInt(diceSizeSlot.getValue());

        // Roll the dice
        int roll = (int) (Math.random() * diceSize) + 1;

        String speechText = "You rolled a " + roll;

        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("RollDice", speechText)
                .build();
    }

}

