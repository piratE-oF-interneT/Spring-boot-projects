package com.uber.dtos;

public class SignUpResponseDto {

    private String[] tokens = new String[2];

    public String[] getTokens() {
        return tokens;
    }

    public void setTokens(String[] tokens) {
        this.tokens = tokens;
    }
}
