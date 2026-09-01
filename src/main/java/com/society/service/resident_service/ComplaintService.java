package com.society.service.resident_service;

import com.society.dao.Resident_dao.ComplaintDAO;
import com.society.model.Resident_model.ComplaintModel;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ComplaintService {

    private final ComplaintDAO complaintDAO;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public ComplaintService(ComplaintDAO complaintDAO) {

        this.complaintDAO = complaintDAO;
    }

    // =========================================================
    // CREATE COMPLAINT
    // =========================================================

    public ComplaintModel createComplaint(
            String email,
            String flatNumber,
            String category,
            String title,
            String description,
            String imageFileName,
            String preferredDate)
            throws Exception {

        // =====================================================
        // VALIDATE EMAIL
        // =====================================================

        if (email == null ||
                email.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Logged-in email is missing."
            );
        }

        email = email.trim().toLowerCase();

        // =====================================================
        // GET RESIDENT SOCIETY
        // =====================================================
        /*
         * Society will NOT be entered manually.
         *
         * It will be fetched from:
         *
         * Residents/{email}
         *
         * Example:
         *
         * Residents
         *   └── resident@gmail.com
         *        ├── name
         *        ├── flatNumber
         *        └── society: "stanza"
         */

        String society =
                complaintDAO.getResidentSociety(email);

        if (society == null ||
                society.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Society not found for resident: " + email
            );
        }

        society = society.trim();

        // =====================================================
        // CREATE COMPLAINT MODEL
        // =====================================================

        ComplaintModel complaint =
                new ComplaintModel();

        // =====================================================
        // UNIQUE COMPLAINT ID
        // =====================================================

        complaint.setId(
                UUID.randomUUID().toString()
        );

        // =====================================================
        // EMAIL
        // =====================================================

        complaint.setEmail(
                email
        );

        // =====================================================
        // FLAT NUMBER
        // =====================================================

        complaint.setFlatNumber(
                flatNumber
        );

        // =====================================================
        // CATEGORY
        // =====================================================

        complaint.setCategory(
                category
        );

        // =====================================================
        // TITLE
        // =====================================================

        complaint.setTitle(
                title
        );

        // =====================================================
        // DESCRIPTION
        // =====================================================

        complaint.setDescription(
                description
        );

        // =====================================================
        // IMAGE
        // =====================================================

        complaint.setImageFileName(
                imageFileName
        );

        // =====================================================
        // PREFERRED DATE
        // =====================================================

        complaint.setPreferredDate(
                preferredDate
        );

        // =====================================================
        // DEFAULT STATUS
        // =====================================================

        complaint.setStatus(
                "IN PROGRESS"
        );

        // =====================================================
        // CREATION TIME
        // =====================================================

        complaint.setCreatedAt(
                new Date()
        );

        // =====================================================
        // SOCIETY
        // =====================================================
        /*
         * IMPORTANT:
         *
         * Society comes automatically from Resident signup.
         *
         * Example:
         *
         * Resident signup society = "stanza"
         *
         * Complaint:
         * society = "stanza"
         */

        complaint.setSociety(
                society
        );

        // =====================================================
        // DEBUG
        // =====================================================

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "ComplaintService.createComplaint()"
        );

        System.out.println(
                "Complaint ID : " + complaint.getId()
        );

        System.out.println(
                "Email        : " + complaint.getEmail()
        );

        System.out.println(
                "Flat Number  : " + complaint.getFlatNumber()
        );

        System.out.println(
                "Category     : " + complaint.getCategory()
        );

        System.out.println(
                "Title        : " + complaint.getTitle()
        );

        System.out.println(
                "Description  : " + complaint.getDescription()
        );

        System.out.println(
                "PreferredDate: " + complaint.getPreferredDate()
        );

        System.out.println(
                "Status       : " + complaint.getStatus()
        );

        System.out.println(
                "Society      : " + complaint.getSociety()
        );

        System.out.println(
                "=========================================="
        );

        // =====================================================
        // SAVE TO FIRESTORE
        // =====================================================

        complaintDAO.saveComplaint(
                complaint
        );

        System.out.println(
                "Complaint saved successfully."
        );

        return complaint;
    }

    // =========================================================
    // GET MY COMPLAINTS BY EMAIL
    // =========================================================

    public List<ComplaintModel> getMyComplaints(
            String email)
            throws Exception {

        if (email == null ||
                email.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Email is required."
            );
        }

        return complaintDAO.getComplaintsByEmail(
                email.trim().toLowerCase()
        );
    }

    // =========================================================
    // GET ALL COMPLAINTS
    // =========================================================

    public List<ComplaintModel> getAllComplaints()
            throws Exception {

        return complaintDAO.getAllComplaints();
    }

    // =========================================================
    // GET COMPLAINTS BY FLAT
    // =========================================================

    public List<ComplaintModel> getComplaintsByFlat(
            String flatNumber)
            throws Exception {

        if (flatNumber == null ||
                flatNumber.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Flat number is required."
            );
        }

        return complaintDAO.getComplaintsByFlat(
                flatNumber.trim()
        );
    }

    // =========================================================
    // GET COMPLAINTS BY SOCIETY
    // =========================================================
    /*
     * Useful for Secretary.
     *
     * Secretary can fetch complaints belonging
     * only to his/her society.
     */

    public List<ComplaintModel> getComplaintsBySociety(
            String society)
            throws Exception {

        if (society == null ||
                society.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Society is required."
            );
        }

        return complaintDAO.getComplaintsBySociety(
                society.trim()
        );
    }

    // =========================================================
    // UPDATE STATUS
    // =========================================================

    public void updateStatus(
            String email,
            String complaintId,
            String status)
            throws Exception {

        // =====================================================
        // VALIDATE EMAIL
        // =====================================================

        if (email == null ||
                email.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Email is required."
            );
        }

        // =====================================================
        // VALIDATE COMPLAINT ID
        // =====================================================

        if (complaintId == null ||
                complaintId.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Complaint ID is required."
            );
        }

        // =====================================================
        // VALIDATE STATUS
        // =====================================================

        if (status == null ||
                status.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Status is required."
            );
        }

        // =====================================================
        // NORMALIZE
        // =====================================================

        email =
                email.trim().toLowerCase();

        complaintId =
                complaintId.trim();

        status =
                status.trim();

        // =====================================================
        // UPDATE
        // =====================================================

        complaintDAO.updateStatus(
                email,
                complaintId,
                status
        );

        System.out.println(
                "Complaint status updated successfully."
        );

        System.out.println(
                "Email      : " + email
        );

        System.out.println(
                "ComplaintID: " + complaintId
        );

        System.out.println(
                "Status     : " + status
        );
    }
}