package com.example.SE.service

import com.example.SE.domain.Movie
import org.springframework.stereotype.Service

@Service
interface MovieService {
    fun getAllMovie(): List<Movie>?
    fun getMovie(id: Long): Movie?
}