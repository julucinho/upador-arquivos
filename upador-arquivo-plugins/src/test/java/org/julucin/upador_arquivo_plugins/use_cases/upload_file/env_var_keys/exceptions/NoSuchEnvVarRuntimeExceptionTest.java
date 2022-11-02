package org.julucin.upador_arquivo_plugins.use_cases.upload_file.env_var_keys.exceptions;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NoSuchEnvVarRuntimeExceptionTest {

    @Test
    @DisplayName("Should Instantiate The Exception With The Expected Message")
    void shouldInstantiateTheExceptionWithTheExpectedMessage(){
        var envKey = "some_key";
        var expectedMessage = String.format("No such environment variable called '%s'", envKey);
        var exception = new NoSuchEnvVarRuntimeException(envKey);
        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

}
