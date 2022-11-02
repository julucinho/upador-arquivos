package org.julucin.upador_arquivo_core.entities.impl;

import org.julucin.upador_arquivo_core.entities.FileProperties;
import org.julucin.upador_arquivo_core.entities.impl.exceptions.NoSuchFileRuntimeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FilePropertiesImplTest {

    private final static String INITIAL_VALUE = "./src/test/java/org/julucin/upador_arquivo_core/entities/impl/test.txt";
    private final FileProperties fileProperties = new FilePropertiesImpl();

    @BeforeEach
    void setUp(){
        this.fileProperties.setFullPathToFile(INITIAL_VALUE);
    }

    @Test
    @DisplayName("Should get value when getter is called")
    void shouldGetValueWhenGetterIsCalled(){
        Assertions.assertEquals(INITIAL_VALUE, this.fileProperties.getFullPathToFile());
    }

    @Test
    @DisplayName("Should set value when setter is called")
    void shouldSetValueWhenSetterIsCalled(){
        var value = "VALUE";
        this.fileProperties.setFullPathToFile(value);
        Assertions.assertEquals(value, this.fileProperties.getFullPathToFile());
    }

    @Test
    @DisplayName("Should load this file when load method is called")
    void shouldLoadThisFileWhenLoadMethodIsCalled(){
        var file = this.fileProperties.loadFile();
        Assertions.assertTrue(file.exists());
    }

    @Test
    @DisplayName("Should not throw any exception when load method is called")
    void shouldNotThrowAnyExceptionWhenLoadMethodIsCalled(){
        Assertions.assertDoesNotThrow(this.fileProperties::loadFile);
    }

    @Test
    @DisplayName("Should throw exception when load method is called with nonexistent path")
    void shouldThrowExceptionWhenLoadMethodIsCalledWithNonexistentPath(){
        this.fileProperties.setFullPathToFile("./adocica-meu-amor.txt");
        Assertions.assertThrows(NoSuchFileRuntimeException.class, this.fileProperties::loadFile);
    }

}
