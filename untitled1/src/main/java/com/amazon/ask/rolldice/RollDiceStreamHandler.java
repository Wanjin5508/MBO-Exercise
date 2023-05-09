package com.amazon.ask.rolldice;
import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.rolldice.handlers.*;

public class RollDiceStreamHandler extends SkillStreamHandler{
    private static Skill getSkill(){
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new FallbackIntentHandler(),
                        new HelpIntentHandler(),
                        new RollDiceIntentHandler(),
                        new SessionEndedRequestHandler())
                .build();
    }

    public RollDiceStreamHandler(){
        super(getSkill());
    }
}
