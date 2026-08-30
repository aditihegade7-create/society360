package com.society.controller.Secretary_Controller;

import java.util.List;

import com.society.dao.Secretary_dao.NoticeDao;
import com.society.model.Secretary_model.Notice;

public class NoticeController {

    private NoticeDao noticeDao;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public NoticeController() {

        noticeDao = new NoticeDao();
    }

    // =====================================================
    // ADD NOTICE
    // =====================================================

    public boolean addNotice(
            String title,
            String description,
            String date,
            String status) {

        Notice notice =
                new Notice(
                        title,
                        description,
                        date,
                        status
                );

        return noticeDao.addNotice(notice);
    }

    // =====================================================
    // GET ALL NOTICES
    // =====================================================

    public List<Notice> getAllNotices() {

        return noticeDao.getAllNotices();
    }
}