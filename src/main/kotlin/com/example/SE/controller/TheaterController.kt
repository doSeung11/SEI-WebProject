package com.example.SE.controller

import com.example.SE.domain.Theater
import com.example.SE.repository.TheaterRepository
import org.springframework.web.bind.annotation.*

@RestController
class TheaterController (private val theaterRepository: TheaterRepository){

    @GetMapping("/theaters")
    private fun getTheaters(): MutableIterable<Theater> =
            theaterRepository.findAll();
}