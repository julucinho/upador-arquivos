package org.julucin.upador_arquivo_plugins.use_cases.upload_file.secondary_port_adapters.dtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PropertiesOfBucketDtoTest {

    @Test
    @DisplayName("Should Retrieve Same Values Parameterized Via Required Args Constructor")
    void shouldRetrieveSameValuesParameterizedViaRequiredArgsConstructor(){
        var bucketName = "UHU";
        var desiredFileName = "IHA";
        var object = new PropertiesOfBucketDto(bucketName, desiredFileName);
        Assertions.assertEquals(bucketName, object.getBucketName());
        Assertions.assertEquals(desiredFileName, object.getDesiredFileName());
    }

}
