package com.example.SE.service

import com.example.SE.domain.Reservation
import com.example.SE.domain.ReservationInfo
import org.springframework.stereotype.Service

@Service
interface ReservationService {
    fun getAllReservations(): List<Reservation>?
    fun getReservation(id: Long): ReservationInfo?
    fun deleteReservation(id: Long)
}