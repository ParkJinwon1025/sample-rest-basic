package com.ubisam.demo.api.monitors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubisam.demo.domain.Monitor;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {

}
