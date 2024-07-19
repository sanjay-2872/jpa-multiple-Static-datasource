package com.npst.multipledatabases.mapper;

import com.npst.multipledatabases.dto.BookingDto;
import com.npst.multipledatabases.model.db1.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    Booking mapBookingEntity(BookingDto bookingDto);
}
