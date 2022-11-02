package org.julucin.upador_arquivo_plugins.use_cases.upload_file.s3_client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class S3ClientInitializerTest {

    @Test
    @DisplayName("Should Not Return Null Instance Of S3Client")
    void shouldNotReturnNullInstanceOfS3Client(){
        Assertions.assertNotNull(S3ClientInitializer.initializeClient());
    }

}
