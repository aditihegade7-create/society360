package com.society.dao.Secretary_dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.Firestore;
import com.society.config.FirebaseConfig;
import com.society.model.Secretary_model.Report;

public class ReportDaoImpl implements ReportDao {

    private Firestore firestore;

    public ReportDaoImpl() {

        firestore = FirebaseConfig.getFirestore();
    }

    @Override
    public List<Report> getAllReports() {

        List<Report> reports = new ArrayList<>();

        try {

            // =====================================================
            // GUARD PORTAL
            // =====================================================

            fetchCollection(
                    reports,
                    "Guards",
                    "Guard"
            );

            // =====================================================
            // RESIDENT PORTAL
            // =====================================================

            fetchCollection(
                    reports,
                    "Residents",
                    "Resident"
            );

            // =====================================================
            // OWNER PORTAL
            // =====================================================

            fetchCollection(
                    reports,
                    "Owners",
                    "Owner"
            );

            // =====================================================
            // COMPLAINTS
            // =====================================================

            fetchCollection(
                    reports,
                    "Complaints",
                    "Complaint"
            );

            // =====================================================
            // MAINTENANCE
            // =====================================================

            fetchCollection(
                    reports,
                    "Maintenance",
                    "Maintenance"
            );

            // =====================================================
            // PAYMENTS
            // =====================================================

            fetchCollection(
                    reports,
                    "Payments",
                    "Payment"
            );

            // =====================================================
            // EVENTS
            // =====================================================

            fetchCollection(
                    reports,
                    "Events",
                    "Event"
            );

            // =====================================================
            // NOTICES
            // =====================================================

            fetchCollection(
                    reports,
                    "Notices",
                    "Notice"
            );

            // =====================================================
            // SOS
            // =====================================================

            fetchCollection(
                    reports,
                    "SOS",
                    "SOS Alert"
            );

            System.out.println(
                    "Total reports fetched: " +
                    reports.size()
            );

        } catch (Exception e) {

            System.out.println(
                    "Error fetching reports: " +
                    e.getMessage()
            );

            e.printStackTrace();
        }

        return reports;
    }

    // =============================================================
    // FETCH COLLECTION
    // =============================================================

    private void fetchCollection(
            List<Report> reports,
            String collectionName,
            String type) {

        try {

            ApiFuture<QuerySnapshot> future =
                    firestore
                            .collection(collectionName)
                            .get();

            QuerySnapshot snapshot =
                    future.get();

            for (DocumentSnapshot document :
                    snapshot.getDocuments()) {

                Map<String, Object> data =
                        document.getData();

                if (data == null) {
                    continue;
                }

                String title =
                        getValue(
                                data,
                                "title",
                                "name",
                                "residentName",
                                "ownerName",
                                "guardName",
                                "subject",
                                "eventName",
                                "noticeTitle"
                        );

                String details =
                        getValue(
                                data,
                                "description",
                                "details",
                                "message",
                                "reason",
                                "complaint",
                                "remarks"
                        );

                String date =
                        getValue(
                                data,
                                "date",
                                "createdDate",
                                "createdAt",
                                "eventDate",
                                "noticeDate"
                        );

                String status =
                        getValue(
                                data,
                                "status",
                                "paymentStatus",
                                "complaintStatus"
                        );

                // If no title found, use document ID
                if (title == null ||
                        title.trim().isEmpty()) {

                    title = document.getId();
                }

                if (details == null ||
                        details.trim().isEmpty()) {

                    details = "No details available";
                }

                if (date == null ||
                        date.trim().isEmpty()) {

                    date = "-";
                }

                if (status == null ||
                        status.trim().isEmpty()) {

                    status = "-";
                }

                Report report =
                        new Report(
                                collectionName,
                                type,
                                title,
                                details,
                                date,
                                status
                        );

                reports.add(report);
            }

        } catch (Exception e) {

            System.out.println(
                    "Unable to fetch collection " +
                    collectionName +
                    ": " +
                    e.getMessage()
            );
        }
    }

    // =============================================================
    // GET VALUE FROM DIFFERENT FIELD NAMES
    // =============================================================

    private String getValue(
            Map<String, Object> data,
            String... fieldNames) {

        for (String fieldName : fieldNames) {

            Object value =
                    data.get(fieldName);

            if (value != null) {

                return String.valueOf(value);
            }
        }

        return "";
    }
}