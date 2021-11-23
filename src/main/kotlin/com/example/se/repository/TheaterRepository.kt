package com.example.se.repository

import com.example.se.domain.Theater
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TheaterRepository : CrudRepository<Theater, Long>{
    fun findByTheaterName(theaterName: String): Theater?
    @Query("select * from Theater")
    fun findAllBy(): List<Theater>?
}