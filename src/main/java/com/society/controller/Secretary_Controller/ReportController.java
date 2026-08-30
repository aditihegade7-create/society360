package com.society.controller.Secretary_Controller;

import java.util.List;

import com.society.dao.Secretary_dao.ReportDao;
import com.society.dao.Secretary_dao.ReportDaoImpl;
import com.society.model.Secretary_model.Report;

public class ReportController {

    private ReportDao reportDao;

    public ReportController() {

        reportDao =
                new ReportDaoImpl();
    }

    // ============================================================
    // GET ALL REPORTS
    // ============================================================

    public List<Report> getAllReports() {

        return reportDao.getAllReports();
    }
}