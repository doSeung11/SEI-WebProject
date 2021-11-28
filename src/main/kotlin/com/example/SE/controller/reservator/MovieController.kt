package com.example.SE.controller.reservator

import com.example.SE.domain.Movie
import com.example.SE.service.ResorvatorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import javax.servlet.http.HttpServletRequest

@Controller
class MovieController {
    @Autowired
    private lateinit var resorvatorService: ResorvatorService
    var Rnum: Long =0

    @GetMapping("/")
    private fun getMovies(model:Model): String {
        var movies = resorvatorService.getAllMovie()

        var movieList = ArrayList<Movie>()
        if (movies != null) {
            for(element in movies) {
                var temp: Movie = element
                movieList.add(temp)
            }
        }
        model.addAttribute("Movies", movieList.subList(0,4))
        return "main"
    }

    @GetMapping("/all")
    private fun getAllMovies(model:Model): String {
        var movies = resorvatorService.getAllMovie()
        var allMovie = ArrayList<ArrayList<Movie>>()
        var movieList = ArrayList<Movie>()
        var i = 0
        if (movies != null) {
            for(element in movies) {
                var temp: Movie = element
                movieList.add(temp)
                i++
                if(i%4 == 0) {
                    allMovie.add(movieList.clone() as ArrayList<Movie>)
                    movieList.clear()
                }
            }
        }
        if(movieList.isNotEmpty())
            allMovie.addAll(listOf(movieList))

        model.addAttribute("Movies", allMovie)
        return "detailMovie"
    }

    @GetMapping("/movieInfo/{id}")
    private fun getMovieInfo(@PathVariable id:String, model:Model): String{
        var information = resorvatorService.getMovie(id.toLong())
        model.addAttribute("Mno", information?.Mno)
        model.addAttribute("MovieName", information?.MovieName)
        model.addAttribute("ReleaseDate", information?.ReleaseDate)
        var year = information?.ReleaseDate?.year
        var month = information?.ReleaseDate?.monthValue
        var day = information?.ReleaseDate?.dayOfMonth
        model.addAttribute("year",year)
        model.addAttribute("month",month)
        model.addAttribute("day",day)

        model.addAttribute("Mdescription", information?.Mdescription)
        model.addAttribute("Genre", information?.Genre)
        model.addAttribute("Age", information?.Age)
        model.addAttribute("RunningTime", information?.RunningTime)
        model.addAttribute("Poster", information?.Poster)
        model.addAttribute("Video", information?.Video)


        return "movieInfo"
    }

    @GetMapping("/reservations")
    private fun getReservations(): ResponseEntity<Any> {
        return ResponseEntity
                .ok()
                .body(resorvatorService.getAllReservations())
    }

    @GetMapping("/reservation")
    private fun getReservationInfo(model:Model, httpServletRequest: HttpServletRequest): String {
        var id: String = httpServletRequest.getParameter("Num1");
        var information = resorvatorService.getReservation(id.toLong());
        model.addAttribute("Rno", information?.Rno)
        model.addAttribute("Poster",information?.Poster)
        model.addAttribute("Mname",information?.Mname)
        model.addAttribute("Tname",information?.Tname)
        model.addAttribute("Sno",information?.Sno)
        model.addAttribute("Headcount",information?.Headcount)
        model.addAttribute("Tdate",information?.Tdate)
        model.addAttribute("Ttime",information?.Ttime)
        Rnum = information?.Rno!!
        return "reservationInfo"
    }

    @GetMapping("/deleteRe")
    private fun deleteReservation(): String{
        resorvatorService.deleteReservation(Rnum)
        return "main"
    }

}