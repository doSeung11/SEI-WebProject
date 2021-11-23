package com.example.se.service

import com.example.se.domain.Theater
import com.example.se.repository.TheaterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
interface TheaterService {
    fun getAllTheaters(): List<Theater>?
    fun getTheater(id: Long): Theater?
    fun getTheaterByName(name: String): Theater?
}