package com.acme.hotel_world_api;
import com.acme.hotel_world_api.security.domain.model.HotelAdmin;
import com.acme.hotel_world_api.security.domain.repository.HotelAdminRepository;
import com.acme.hotel_world_api.security.domain.service.HotelAdminService;
import com.acme.hotel_world_api.security.service.HotelAdminServiceImpl;
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
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class HotelAdminServiceImplTest {
    @MockBean
    private HotelAdminRepository hotelAdminRepository;
    @Autowired
    private HotelAdminService hotelAdminService;

    @TestConfiguration
    static class HotelAdminServiceImplTestConfiguration{
        @Bean
        public HotelAdminService hotelAdminService(){
            return new HotelAdminServiceImpl();
        }
    }

    //Test
    @Test
    @DisplayName("When Get HotelAdmin By ID and HotelID")
    public void WhenGetHotelAdminByIdAndHotelId(){
        //Arrange
        long HotelId = 1;
        long AdminId = 1;
        HotelAdmin hotelAdmin = new HotelAdmin().setId(AdminId);
        when(hotelAdminRepository.findByIdAndHotelId(AdminId,HotelId)).thenReturn(Optional.of(hotelAdmin));
        //Act
        HotelAdmin foundHotelAdmin = hotelAdminService.getHotelAdminByIdAndHotelId(HotelId,AdminId);
        //Assert
        assertThat(foundHotelAdmin.getId()).isEqualTo(AdminId);
    }



}
