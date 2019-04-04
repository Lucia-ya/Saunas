package com.luciaya.saunas.TestData;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

public class SaunaLab {
    private List<Sauna> saunas;

    private SaunaLab() {
        saunas = new ArrayList<>(saunas);
        saunas.add(new Sauna(randomUUID(), "Sauna1", "Good sauna", 800,
                6, "https://i.imgur.com/o7aE43w.png",
                "https://i.imgur.com/oGDcoof.png",
                "https://i.imgur.com/Ig9qhmW.png", 3, true, "Buhara 1"));
        saunas.add(new Sauna(randomUUID(), "Sauna2", "Bad sauna", 700,
                10, "https://i.imgur.com/151vFNN.png",
                "https://i.imgur.com/1n6NGwS.jpg",
                "https://i.imgur.com/zUIPfQ2.jpg", 24, false, "Tashkent 2"));
    }

    public List<Sauna> getSaunas() {
        if (saunas == null) {
            new SaunaLab();
        }
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
