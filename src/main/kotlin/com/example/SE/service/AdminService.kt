package com.example.SE.service

import com.example.SE.domain.Movie
import com.example.SE.domain.Theater
import org.springframework.stereotype.Service

@Service
interface AdminService {
    fun getAllMovie(): List<Movie>?
    fun getMovie(id: Long): Movie?

}