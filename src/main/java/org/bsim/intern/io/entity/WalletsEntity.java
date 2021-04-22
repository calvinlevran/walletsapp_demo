package org.bsim.intern.io.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "walletsTBL")
@SequenceGenerator(name = "seqwallets", initialValue = 100, allocationSize = 10)
public class WalletsEntity implements Serializable {
    private static final long serialVersionUID= 8175946289776595045L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqwallets" )
    private long id;

    @Column(nullable = false)
    private String walletId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long balance;

    @Column(nullable = false)
    private String noHP;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private UserEntity user;

    @OneToMany(mappedBy = "walletsEntity")
    private List<TransactionsEntity> transactionsEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<TransactionsEntity> getTransactionsEntity() {
        return transactionsEntity;
    }

    public void setTransactionsEntity(List<TransactionsEntity> transactionsEntity) {
        this.transactionsEntity = transactionsEntity;
    }
}
