package com.example.bootcampdemo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T>{

    private String message;
    private T result;
    public Result(String message) {
        this.message = message;
    }
}
