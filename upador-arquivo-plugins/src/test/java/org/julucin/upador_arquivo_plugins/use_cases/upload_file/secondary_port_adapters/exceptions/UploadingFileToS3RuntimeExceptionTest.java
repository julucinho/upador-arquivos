package org.julucin.upador_arquivo_plugins.use_cases.upload_file.secondary_port_adapters.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UploadingFileToS3RuntimeExceptionTest {

    @Test
    @DisplayName("Should Return Expected Message When Instantiated")
    void shouldReturnExpectedMessageWhenInstantiated(){
        var parameterOne = "parameter one";
        var parameterTwo = "parameter two";
        var expectedMessage = String.format(
                "Something went wrong while trying to upload file '%s' to S3. " +
                "See the following retrieved message from service: '%s'",
                parameterOne,
                parameterTwo
        );
        var exception = new UploadingFileToS3RuntimeException(parameterOne, parameterTwo);
        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

}
