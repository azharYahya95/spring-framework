package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    private String data[] ={
            "Beware of the wolf in sheet clothing",
            "Diligence is the mother of good luck",
            "The Journey is the reward"
    };

    private Random random = new Random();
    @Override
    public String getDailyFortune() {
        int index = random.nextInt(data.length);
        return data[index];
    }
}
