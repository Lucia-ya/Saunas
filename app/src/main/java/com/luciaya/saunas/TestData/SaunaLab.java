package com.luciaya.saunas.TestData;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public class SaunaLab {
    private static SaunaLab sSaunaLab;
    private List<Sauna> saunas;

    private SaunaLab() {
        saunas = new ArrayList<Sauna>();
        saunas.add(new Sauna(randomUUID(), "Sauna1", "Good sauna", 800,
                6, new String[]{"https://i.imgur.com/o7aE43w.png",
                "https://i.imgur.com/oGDcoof.png", "https://i.imgur.com/Ig9qhmW.png"},
                3, true, "Bukhara 1"));
        saunas.add(new Sauna(randomUUID(), "Sauna2", "Bad sauna", 700,
                10, new String[]{"https://i.imgur.com/151vFNN.png",
                "https://i.imgur.com/1n6NGwS.jpg", "https://i.imgur.com/zUIPfQ2.jpg"},
                24, false, "Tashkent 2"));
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
            if (sauna.getUUID() == uuid) {
                return sauna;
            }
        }
        return null;
    }




}
