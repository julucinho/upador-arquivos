package org.julucin.upador_arquivo_core.entities.factories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FilePropertiesFactoryTest {

    @Test
    @DisplayName("Should return non null instance of FileProperties object when makeFileProperties method is called")
    void shouldReturnNonNullInstanceOfFilePropertiesObjectWhenMakeFilePropertiesMethodIsCalled(){
        Assertions.assertNotNull(FilePropertiesFactory.makeFileProperties());
    }

}
