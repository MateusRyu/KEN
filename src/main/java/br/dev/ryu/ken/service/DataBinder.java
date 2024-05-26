package br.dev.ryu.ken.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataBinder implements IDataBinder {
    private final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public <T> T bindJsonToClass(String json, Class<T> targetClass) {
        try {
            return MAPPER.readValue(json, targetClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
