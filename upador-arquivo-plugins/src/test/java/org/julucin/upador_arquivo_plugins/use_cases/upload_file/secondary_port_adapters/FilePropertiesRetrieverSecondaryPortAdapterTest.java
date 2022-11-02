package org.julucin.upador_arquivo_plugins.use_cases.upload_file.secondary_port_adapters;

import org.julucin.upador_arquivo_plugins.use_cases.upload_file.env_var_keys.UploadFilesUseCaseEnvVarRetriever;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FilePropertiesRetrieverSecondaryPortAdapterTest {

    @Test
    @DisplayName("Should Return Not Null Instance Of FileProperties Entity")
    void shouldReturnNotNullInstanceOfFilePropertiesEntity(){
        Assertions.assertNotNull(new FilePropertiesRetrieverSecondaryPortAdapter().usePort());
    }

    @Test
    @DisplayName("Should Properly Set Values To The FileProperties Object")
    void shouldProperlySetValuesToTheFilePropertiesObject(){
        var fullPathToFile = UploadFilesUseCaseEnvVarRetriever.getFullPathToFile();
        var fileProperties = new FilePropertiesRetrieverSecondaryPortAdapter().usePort();
        Assertions.assertEquals(fullPathToFile, fileProperties.getFullPathToFile());
    }

}
