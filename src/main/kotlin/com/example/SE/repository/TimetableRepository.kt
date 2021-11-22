package com.example.SE.repository

import com.example.SE.domain.Timetable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TimetableRepository : JpaRepository<Timetable, Long>