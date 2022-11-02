package org.julucin.upador_arquivo_core.use_cases.upload_file.primary_ports.factories;

import org.julucin.upador_arquivo_core.use_cases.upload_file.UploadFileUseCaseActivity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UploadFilePrimaryPortFactoryTest {

    @Mock
    UploadFileUseCaseActivity uploadFileUseCaseActivity;

    @Test
    @DisplayName("Should Return Not Null Instance Of New Primary Port When Making Method Is Called")
    void shouldReturnNotNullInstanceOfNewPrimaryPortWhenMakingMethodIsCalled(){
        var factory = new UploadFilePrimaryPortFactory();
        Assertions.assertNotNull(factory.makePrimaryPort(this.uploadFileUseCaseActivity));
    }

}
