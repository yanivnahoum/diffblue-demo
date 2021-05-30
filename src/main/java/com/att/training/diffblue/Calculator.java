package com.att.training.diffblue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class Calculator {

    int add(int x, int y) {
        return x + y;
    }

    int abs(int value) {
        if (value < 0) {
            return -value;
        }
        return value;
    }

    int increment(int x) {
        return ++x;
    }

    int decrement(int x) {
        return --x;
    }

    int addAndSet(int x, int y, Repository repository) {
        int result = x + y;
        repository.setResult(result);
        log.info("#addAndSet - got {}", result);
        return result;
    }
}
