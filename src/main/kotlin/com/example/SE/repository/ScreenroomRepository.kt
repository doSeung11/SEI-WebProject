package com.example.SE.repository

import com.example.SE.domain.Screenroom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ScreenroomRepository : JpaRepository<Screenroom, Long>