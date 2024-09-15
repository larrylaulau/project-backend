package com.fsse2406.project.data.transcation.entity;

import com.fsse2406.project.data.cartItem.status.TranscationStatus;
import com.fsse2406.project.data.user.entity.UserEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name= "transcation")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    @ManyToOne
    @JoinColumn(name= "buyer_uid", nullable = false)
    private UserEntity user;

    @Column (nullable = false)
    private LocalDateTime dateTime;

    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private TranscationStatus status;

    @Column (nullable = false)
    private BigDecimal total;

    public TransactionEntity() {
    }

    public TransactionEntity(UserEntity user){
        this.user = user;
        this.dateTime = LocalDateTime.now();
        this.status = TranscationStatus.PREPARE;
        this.total = BigDecimal.ZERO;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public TranscationStatus getStatus() {
        return status;
    }

    public void setStatus(TranscationStatus status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
