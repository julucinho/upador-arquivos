package org.julucin.upador_arquivo_core.use_cases.upload_file.impl.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FileUploadRuntimeExceptionTest {

    private final static String FILE_NAME = "aoksdasokdasdok.txt";
    private final static String MESSAGE = "tu vens, tu vens...";
    private final static String EXPECTED_FULL_MESSAGE = String.format(
            "Something wrong happened while trying to upload file '%s'. Error message: '%s'",
            FILE_NAME,
            MESSAGE
    );

    @Test
    @DisplayName("Should instantiate with message built as expected when normally instantiated")
    void shouldInstantiateWithMessageBuiltAsExpectedWhenNormallyInstantiated(){
        var exception = new FileUploadRuntimeException(MESSAGE, FILE_NAME);
        Assertions.assertEquals(EXPECTED_FULL_MESSAGE, exception.getMessage());
    }

}
