package com.acme.hotel_world_api;

import com.acme.hotel_world_api.security.domain.model.Guest;
import com.acme.hotel_world_api.security.domain.repository.GuestRepository;
import com.acme.hotel_world_api.security.domain.service.GuestService;
import com.acme.hotel_world_api.security.service.GuestServiceImpl;
import com.acme.hotel_world_api.shared.exception.ResourceNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class GuestServiceImplTest {
    @MockBean
    private GuestRepository guestRepository;
    @Autowired
    private GuestService guestService;

    @TestConfiguration
    static class GuestServiceLmplTestConfiguration{
        @Bean
        public GuestService guestService(){
            return new GuestServiceImpl();
        }
    }

    //Test Working
    @Test
    @DisplayName("When Get Guess By Id")
    public void WhenGetGuessById(){
        // Arrange
        long Id = 1;
        Guest guest = new Guest().setId(Id);
        when(guestRepository.findById(Id)).thenReturn(Optional.of(guest));

        //Act
        Guest foundGuest = guestService.getGuestById(Id);

        //Assert
        assertThat(foundGuest.getId()).isEqualTo(Id);
    }

}
