package org.bsim.intern.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class TransactionsEntity implements Serializable {
    private static final long serialVersionUID= 7843306625588994501L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // dimulai dari angka 1 penambahan 1
    private long id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = false)
    private long amount;

    @Column(nullable = false)
    private LocalDateTime tanggal;

    private String note;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id")
    private WalletsEntity walletsEntity;

    @Column(nullable = false)
    private String transactionsId;

    public String getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(String transactionsId) {
        this.transactionsId = transactionsId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public LocalDateTime getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDateTime tanggal) {
        this.tanggal = tanggal;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public WalletsEntity getWalletsEntity() {
        return walletsEntity;
    }

    public void setWalletsEntity(WalletsEntity walletsEntity) {
        this.walletsEntity = walletsEntity;
    }
}
