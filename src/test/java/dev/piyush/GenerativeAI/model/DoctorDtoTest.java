package dev.piyush.GenerativeAI.model;

//Import Junit 5
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import dev.piyush.GenerativeAI.model.dto.DoctorDto;

public class DoctorDtoTest {

    @Test
    public void testDoctorDto() {
        DoctorDto doctorDto = new DoctorDto();
        assertNotNull(doctorDto);
    }


    @Test
    public void testDoctorDtoWithParameters() {
        DoctorDto doctorDto = DoctorDto.builder()
                        .firstName("XXXXXX")
                .lastName("XXXXX")
                        .specialization("Blood").
                build();
        assertEquals("Dr. Piyush", doctorDto.getFirstName());
        assertEquals("Blood", doctorDto.getSpecialization());
    }
}
