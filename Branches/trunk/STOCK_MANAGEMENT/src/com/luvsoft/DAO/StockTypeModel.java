package com.luvsoft.DAO;

import java.util.List;

import com.luvsoft.entities.Stocktype;

public class StockTypeModel {
    EntityManagerDAO entityManager = new EntityManagerDAO();
    public List<Stocktype> getData() {
        return entityManager.findAll(Stocktype.getEntityname());
    }
}