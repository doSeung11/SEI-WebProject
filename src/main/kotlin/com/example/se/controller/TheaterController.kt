package com.example.se.controller

import com.example.se.service.TheaterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TheaterController {
    @Autowired
    private lateinit var theaterService: TheaterService

    @GetMapping("/theaters")
    private fun getTheaters(): ResponseEntity<Any> {
        return ResponseEntity
                .ok()
                .body(theaterService.getAllTheaters())
    }

    @GetMapping("/theater/{id}")
    private fun getTheaterById(@PathVariable id:Long): ResponseEntity<Any>{
        return ResponseEntity
                .ok()
                .body(theaterService.getTheater(id))
    }

    @GetMapping("/theater")
    private fun getTheaterByName(@RequestParam(value="name")name:String):ResponseEntity<Any?>{
        return ResponseEntity
                .ok()
                .body(theaterService.getTheaterByName(name))
    }
}