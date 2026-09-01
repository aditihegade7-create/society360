package com.society.dao.Secretary_dao;

import java.util.List;

import com.society.model.Secretary_model.Resident;

public interface ResidentDao {

    boolean addResident(Resident resident);

    List<Resident> getAllResidents();

    Resident getResidentByEmail(String email);
}