package com.cabtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "SETTLEMENT", catalog = "cab")
public class SettlementAggregate implements Serializable {

    private static final long serialVersionUID = 7895139095426977088L;

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "RECEIVER_ID")
    private int receiverId;

    @Column(name = "RECEIVER_TYPE")
    private String receiverType;

    @Column(name = "FROM_DATE")
    private Timestamp fromDate;

    @Column(name = "TO_DATE")
    private Timestamp toDate;

    @Column(name = "AMOUNT")
    private double amount;

    @Column(name = "PAID")
    private boolean paid;

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "SettlementAggregate{" +
                "id=" + id +
                ", receiverId=" + receiverId +
                ", receiverType='" + receiverType + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", amount=" + amount +
                ", paid=" + paid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SettlementAggregate that = (SettlementAggregate) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
