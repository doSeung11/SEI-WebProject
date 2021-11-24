package com.example.SE.service

import com.example.SE.domain.Movie
import com.example.SE.repository.MovieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl constructor(@Autowired private val movieRepository: MovieRepository): MovieService{
    override fun getAllMovie(): List<Movie>? =
        movieRepository.findAllBy();


    override fun getMovie(id: Long): Movie? =
            movieRepository.findById(id).orElse(null);

}