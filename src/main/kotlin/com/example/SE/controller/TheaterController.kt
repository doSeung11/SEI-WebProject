//package com.example.SE.controller
//
//import com.example.SE.service.TheaterService
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.*
//
//@RestController
//class TheaterController {
//    @Autowired
//    private lateinit var theaterService: TheaterService
//
//    @GetMapping("/theaters")
//    private fun getTheaters(): ResponseEntity<Any> {
//        return ResponseEntity
//                .ok()
//                .body(theaterService.getAllTheaters())
//    }
//
//    @GetMapping("/theater/{id}")
//    private fun getTheaterById(@PathVariable id:Long): ResponseEntity<Any>{
//        return ResponseEntity
//                .ok()
//                .body(theaterService.getTheater(id))
//    }
//
//
//}