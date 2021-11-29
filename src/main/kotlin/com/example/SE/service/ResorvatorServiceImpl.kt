package com.example.SE.service

import com.example.SE.domain.*
import com.example.SE.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalTime
import javax.transaction.Transactional

@Service
class ResorvatorServiceImpl constructor(@Autowired private val movieRepository: MovieRepository, private val reservationRepository: ReservationRepository, private val screenroomRepository: ScreenroomRepository, private val theaterRepository: TheaterRepository, private val timetableRepository: TimetableRepository): ResorvatorService{
    override fun getAllMovie(): List<Movie>? =
        movieRepository.findAllBy()


    override fun getMovie(id: Long): Movie? =
            movieRepository.findById(id).orElse(null)

    override fun getAllReservations(): List<Reservation>?  =
            reservationRepository.findAllBy()

    override fun getReservation(id: Long): ReservationInfo?{
        var rR: Reservation = reservationRepository.findById(id).orElse(null)
        var mR: Movie = movieRepository.findById(rR.Mno).orElse(null)
        var tR: Theater = theaterRepository.findById(rR.Tno).orElse(null)
        var ttR: Timetable = timetableRepository.findById(rR.TimeNo).orElse(null)
        var reservationInfo = ReservationInfo(rR.Rno, mR.Poster, mR.MovieName, tR.TheaterName, ttR.sno, rR.Headcount, ttR.tdate, ttR.ttime)
        return reservationInfo
    }

    override fun deleteReservation(id: Long) {
        reservationRepository.deleteById(id)
    }

    @Transactional
    override fun saveReservation(reservation: Reservation): Reservation =
        reservationRepository.save(reservation)

    override fun getAllScreenrooms(): List<Screenroom>? =
        screenroomRepository.findAllBy()

    override fun getAllTheaters(): List<Theater>? =
        theaterRepository.findAllBy()

    override fun getAllTimetables(): List<Timetable>? =
        timetableRepository.findAllBy()


    override fun getTimeNo(tno: Long, mno: Long, sno: Long, tdate: LocalDate, ttime: LocalTime): Long {
        var targetTable: Timetable? = timetableRepository.findFirstByTnoAndMnoAndSnoAndTdateAndTtime(tno, mno, sno, tdate, ttime)
        var timeNo: Long = 0
        if (targetTable != null) {
            timeNo = targetTable.timeNo
        }
        return timeNo
    }
}