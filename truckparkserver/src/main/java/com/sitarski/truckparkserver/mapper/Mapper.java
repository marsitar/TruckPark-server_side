package com.sitarski.truckparkserver.mapper;

public interface Mapper<T, U> {

    T convertToDto(U arg);
    U convertToEntity(T arg);
    default U updateEntity(T arg) {
        return null;
    };
}
