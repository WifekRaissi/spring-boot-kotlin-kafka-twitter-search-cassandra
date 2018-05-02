package com.twittercassandra.twitterdata.repositories

import com.twittercassandra.twitterdata.entities.TweetByTerm
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository


@Repository
interface TweetRepository:   CassandraRepository<TweetByTerm> {
    // fun findByretweet_count(retweet_count: Int): MutableList<TweetByText>
    // fun findByText(text: String): MutableList<TweetByText>


}