package com.society.service.resident_service;


  
import com.society.dao.Resident_dao.*;
import com.society.model.Resident_model.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class VisitorService {

    private final VisitorDAO visitorDAO;

    public VisitorService(VisitorDAO visitorDAO) {
        this.visitorDAO = visitorDAO;
    }

    // CREATE AND SAVE VISITOR
    public VisitorModel createVisitor(
            String visitorName,
            String phoneNumber,
            String purpose,
            String visitDate,
            String visitTime,
            String flatNumber,
            String gate,
            String vehicleNumber
    ) throws Exception {

        VisitorModel visitor = new VisitorModel();

        // Unique Firestore document ID
        visitor.setId(
                UUID.randomUUID().toString()
        );

        visitor.setVisitorName(visitorName);
        visitor.setPhoneNumber(phoneNumber);
        visitor.setPurpose(purpose);
        visitor.setVisitDate(visitDate);
        visitor.setVisitTime(visitTime);
        visitor.setFlatNumber(flatNumber);
        visitor.setGate(gate);
        visitor.setVehicleNumber(vehicleNumber);

        // Invitation status
        visitor.setStatus("APPROVED");

        // Unique QR token
        visitor.setQrToken(
                UUID.randomUUID()
                        .toString()
                        .replace("-", "")
        );

        visitor.setUsed(false);

        visitor.setCreatedAt(new Date());

        // Save to Firestore
        visitorDAO.saveVisitor(visitor);

        return visitor;
    }

    // GET TODAY'S VISITORS
    public List<VisitorModel> getTodayVisitors()
            throws Exception {

        return visitorDAO.getVisitorsByDate(
                LocalDate.now().toString()
        );
    }

    // VERIFY QR
    public VisitorModel verifyQR(String qrToken)
            throws Exception {

        VisitorModel visitor =
                visitorDAO.getVisitorByQrToken(qrToken);

        if (visitor == null) {
            throw new Exception("Invalid QR code.");
        }

        if (!"APPROVED".equalsIgnoreCase(
                visitor.getStatus()
        )) {
            throw new Exception(
                    "Visitor is not approved."
            );
        }

        if (visitor.isUsed()) {
            throw new Exception(
                    "This QR code has already been used."
            );
        }

        if (!LocalDate.now()
                .toString()
                .equals(visitor.getVisitDate())) {

            throw new Exception(
                    "This QR code is not valid today."
            );
        }

        return visitor;
    }

    // ALLOW ENTRY
    public void allowEntry(String visitorId)
            throws Exception {

        visitorDAO.markVisitorAsUsed(visitorId);
    }
}


