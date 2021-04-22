package org.bsim.intern.ui.model.response;

import org.bsim.intern.shared.dto.WalletsDTO;

import java.time.LocalDateTime;

public class TransactionsResponse {

    private String name;
    private long amount;
    private LocalDateTime tanggal;
    private String note;
    private boolean isDeleted = false;
    private WalletsDTO walletsDTO;
    private String transactionsId;

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

    public WalletsDTO getWalletsDTO() {
        return walletsDTO;
    }

    public void setWalletsDTO(WalletsDTO walletsDTO) {
        this.walletsDTO = walletsDTO;
    }

    public String getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(String transactionsId) {
        this.transactionsId = transactionsId;
    }
}
