package org.bsim.intern.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UserTBL")
@SequenceGenerator(name = "seqUSR", initialValue = 100, allocationSize = 10)
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 6764864712068651621L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUSR")
    private long id;

    @Column(nullable = false)
    private String userid;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WalletsEntity> walletsentity = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<WalletsEntity> getWalletsentity() {
        return walletsentity;
    }

    public void setWalletsentity(List<WalletsEntity> walletsentity) {
        this.walletsentity = walletsentity;
    }
}
