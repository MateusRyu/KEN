package br.dev.ryu.ken.service;

public interface IDataBinder {
    <T> T bindJsonToClass(String json, Class<T> targetClass);
}
