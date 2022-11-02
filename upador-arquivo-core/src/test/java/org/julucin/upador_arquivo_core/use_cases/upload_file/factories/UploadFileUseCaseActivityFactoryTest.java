package org.julucin.upador_arquivo_core.use_cases.upload_file.factories;

import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.secondary_ports.FilePropertiesRetrieverSecondaryPort;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.secondary_ports.FileUploaderProviderSecondaryPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UploadFileUseCaseActivityFactoryTest {

    @Mock
    FileUploaderProviderSecondaryPort fileUploaderProviderSecondaryPort;
    @Mock
    FilePropertiesRetrieverSecondaryPort filePropertiesRetrieverSecondaryPort;

    UploadFileUseCaseActivityFactory uploadFileUseCaseActivityFactory = new UploadFileUseCaseActivityFactory();

    @Test
    @DisplayName("Should not return null instance when making method is called")
    void shouldNotReturnNullInstanceWhenMakingMethodIsCalled(){
        var useCase = this.uploadFileUseCaseActivityFactory.makeUseCaseActivity(
                this.fileUploaderProviderSecondaryPort,
                this.filePropertiesRetrieverSecondaryPort
        );
        Assertions.assertNotNull(useCase);
    }

}
