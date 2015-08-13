package com.cabtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "BILLING", catalog = "cab")
public class Billing implements Serializable {

    private static final long serialVersionUID = 7895139095426977088L;

    @Id
    @Column(name = "BILLING_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billingId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ASSIGNMENT_ID", nullable = false)
    private Assignment assignment;

    @Column(name = "AMOUNT")
    private int amount;

    @Column(name = "IS_PROCESSED")
    private char isProcessed;

    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isProcessed() {
        return isProcessed == '1';
    }

    public void setIsProcessed(boolean isProcessed) {
        this.isProcessed = isProcessed ? '1' : '0';
    }
}
