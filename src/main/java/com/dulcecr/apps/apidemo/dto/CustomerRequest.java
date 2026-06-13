package com.dulcecr.apps.apidemo.dto;

import java.time.LocalDate;

public record CustomerRequest (
        String firstName,
        String lastName,
        LocalDate birthOfDate
) {
}
