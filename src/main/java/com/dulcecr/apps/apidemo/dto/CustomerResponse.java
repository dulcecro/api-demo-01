package com.dulcecr.apps.apidemo.dto;

import java.time.LocalDate;
import java.util.UUID;

public record CustomerResponse (
        UUID id,
        String firstName,
        String lastName,
        LocalDate birthOfDate
) {
}
