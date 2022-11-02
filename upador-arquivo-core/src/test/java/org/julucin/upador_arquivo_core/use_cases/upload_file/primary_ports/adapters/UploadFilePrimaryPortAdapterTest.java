package org.julucin.upador_arquivo_core.use_cases.upload_file.primary_ports.adapters;

import org.julucin.upador_arquivo_core.use_cases.upload_file.UploadFileUseCaseActivity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UploadFilePrimaryPortAdapterTest {

    @Mock
    UploadFileUseCaseActivity uploadFileUseCaseActivity;

    @Test
    @DisplayName("Should Call Use Case Activity At Least Once")
    void shouldCallUseCaseActivityAtLeastOnce(){
        var primaryPort = new UploadFilePrimaryPortAdapter(this.uploadFileUseCaseActivity);
        Mockito.doNothing().when(this.uploadFileUseCaseActivity).execute();
        primaryPort.usePort();
        Mockito.verify(this.uploadFileUseCaseActivity, Mockito.times(1)).execute();
    }
}
