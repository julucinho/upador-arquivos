package org.julucin.upador_arquivo_plugins.use_cases.upload_file.primary_port_initializer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UploadFilePrimaryPortInitializerTest {

    @Test
    @DisplayName("Should Return Not Null Instance Of UploadFilePrimaryPort")
    void shouldReturnNotNullInstanceOfUploadFilePrimaryPort(){
        var instance = UploadFilePrimaryPortInitializer.initializeUploadFilePrimaryPort();
        Assertions.assertNotNull(instance);
    }

    @Test
    @DisplayName("Should Not Throw Anything When Instantiating UploadFilePrimaryPort")
    void shouldNotThrowAnythingWhenInstantiatingUploadFilePrimaryPort(){
        Assertions.assertDoesNotThrow(UploadFilePrimaryPortInitializer::initializeUploadFilePrimaryPort);
    }

}
