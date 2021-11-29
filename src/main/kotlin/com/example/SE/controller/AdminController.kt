package com.example.SE.controller.reservator

import com.example.SE.domain.Movie
import com.example.SE.domain.Theater
import com.example.SE.service.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class AdminController {
    @Autowired
    private lateinit var AdminService: AdminService;

    @GetMapping("/admin")
    private fun admin(model:Model): String {
        var movies = AdminService.getAllMovie();
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
        return "admin_main"
    }

    @GetMapping("/update_movie/{id}")
    private fun update_movie(@PathVariable id:String, model:Model): String{
        var information = AdminService.getMovie(id.toLong());
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

        var theaters = AdminService.getAllTheaters();
        var allTheater = ArrayList<Theater>();
        if (theaters != null) {
            for(element in theaters) {
                allTheater.add(element);
                model.addAttribute("theater"+element.Tno, element.TheaterName);
            }
        }
        model.addAttribute("Theaters", allTheater);

        return "update_movie"
    }

    @GetMapping("/add_movie")
    private fun add_movie(model:Model): String {
        var movies = AdminService.getAllMovie();
        model.addAttribute("movies_length", movies?.size?.plus(1));
        return "add_movie"
    }

    @GetMapping("/update_showtime/{id}")
    private fun update_showtime(@PathVariable id:String, model:Model): String {

        var information = AdminService.getMovie(id.toLong());
        model.addAttribute("MovieName", information?.MovieName);
        model.addAttribute("Mno", information?.Mno);

        var theaters = AdminService.getAllTheaters();
        var allTheater = ArrayList<Theater>();
        if (theaters != null) {
            for(element in theaters) {
                allTheater.add(element);
                model.addAttribute("theater"+element.Tno, element.TheaterName);
            }
        }
        model.addAttribute("Theaters", allTheater);

        return "update_showtime"
    }

}