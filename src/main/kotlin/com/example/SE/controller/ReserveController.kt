package com.example.SE.controller

import com.example.SE.domain.Movie
import com.example.SE.domain.Theater
import com.example.SE.domain.Timetable
import com.example.SE.service.MovieService
import com.example.SE.service.TheaterService
import com.example.SE.service.TimetableService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping


@Controller
class ReserveController {
    @Autowired
    private lateinit var movieService: MovieService;
    @Autowired
    private lateinit var theaterService: TheaterService;
    //@Autowired
    //private lateinit var tableService: TimetableService;

    @GetMapping("/reserveMovie")

        private fun getReservationInfo(model:Model): String {

            var movieList: List<Movie>? = movieService.getAllMovie();
            var theaterList: List<Theater>? = theaterService.getAllTheaters();
            //var timeList: List<Timetable>? = tableService.getAllTable();

            model.addAttribute("movieList", movieList);
            model.addAttribute("theaterList", theaterList);
            //model.addAttribute("timeList", timeList);

            return "reserveMovie"
        }
}
