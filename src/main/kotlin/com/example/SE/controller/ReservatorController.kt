package com.example.SE.controller

import com.example.SE.service.MovieService
import com.example.SE.service.TheaterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class ReservatorController {
    @Autowired
    private lateinit var movieService: MovieService;
    private lateinit var theaterService: TheaterService;

    @GetMapping("/")
    private fun getMovies(): String {
//        ResponseEntity
//                .ok()
//                .body(movieService.getAllMovie())
        return "hello"
    }

    @GetMapping("/movieInfo/{id}")
    private fun getMovieInfo(@PathVariable id:String, model:Model): String{
        var information = movieService.getMovie(id.toLong())
        model.addAttribute("Mno", information?.Mno);
        model.addAttribute("MovieName", information?.MovieName);
        model.addAttribute("ReleaseDate", information?.ReleaseDate);
        var year = information?.ReleaseDate?.year;
        var month = information?.ReleaseDate?.monthValue;
        var day = information?.ReleaseDate?.dayOfMonth;
        model.addAttribute("year",year);
        model.addAttribute("month",month);
        model.addAttribute("day",day);

        model.addAttribute("Mdescription", information?.Mdescription);
        model.addAttribute("Genre", information?.Genre);
        model.addAttribute("Age", information?.Age);
        model.addAttribute("RunningTime", information?.RunningTime);
        model.addAttribute("Poster", information?.Poster);
        model.addAttribute("Video", information?.Video);


        return "movieInfo"
    }

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

}