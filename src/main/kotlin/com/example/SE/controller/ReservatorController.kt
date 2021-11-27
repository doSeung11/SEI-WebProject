package com.example.SE.controller

import com.example.SE.domain.Movie
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
    private fun getMovies(model:Model): String {
        var movies = movieService.getAllMovie();

        var movieList = ArrayList<Movie>()
        if (movies != null) {
            for(element in movies) {
                var temp: Movie = element;
                movieList.add(temp)
            }
        }
        model.addAttribute("Movies", movieList.subList(0,4));
        return "main"
    }

    @GetMapping("/all")
    private fun getAllMovies(model:Model): String {
        var movies = movieService.getAllMovie();
        var allMovie = ArrayList<ArrayList<Movie>>();
        var movieList = ArrayList<Movie>();
        var i = 0
        if (movies != null) {
            for(element in movies) {
                var temp: Movie = element;
                movieList.add(temp);
                i++;
                if(i%4 == 0) {
                    allMovie.add(movieList.clone() as ArrayList<Movie>);
                    movieList.clear();
                }
            }
        }
        if(movieList.isNotEmpty())
            allMovie.addAll(listOf(movieList));

        model.addAttribute("Movies", allMovie);
        return "detailMovie"
    }

    @GetMapping("/movieInfo/{id}")
    private fun getMovieInfo(@PathVariable id:String, model:Model): String{
        var information = movieService.getMovie(id.toLong());
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
//    @GetMapping("/reservation/{id}")
//    private fun getReservationInfo(@PathVariable id:Long, model:Model): String {
//        var information = reservationService.getReservation(id);
//        var movieService: MovieService? = null
//        //var theaterService: TheaterService? = null
//        //var timetableService: TimetableService? = null
//        //var movie = movieService?.getMovie(information?.Mno);
//        //var theater = theaterService?.getTheater(information.Tno);
//        //var timetable = timetableService?.getTimetable(information.TimeNo);
//        model.addAttribute("Rno", information?.Rno);
//        //model.addAttribute("Mname",movie?.MovieName);
//        //model.addAttribute("Mposter",movie?.Poster);
//        //model.addAttribute("Tname",theater?.TheaterName);
//        //model.addAttribute("Sno",timetable?.Sno);
//        //model.addAttribute("Tdate",timetable?.Tdate)
//        //model.addAttribute("Ttime",timetable?.Ttime);
//        model.addAttribute("Headcount",information?.Headcount);
//        return "reservationInfo";
//    }

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