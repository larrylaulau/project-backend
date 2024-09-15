package com.fsse2406.project.data.transactionProduct.dto.response;

public class TransactionSuccessResponseDto {
    private String result;

    public TransactionSuccessResponseDto() {
        setResult("success");
    }

    public String getResult() {
        return result;
    }

    private void setResult(String result) {
        this.result = result;
    }
}
