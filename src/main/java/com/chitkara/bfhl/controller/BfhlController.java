package com.chitkara.bfhl.controller;

import com.chitkara.bfhl.service.AiService;
import com.chitkara.bfhl.util.MathUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping
public class BfhlController {

    @Value("${official.email}")
    private String email;

    private final AiService aiService;

    public BfhlController(AiService aiService) {
        this.aiService = aiService;
    }


    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok(Map.of(
                "is_success", true,
                "official_email", email
        ));
    }

    @PostMapping("/bfhl")
    public ResponseEntity<?> bfhl(@RequestBody Map<String, Object> body) {

        if (body.size() != 1) {
            return ResponseEntity.badRequest().body(Map.of(
                    "is_success", false,
                    "error", "Only one key allowed"
            ));
        }

        String key = body.keySet().iterator().next();
        Object value = body.get(key);
        Object data;

        try {
            switch (key) {

                case "fibonacci" -> {
                    int n = (int) value;
                    List<Integer> fib = new ArrayList<>(List.of(0, 1));
                    for (int i = 2; i < n; i++)
                        fib.add(fib.get(i - 1) + fib.get(i - 2));
                    data = fib.subList(0, n);
                }

                case "prime" -> {
                    List<Integer> nums = (List<Integer>) value;
                    data = nums.stream()
                            .filter(MathUtil::isPrime)
                            .toList();
                }

                case "lcm" -> {
                    List<Integer> nums = (List<Integer>) value;
                    data = nums.stream()
                            .reduce(MathUtil::lcm)
                            .orElse(0);
                }

                case "hcf" -> {
                    List<Integer> nums = (List<Integer>) value;
                    data = nums.stream()
                            .reduce(MathUtil::gcd)
                            .orElse(0);
                }

                case "AI" -> {
                    data = aiService.askAI(value.toString());
                }

                default -> throw new RuntimeException("Invalid key");
            }

            return ResponseEntity.ok(Map.of(
                    "is_success", true,
                    "official_email", email,
                    "data", data
            ));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of(
                    "is_success", false,
                    "error", e.getMessage()
            ));
        }
    }
}
