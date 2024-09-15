package com.fsse2406.project.data.transcation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2406.project.data.cartItem.status.TranscationStatus;
import com.fsse2406.project.data.transactionProduct.domainObject.TransactionProductResponseData;
import com.fsse2406.project.data.transactionProduct.dto.response.TransactionProductResponseDto;
import com.fsse2406.project.data.transcation.domainObject.TransactionResponseData;

import java.beans.BeanInfo;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionResponseDto {

    private Integer tid;

    @JsonProperty("buyer_uid")
    private Integer buyerUid;

    private LocalDateTime dateTime;

    private TranscationStatus status;

    private BigDecimal total;

    List<TransactionProductResponseDto> items = new ArrayList<>();

    public TransactionResponseDto(TransactionResponseData data){
        this.tid = data.getTid();
        this.buyerUid = data.getUser().getUid();
        this.dateTime = data.getDateTime();
        this.status = data.getStatus();
        this.total = data.getTotal();
        setItems(data);
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getBuyerUid() {
        return buyerUid;
    }

    public void setBuyerUid(Integer buyerUid) {
        this.buyerUid = buyerUid;
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

    public List<TransactionProductResponseDto> getItems() {
        return items;
    }

    public void setItems(List<TransactionProductResponseDto> items) {
        this.items = items;
    }

    public void setItems(TransactionResponseData data){
        for(TransactionProductResponseData item : data.getTransactionProductList()){
            this.items.add(new TransactionProductResponseDto(item));
        }
    }
}
