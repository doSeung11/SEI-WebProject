package com.example.SE.service

import com.example.SE.domain.*
import com.example.SE.repository.MovieRepository
import com.example.SE.repository.ReservationRepository
import com.example.SE.repository.TheaterRepository
import com.example.SE.repository.TimetableRepository
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

@Service

class ReservationServiceImpl constructor(@Autowired private val reservationRepository: ReservationRepository, private val movieRepository: MovieRepository, private val theaterRepository: TheaterRepository, private val timetableRepository: TimetableRepository): ReservationService{

    override fun getAllReservations(): List<Reservation>?  =
            reservationRepository.findAllBy()

    override fun getReservation(id: Long): ReservationInfo?{
        var rR: Reservation = reservationRepository.findById(id).orElse(null)
        var mR: Movie = movieRepository.findById(rR.Mno).orElse(null)
        var tR: Theater = theaterRepository.findById(rR.Tno).orElse(null)
        var ttR: Timetable = timetableRepository.findById(rR.TimeNo).orElse(null)
        var reservationInfo = ReservationInfo(rR.Rno, mR.Poster, mR.MovieName, tR.TheaterName, ttR.Sno, rR.Headcount, ttR.Tdate, ttR.Ttime)
        return reservationInfo
    }

    override fun deleteReservation(id: Long) {
        reservationRepository.deleteById(id)
    }
}