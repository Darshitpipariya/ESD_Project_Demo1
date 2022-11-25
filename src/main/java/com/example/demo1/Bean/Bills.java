package com.example.demo1.Bean;


import jakarta.persistence.*;

@Entity
@Table(name = "Bills")
public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private int bill_id;
    @Column(name="Description")
    private String Description;
    @Column(name="amount",nullable = false)
    private int amount;
    @Column(name = "bill_date",nullable = false)
    private String bill_date;
    @ManyToOne
    @JoinColumn(name="student_id")
    private Students students;

    public Bills() {
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getBill_date() {
        return bill_date;
    }

    public void setBill_date(String bill_date) {
        this.bill_date = bill_date;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Bills{" +
                "Description='" + Description + '\'' +
                ", amount=" + amount +
                ", bill_date='" + bill_date + '\'' +
                '}';
    }
}
