package com.example.se.repository

import com.example.se.domain.Timetable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TimetableRepository : JpaRepository<Timetable, Long>