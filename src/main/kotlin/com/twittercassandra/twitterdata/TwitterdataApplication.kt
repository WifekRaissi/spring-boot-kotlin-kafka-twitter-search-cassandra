package com.twittercassandra.twitterdata

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
@EnableBinding(Sink::class)
class TwitterdataApplication

fun main(args: Array<String>) {
    SpringApplication.run(TwitterdataApplication::class.java, *args)







}
