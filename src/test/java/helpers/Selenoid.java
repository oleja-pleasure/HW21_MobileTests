package helpers;

import config.Credentials;

import java.net.MalformedURLException;
import java.net.URL;

public class Selenoid {
    public static URL getVideoUrl(String sessionId) {
        String server = Credentials.credentials.env();
        String videoUrl = "https://" + server + "/video/" + sessionId + ".mp4";

        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
