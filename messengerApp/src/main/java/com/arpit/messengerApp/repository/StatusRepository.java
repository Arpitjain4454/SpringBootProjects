package com.arpit.messengerApp.repository;

import com.arpit.messengerApp.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
