package com.luciaya.saunas.TestData;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public class SaunaLab {
    private static SaunaLab sSaunaLab;
    private List<Sauna> saunas;

    private SaunaLab() {
        saunas = new ArrayList<>();
        saunas.add(new Sauna(randomUUID(), "Sauna1", "Это отличный отдых для всей семьи" +
                "и больших компаний. Мы рады предложить вам парную, которая поможет расслабиться" +
                " и получить положительные эмоции", 800,
                6, new String[]{"https://i.imgur.com/o7aE43w.png",
                "https://i.imgur.com/oGDcoof.png", "https://i.imgur.com/Ig9qhmW.png"},
                3, false, "Bukhara 1", "с 10:00 до 03:00",
                "Щетка для тела - 250 рублей.\nТапки одноразовые - 200 руюлей.\nШапка - 100 рублей. ",
                new ArrayList<Review>(Arrays.asList(new Review("Юлия", "19 мар 2019",
                "Отдыхали зимой очень понравилось, этот уют и комфорт просто сводит с ума! Юлия", true),
                new Review("Юрий","01 янв 2016",
                        "Отдыхали зимой очень понравилось, этот уют и комфорт просто сводит с ума! Юрий", false)))));



        saunas.add(new Sauna(randomUUID(), "Sauna2", "Это отличный отдых для всей семьи" +
                "и больших компаний. Мы рады предложить вам парную, которая поможет расслабиться" +
                " и получить положительные эмоции", 700,
                10, new String[]{"https://i.imgur.com/151vFNN.png",
                "https://i.imgur.com/1n6NGwS.jpg", "https://i.imgur.com/zUIPfQ2.jpg"},
                24, true, "Tashkent 2", "с 11:00 до 04:00",
                "Щетка для тела - 260 рублей.\nТапки одноразовые - 210 руюлей.\nШапка - 110 рублей. ",
                new ArrayList<Review>(Arrays.asList(new Review("Юлия", "25 мар 2019",
                                "Отдыхали зимой не понравилось, этот уют и комфорт просто не сводит с ума! Юлия", true),
                        new Review("Юрий", "01 ноя 2013",
                                "Отдыхали зимой не понравилось, этот уют и комфорт просто не сводит с ума! Юлия", false)))));
    }

    public static SaunaLab get() {
        if (sSaunaLab == null) {
            sSaunaLab = new SaunaLab();
        }
        return sSaunaLab;
    }
    public List<Sauna> getSaunas() {
        return saunas;
    }

    public Sauna getSauna(UUID uuid) {
        for (Sauna sauna : saunas) {
            if (sauna.getUUID().equals(uuid)) {
                Log.d("SaunaLab", "getSauna: return sauna with id " + sauna.getUUID().toString());
                return sauna;
            }
        }
        Log.d("SaunaLab", "getSauna: return null");
        return null;
    }




}
