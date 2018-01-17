package de.fhro.inf.prg3.a13.tweets.generators;

import com.google.gson.Gson;
import de.fhro.inf.prg3.a13.model.Tweet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.stream.Stream;

public class OfflineTweetStreamGenerator implements TweetStreamGenerator {

    private Gson gson = new Gson();


    @Override
    public Stream<Tweet> getTweetStream() {
        try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("/trump_tweets.json"))) {
            Tweet[] tweets = gson.fromJson(reader, Tweet[].class);
            return Arrays.stream(tweets);
        }catch (IOException | NullPointerException e) {
            /*ignore*/
        }
        return Stream.of();
    }
}
