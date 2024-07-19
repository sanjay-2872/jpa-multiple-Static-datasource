package com.npst.multipledatabases.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


import java.time.LocalDateTime;


@Data
@ToString
@Builder
public class BookingDto {
    @NotNull(message = "createdBy can not be null")
    private Long createdBy;
    @Size(min = 30, max = 200, message = "pickupAddress must be between 10 and 200 characters")
    private String pickupAddress;
    @Size(min = 30, max = 200, message = "dropAddress must be between 10 and 200 characters")
    private String dropAddress;
    private String bookingAmount;
    @Email(message = "Email should be valid")
    private String emailAddress;
    @Future
    private LocalDateTime dropData;
}
