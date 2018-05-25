package com.twittercassandra.twitterdata.services

import org.springframework.stereotype.Service
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.twittercassandra.twitterdata.entities.Tweet
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

import com.google.gson.Gson
import com.twittercassandra.twitterdata.entities.TweetByTerm
import com.twittercassandra.twitterdata.repositories.TweetRepository
import org.springframework.cloud.stream.annotation.StreamListener


@Service

open class TwitterServiceImpl:TwitterService{
    val JSON = jacksonObjectMapper()

    @Autowired
    lateinit var tweetRepository: TweetRepository
    private val logger = LoggerFactory.getLogger(TwitterService::class.java)

    val gson = Gson()


    @StreamListener("input")
    override fun receiveTweet(tweetString: ByteArray) {

        val parsedMessage = JSON.readValue(tweetString, String::class.java)
        val tweet = gson.fromJson(parsedMessage, Tweet::class.java)
        val list=tweet.statuses


        for ( f in list){


             logger.info("term: ${tweet.term} geo:${f.geo} Coordinates:${f.coordinates} address:${f.place?.full_name} Country:${f.place?.country} Retweets Number: ${f.retweet_count} text: ${f.text}")// Exact address:${f.place?.full_name},Exact address:${f.place?.country} ")

             val tweet2= TweetByTerm(tweet.term, f.user?.id, f.id,f.text,f.retweet_count,f.place?.full_name, f.place?.country )
             tweetRepository.save(tweet2)
            logger.info("your tweets have been saved successfully ")
        }





    }

}