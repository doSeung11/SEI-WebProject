package com.example.SE.service

import com.example.SE.domain.Theater
import org.springframework.stereotype.Service

@Service
interface TheaterService {
    fun getAllTheaters(): List<Theater>?
    fun getTheater(id: Long): Theater?
}