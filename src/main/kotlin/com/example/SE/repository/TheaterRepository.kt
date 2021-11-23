package com.example.SE.repository

import com.example.SE.domain.Theater
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TheaterRepository : CrudRepository<Theater, Long>