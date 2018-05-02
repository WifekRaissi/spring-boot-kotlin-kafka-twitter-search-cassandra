package com.twittercassandra.twitterdata.entities


import org.springframework.data.cassandra.mapping.PrimaryKey
import org.springframework.data.cassandra.mapping.Table


@Table("alltweetbyterms")
data class TweetByTerm(

        @PrimaryKey
        var term:String?,
        var id_user:Long?,
        var id_tweet:Long?,
        var text:String?,
        var retweet_count:Int?,
        var address:String?,
        var country:String?






)
