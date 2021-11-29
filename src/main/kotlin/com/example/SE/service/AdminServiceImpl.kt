package com.example.SE.service

import com.example.SE.domain.Movie
import com.example.SE.domain.Theater
import com.example.SE.repository.MovieRepository
import com.example.SE.repository.TheaterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AdminServiceImpl constructor(@Autowired private val movieRepository: MovieRepository, private val theaterRepository: TheaterRepository): AdminService{
    override fun getAllMovie(): List<Movie>? =
            movieRepository.findAllBy();


    override fun getMovie(id: Long): Movie? =
            movieRepository.findById(id).orElse(null);


}