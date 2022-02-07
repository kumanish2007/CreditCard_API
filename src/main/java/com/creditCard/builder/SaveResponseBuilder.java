package com.creditCard.builder;

import com.creditCard.entity.CreditCard;
import com.creditCard.response.SaveResponseDTO;

public class SaveResponseBuilder {
    private SaveResponseDTO saveResponseDTO;

    public SaveResponseBuilder() {
        this.saveResponseDTO = new SaveResponseDTO();
    }

    public SaveResponseBuilder withCode(String code){
        this.saveResponseDTO.setResponseCode(code);
        return this;
    }

    public SaveResponseBuilder withMessage(String message){
        this.saveResponseDTO.setResponseMessage(message);
        return this;
    }

    public SaveResponseDTO build(){
        return saveResponseDTO;
    }
}
