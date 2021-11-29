package com.example.SE.controller

import com.example.SE.domain.*
import com.example.SE.service.ResorvatorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PathVariable
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import javax.servlet.http.HttpServletRequest

@Controller
class ResorvatorController {
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

    @GetMapping("/reserveMovie")
    private fun getReserveInfo(model: Model): String {

        var movieList: List<Movie>? = resorvatorService.getAllMovie()
        var theaterList: List<Theater>? = resorvatorService.getAllTheaters()
        var theaterNum = theaterList?.size

        var timeList: List<Timetable>? = resorvatorService.getAllTimetables()

        var dateList = ArrayList<LocalDate>()//timetable의 date들을 저장하는 List
        //date중복검사
        if(timeList != null){
            for(element in timeList){
                var time:LocalDate = element.tdate
                if(!dateList.contains(time)){
                    dateList.add(time)
                }
            }
        }
        var screenList: List<Screenroom>? = resorvatorService.getAllScreenrooms()

        model.addAttribute("dateList", dateList)
        model.addAttribute("movieList", movieList)
        model.addAttribute("theaterList", theaterList)
        model.addAttribute("theaterNum", theaterNum)
        model.addAttribute("timeList", timeList)
        model.addAttribute("screenList", screenList)

        return "reserveMovie"
    }

    @GetMapping("/reserveUser")
    private fun UserInfo(model: Model, httpServletRequest: HttpServletRequest): String {
        var movieDate: String = httpServletRequest.getParameter("utime")
        var movieNum: String = httpServletRequest.getParameter("movieNo")
        var theaterNum: String = httpServletRequest.getParameter("selectedTheater")
        var timeString: String = httpServletRequest.getParameter("selectedTime")
        var screenNum: String = httpServletRequest.getParameter("selectedScreen")
        var headCount: String = httpServletRequest.getParameter("headCount")
        var totalCost: String = httpServletRequest.getParameter("totalCost")

        //Mno, Tno, Sno, Date, Ttime값으로 해당 상영일시의 timeNo받아오기
        var date: LocalDate = LocalDate.parse(movieDate, DateTimeFormatter.ISO_DATE)
        var time: LocalTime = LocalTime.parse(timeString, DateTimeFormatter.ISO_TIME)
        var timeNo: Long = resorvatorService.getTimeNo(theaterNum.toLong(), movieNum.toLong(), screenNum.toLong(), date, time)

        model.addAttribute("testMovieDate", movieDate)
        model.addAttribute("testMovieNo", movieNum)
        model.addAttribute("testTheaterNo", theaterNum)
        model.addAttribute("testTime", timeString)
        model.addAttribute("testTimeAfter", time)
        model.addAttribute("testTimeNo", timeNo)
        model.addAttribute("testHeadCount", headCount)
        model.addAttribute("testTotalCost", totalCost)

        return "reserveUser"
    }

    @PostMapping("/post")
    private fun postInfo(model: Model, httpServletRequest: HttpServletRequest): String {
        var movieDate: String = httpServletRequest.getParameter("date")
        var movieNum: String = httpServletRequest.getParameter("movieNo")
        var theaterNum: String = httpServletRequest.getParameter("selectedTheater")
        var timeNum: String = httpServletRequest.getParameter("timeNo")
        var headCount: String = httpServletRequest.getParameter("headCount")
        var totalCost: String = httpServletRequest.getParameter("totalCost")
        var payment: String = httpServletRequest.getParameter("check_payment")
        var name: String = httpServletRequest.getParameter("MemberName")
        var birthDate: String = httpServletRequest.getParameter("MemberBdate")
        var pNum: String = httpServletRequest.getParameter("MemberPnum")

        var reservationNo: Long = 1
        var reservationList: List<Reservation>? = resorvatorService.getAllReservations()

        //예약번호 설정 : 예약 리스트 중 마지막 예약번호의 + 1
        if(reservationList != null){
            reservationNo = reservationList.last().Rno+1
        }
        var Bdate: LocalDate = LocalDate.parse(birthDate, DateTimeFormatter.ISO_DATE)
        var newReservation = Reservation(reservationNo, name, pNum, Bdate, headCount.toInt(), theaterNum.toLong(), movieNum.toLong(), timeNum.toLong())

        model.addAttribute("MovieDate", movieDate)
        model.addAttribute("MovieNo", movieNum)
        model.addAttribute("TheaterNo", theaterNum)
        model.addAttribute("TimeNo", timeNum)
        model.addAttribute("HeadCount", headCount)
        model.addAttribute("TotalCost", totalCost)

        model.addAttribute("Payment", payment)
        model.addAttribute("Name", name)
        model.addAttribute("BirthDate", birthDate)
        model.addAttribute("PNum", pNum)

        //예약정보 db에 등록
        resorvatorService.saveReservation(newReservation)

        return "redirect:/reservation?Num1="+reservationNo.toString()
    }
}
