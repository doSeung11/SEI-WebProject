package com.example.SE.service

import com.example.SE.domain.*
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalTime

@Service
interface ResorvatorService {
    fun getAllMovie(): List<Movie>?
    fun getMovie(id: Long): Movie?
    fun getAllReservations(): List<Reservation>?
    fun getReservation(id: Long): ReservationInfo?
    fun deleteReservation(id: Long)
    fun saveReservation(reservation: Reservation): Reservation
    fun getAllScreenrooms(): List<Screenroom>?
    fun getAllTheaters(): List<Theater>?
    fun getAllTimetables(): List<Timetable>?
    fun getTimeNo(tno: Long, mno: Long, sno: Long, tdate: LocalDate, ttime: LocalTime): Long
}