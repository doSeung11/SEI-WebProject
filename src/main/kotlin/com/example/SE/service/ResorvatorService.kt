package com.example.SE.service

import com.example.SE.domain.Movie
import com.example.SE.domain.Reservation
import com.example.SE.domain.ReservationInfo
import org.springframework.stereotype.Service

@Service
interface ResorvatorService {
    fun getAllMovie(): List<Movie>?
    fun getMovie(id: Long): Movie?
    fun getAllReservations(): List<Reservation>?
    fun getReservation(id: Long): ReservationInfo?
    fun deleteReservation(id: Long)
}