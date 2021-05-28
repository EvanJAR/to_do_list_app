package com.project.to_do_list.repositories;

import com.project.to_do_list.models.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<Day, Long> {
}
