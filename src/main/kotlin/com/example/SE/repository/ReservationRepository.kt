package com.example.SE.repository

import com.example.SE.domain.Reservation
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservationRepository : CrudRepository<Reservation, Long>{
    fun findAllBy(): List<Reservation>?
}