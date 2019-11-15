package com.sitarski.truckparkserver.service.mapper;

public interface Mapper<T, U> {

    T convertToDto(U arg);

    U convertToEntity(T arg);
}
