package com.example.SE.repository

import com.example.SE.domain.Movie
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : CrudRepository<Movie, Long>{
    fun findAllBy(): List<Movie>?
}