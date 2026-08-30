


package com.society.service.resident_service;

import com.society.dao.Resident_dao.ComplaintDAO;
import com.society.model.Resident_model.ComplaintModel;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ComplaintService {

    private final ComplaintDAO complaintDAO;

    public ComplaintService(ComplaintDAO complaintDAO) {
        this.complaintDAO = complaintDAO;
    }

    // ================= CREATE COMPLAINT =================

    public ComplaintModel createComplaint(
            String flatNumber,
            String category,
            String title,
            String description,
            String imageFileName,
            String preferredDate)
            throws Exception {

        ComplaintModel complaint =
                new ComplaintModel();

        // Generate unique ID
        complaint.setId(
                UUID.randomUUID().toString()
        );

        complaint.setFlatNumber(flatNumber);

        complaint.setCategory(category);

        complaint.setTitle(title);

        complaint.setDescription(description);

        complaint.setImageFileName(imageFileName);

        complaint.setPreferredDate(preferredDate);

        // Default status
        complaint.setStatus("IN PROGRESS");

        // Creation time
        complaint.setCreatedAt(new Date());

        // Save to Firestore
        complaintDAO.saveComplaint(complaint);

        return complaint;
    }

    // ================= GET MY COMPLAINTS =================

    public List<ComplaintModel> getMyComplaints(
            String flatNumber)
            throws Exception {

        return complaintDAO.getComplaintsByFlat(
                flatNumber
        );
    }

    // ================= GET ALL =================

    public List<ComplaintModel> getAllComplaints()
            throws Exception {

        return complaintDAO.getAllComplaints();
    }

    // ================= UPDATE STATUS =================

    public void updateStatus(
            String complaintId,
            String status)
            throws Exception {

        complaintDAO.updateStatus(
                complaintId,
                status
        );
    }
}


