package com.alsimon;

import com.alsimon.pojo.Unit;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Warcraft3VoilaNetDownloader {

    // Launch this in order to download the sounds of every units in Warcraft 3
    public static void downloadEveryMP3s() throws IOException {
        List<com.alsimon.pojo.Unit> units = new ArrayList<>();
        for (com.alsimon.pojo.Race race : com.alsimon.pojo.Race.values()) {
            Document doc = Jsoup.connect(race.getUrl()).userAgent("Mozilla").get();
            String urlTemp;
            for (Element element : doc.getElementsByTag("a")) {
                urlTemp = element.attr("abs:href");
                if (urlTemp.contains(race.getUrl().substring(0, race.getUrl().length() - 7)))
                    units.add(new com.alsimon.pojo.Unit(race, element.getElementsByTag("img").get(0).attr("title"), urlTemp));
            }
        }
        for (com.alsimon.pojo.Unit unit : units) {
            try {
                downloadUnitSound(fetchUnitSoundUrls(unit));
            } catch (NullPointerException e) {
                System.out.println("Unit without sound: " + unit);
            }
        }
    }

    public static com.alsimon.pojo.Unit fetchUnitSoundUrls(com.alsimon.pojo.Unit unit) throws IOException {
        Document doc = Jsoup.connect(unit.getUrl()).userAgent("Mozilla").get();
        String data;
        for (Element element : doc.getElementsByTag("object")) {
            data = element.attr("data");
            data = data.replace("dewplayermini.swf?son=", "");
            data = data.replace("dewplayermulti.swf?son=", "");
            unit.addSound(data.split("\\|"));
        }
        return unit;
    }

    public static void downloadUnitSound(Unit unit) throws IOException {
        for (String sound : unit.getSounds()) {
            FileUtils.copyURLToFile(new URL(unit.getRace().getUrl() + sound),
                    new File(sound.substring(1, sound.length())));
        }
    }
}
