package com.society.controller.Resident_Controller;


import com.society.dao.Resident_dao.ComplaintDAO;
import com.society.model.Resident_model.ComplaintModel;
import com.society.service.resident_service.ComplaintService;

import java.util.List;

public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintDAO complaintDAO) {

        this.complaintService =
                new ComplaintService(complaintDAO);
    }

    // ================= SUBMIT COMPLAINT =================

    public ComplaintModel submitComplaint(
            String flatNumber,
            String category,
            String title,
            String description,
            String imageFileName,
            String preferredDate)
            throws Exception {

        return complaintService.createComplaint(
                flatNumber,
                category,
                title,
                description,
                imageFileName,
                preferredDate
        );
    }

    // ================= GET MY COMPLAINTS =================

    public List<ComplaintModel> getMyComplaints(
            String flatNumber)
            throws Exception {

        return complaintService.getMyComplaints(
                flatNumber
        );
    }

    // ================= GET ALL =================

    public List<ComplaintModel> getAllComplaints()
            throws Exception {

        return complaintService.getAllComplaints();
    }

    // ================= UPDATE STATUS =================

    public void updateStatus(
            String complaintId,
            String status)
            throws Exception {

        complaintService.updateStatus(
                complaintId,
                status
        );
    }
}


