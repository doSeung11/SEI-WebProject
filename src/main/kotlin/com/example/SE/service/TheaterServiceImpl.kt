package com.example.SE.service

import com.example.SE.domain.Theater
import com.example.SE.repository.TheaterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TheaterServiceImpl constructor(@Autowired private val theaterRepository: TheaterRepository): TheaterService{
    override fun getAllTheaters(): List<Theater>? =
            theaterRepository.findAllBy();

    override fun getTheater(id: Long): Theater? =
            theaterRepository.findById(id).orElse(null)
}