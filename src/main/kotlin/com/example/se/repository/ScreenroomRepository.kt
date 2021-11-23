package com.example.se.repository

import com.example.se.domain.Screenroom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ScreenroomRepository : JpaRepository<Screenroom, Long>