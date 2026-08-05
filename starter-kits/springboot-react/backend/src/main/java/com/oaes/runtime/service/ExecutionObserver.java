package com.oaes.runtime.service;

import com.oaes.runtime.model.ExecutionResult;
import org.springframework.stereotype.Service;

@Service
public class ExecutionObserver {

    public boolean shouldRetry(ExecutionResult result) {

        return !result.isSuccess();

    }

}