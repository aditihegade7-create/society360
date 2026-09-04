package com.society.controller.Resident_Controller;

import com.society.dao.Resident_dao.VisitorDAO;
import com.society.model.Resident_model.VisitorModel;
import com.society.service.resident_service.VisitorService;

import java.util.List;

public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorDAO visitorDAO) {

        this.visitorService =
                new VisitorService(visitorDAO);
    }

    // SEND INVITE
    public VisitorModel sendInvite(
            String visitorName,
            String phoneNumber,
            String purpose,
            String visitDate,
            String visitTime,
            String flatNumber,
            String gate,
            String vehicleNumber
    ) throws Exception {

        return visitorService.createVisitor(
                visitorName,
                phoneNumber,
                purpose,
                visitDate,
                visitTime,
                flatNumber,
                gate,
                vehicleNumber
        );
    }

    // GET TODAY'S VISITORS
    public List<VisitorModel> getTodayVisitors()
            throws Exception {

        return visitorService.getTodayVisitors();
    }

    // VERIFY QR
    public VisitorModel verifyQR(
            String qrToken
    ) throws Exception {

        return visitorService.verifyQR(
                qrToken
        );
    }

    // ALLOW ENTRY
    public void allowEntry(
            String visitorId
    ) throws Exception {

        visitorService.allowEntry(
                visitorId
        );
    }
}