package com.cars24.dao;


import com.cars24.data.entities.InvoicesEntity;

import java.util.List;

public interface InvoiceDao {
    public void createInvoice();
    public boolean deleteInvoice();
    public InvoicesEntity selectInvoiceById();
    public boolean updateInvoiceById();
    public List<InvoicesEntity> selectInvoices();
}
