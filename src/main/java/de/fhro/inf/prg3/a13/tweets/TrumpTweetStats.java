package de.fhro.inf.prg3.a13.tweets;

import de.fhro.inf.prg3.a13.model.Tweet;
import org.apache.commons.lang3.NotImplementedException;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Peter Kurfer
 */
public class TrumpTweetStats {

    public static Map<String, Long> calculateSourceAppStats(Stream<Tweet> tweetStream) {
        /* notTODO group the tweets by the `sourceApp` they were created with and count how many it were per `sourceApp` */
        //throw new NotImplementedException("TrumpTweetStats.calculateSourceAppStats(...) not implemented yet.");

        return tweetStream
                .collect(Collectors.groupingBy(Tweet::getSourceApp, Collectors.counting()));
    }

    public static Map<String, Set<Tweet>> calculateTweetsBySourceApp(Stream<Tweet> tweetStream) {
        /* notTODO group the tweets by the `sourceApp`
         * collect the tweets in `Set`s for each source app */
        //throw new NotImplementedException("TrumpTweetStats.calculateTweetsBySourceApp(...) not implemented yet.");

        return tweetStream.collect(Collectors.groupingBy(Tweet::getSourceApp, Collectors.toSet()));
    }

    public static Map<String, Integer> calculateWordCount(Stream<Tweet> tweetStream, List<String> stopWords) {
        /* Remark: implement this method at last */
        /* notTODO split the tweets, lower them, trim them, remove all words that are in the `stopWords`,
         * reduce the result to a Map<String, Integer> to count how often each word were in the tweets
         * optionally you could filter for all words that were used more than 10 times */
        //throw new NotImplementedException("TrumpTweetStats.tweetStream(...) not implemented yet.");
        return tweetStream
                .map(Tweet::getText)
                .map(t -> t.split("( )+"))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .filter(w -> !stopWords.contains(w))
                .reduce(new HashMap<String, Integer>(), (map, word) -> {
                    if (map.containsKey(word))
                        map.put(word, map.get(word)+1);
                    else
                        map.put(word, 1);
                    return map;
                }, (m1, m2) -> m1);
    }
}
