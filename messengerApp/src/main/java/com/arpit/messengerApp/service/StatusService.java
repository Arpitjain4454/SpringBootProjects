package com.arpit.messengerApp.service;

import com.arpit.messengerApp.model.Status;
import com.arpit.messengerApp.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService implements IStatusService{

    @Autowired
    private StatusRepository statusRepository;

    public long saveStatus(Status status) {
        Status statusObj = statusRepository.save(status);
        return statusObj.getStatusId();
    }
}
