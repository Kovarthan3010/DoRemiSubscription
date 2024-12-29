package com.example.geektrust.Constants;

import com.example.geektrust.DAO.PlanTemplate;
import java.util.HashMap;
import static com.example.geektrust.Constants.Constants.*;

public class PremiumRepo {

    public static HashMap<String, PlanTemplate> musicStore = getMusicStore();
    public static HashMap<String, PlanTemplate> podCastStore = getPodCastStore();
    public static HashMap<String, PlanTemplate> videoStore = getVideoStore();
    public static HashMap<String, PlanTemplate> topUpStore = getTopUpStore();

    public static HashMap<String, PlanTemplate> getMusicStore() {
        HashMap<String, PlanTemplate> musicStore = new HashMap<>();
        PlanTemplate musicFree = new PlanTemplate(0, 1);
        PlanTemplate musicPersonal = new PlanTemplate(100, 1);
        PlanTemplate musicPremium = new PlanTemplate(250, 3);
        musicStore.put(FREE, musicFree);
        musicStore.put(PERSONAL, musicPersonal);
        musicStore.put(PREMIUM, musicPremium);
        return musicStore;
    }

    public static HashMap<String, PlanTemplate> getVideoStore() {
        HashMap<String, PlanTemplate> videoStore = new HashMap<>();
        PlanTemplate videoFree = new PlanTemplate(0, 1);
        PlanTemplate videoPersonal = new PlanTemplate(200, 1);
        PlanTemplate videoPremium = new PlanTemplate(500, 3);
        videoStore.put(FREE, videoFree);
        videoStore.put(PERSONAL, videoPersonal);
        videoStore.put(PREMIUM, videoPremium);
        return videoStore;
    }

    public static HashMap<String, PlanTemplate> getPodCastStore() {
        HashMap<String, PlanTemplate> podCastStore = new HashMap<>();
        PlanTemplate podCastFree = new PlanTemplate(0, 1);
        PlanTemplate podCastPersonal = new PlanTemplate(100, 1);
        PlanTemplate podCastPremium = new PlanTemplate(300, 3);
        podCastStore.put(FREE, podCastFree);
        podCastStore.put(PERSONAL, podCastPersonal);
        podCastStore.put(PREMIUM, podCastPremium);
        return podCastStore;
    }

    public static HashMap<String, PlanTemplate> getTopUpStore() {
        HashMap<String, PlanTemplate> topUpStore = new HashMap<>();
        PlanTemplate fourDevice = new PlanTemplate(50 , 1);
        PlanTemplate tenDevice = new PlanTemplate(100,1);
        topUpStore.put(FOUR_DEVICE,fourDevice);
        topUpStore.put(TEN_DEVICE,tenDevice);
        return topUpStore;
    }
}