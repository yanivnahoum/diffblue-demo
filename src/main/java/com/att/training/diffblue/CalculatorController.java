package com.att.training.diffblue;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calc")
@RequiredArgsConstructor
class CalculatorController {

    private final Calculator calculator;

    @GetMapping  ("add")
    int add(@RequestParam int x, @RequestParam int y) {
        return calculator.add(x, y);
    }

    @GetMapping  ("abs")
    int abs(@RequestParam int value) {
        return calculator.abs(value);
    }
}
