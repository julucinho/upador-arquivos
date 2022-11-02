package org.julucin.upador_arquivo_plugins.use_cases.upload_file.lambda_handler;

import com.amazonaws.services.lambda.runtime.Context;
import lombok.extern.slf4j.Slf4j;
import org.julucin.upador_arquivo_core.use_cases.upload_file.primary_ports.UploadFilePrimaryPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

@Slf4j
@ExtendWith(MockitoExtension.class)
class LambdaHandlerTest {

    @Mock
    UploadFilePrimaryPort uploadFilePrimaryPort;

    @Test
    @DisplayName("Should Return Not Yay When Primary Port Throws Exception")
    void shouldReturnNotYayWhenPrimaryPortThrowsException(){
        Mockito.doThrow(new RuntimeException("some error message")).when(this.uploadFilePrimaryPort).usePort();
        var lambdaHandler = new LambdaHandler();
        lambdaHandler.setUploadFilePrimaryPort(this.uploadFilePrimaryPort);
        var response = lambdaHandler.handleRequest(new HashMap<>(), Mockito.mock(Context.class));
        Assertions.assertEquals("not yay", response);
    }

    @Test
    @DisplayName("Should Return Yay When Primary Port Does Not Throw Exception")
    void shouldReturnYayWhenPrimaryPortDoesNotThrowException(){
        Mockito.doNothing().when(this.uploadFilePrimaryPort).usePort();
        var lambdaHandler = new LambdaHandler();
        lambdaHandler.setUploadFilePrimaryPort(this.uploadFilePrimaryPort);
        var response = lambdaHandler.handleRequest(new HashMap<>(), Mockito.mock(Context.class));
        Assertions.assertEquals("yay", response);
    }

    @Test
    @DisplayName(
            "Should Not Have PrimaryPort Null After Calling The Handler Method When PrimaryPort Not Initialized " +
            "On Instantiation"
    )
    void shouldNotHavePrimaryPortNullAfterCallingTheHandlerMethodWhenPrimaryPortNotInitializedOnInstantiation(){
        var lambdaHandler = new LambdaHandler();
        try {
            lambdaHandler.handleRequest(new HashMap<>(), Mockito.mock(Context.class));
        } catch (Exception exception){
            log.info("Expected exception");
        }
        Assertions.assertNotNull(lambdaHandler.getUploadFilePrimaryPort());
    }
}
