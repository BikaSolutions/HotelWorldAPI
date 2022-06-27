package com.acme.hotel_world_api;

import com.acme.hotel_world_api.system.domain.model.Hotel;
import com.acme.hotel_world_api.system.domain.model.Room;
import com.acme.hotel_world_api.system.domain.repository.HotelRepository;
import com.acme.hotel_world_api.system.domain.repository.RoomRepository;
import com.acme.hotel_world_api.system.domain.service.HotelService;
import com.acme.hotel_world_api.system.domain.service.RoomService;
import com.acme.hotel_world_api.system.service.RoomServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.*;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class RoomServiceImplTest {
    @MockBean
    private RoomRepository roomRepository;

    @MockBean
    private HotelRepository hotelRepository;

    @Autowired
    private RoomService roomService;

    @TestConfiguration
    static class RoomServiceImplTestConfiguration{
        @Bean
        public RoomService roomService(){
            return new RoomServiceImpl();
        }
    }

    //Test Working
    @Test
    @DisplayName("When Get Hotel By Id and RoomID")
    public void WhenGetHotelByIdAndRoomId() {
        //Arrange
        long hotelId = 1;
        long RoomId = 1;
        Room room = new Room().setId(RoomId);
        Hotel hotel= new Hotel().setId(hotelId);
        when(roomRepository.findByIdAndHotelId(RoomId,hotelId)).thenReturn(Optional.of(room));

        //Act
        Room foundRoom = roomService.getRoomByIdAndHotelId(hotelId, RoomId);

        //Assert
        assertThat(foundRoom.getId()).isEqualTo(RoomId);
    }
}










