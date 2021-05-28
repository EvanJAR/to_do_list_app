package com.project.to_do_list.repositories;

import com.project.to_do_list.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
