package org.julucin.upador_arquivo_core.use_cases.upload_file.impl;

import org.julucin.upador_arquivo_core.entities.FileProperties;
import org.julucin.upador_arquivo_core.use_cases.upload_file.UploadFileUseCaseActivity;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.contracts.FileUploader;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.exceptions.FilePropertiesNotProvidedException;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.exceptions.FileUploadRuntimeException;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.exceptions.FileUploaderNotProvidedException;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.secondary_ports.FilePropertiesRetrieverSecondaryPort;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.secondary_ports.FileUploaderProviderSecondaryPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;

@ExtendWith(MockitoExtension.class)
class UploadFileUseCaseActivityImplTest {

    @Mock
    FileUploaderProviderSecondaryPort fileUploaderProviderSecondaryPort;
    @Mock
    FilePropertiesRetrieverSecondaryPort filePropertiesRetrieverSecondaryPort;
    @Mock
    FileProperties fileProperties;
    @Mock
    File file;
    @Mock
    FileUploader fileUploader;
    UploadFileUseCaseActivity uploadFileUseCaseActivity;

    @BeforeEach
    void setUp(){
        this.uploadFileUseCaseActivity = new UploadFileUseCaseActivityImpl(
                this.fileUploaderProviderSecondaryPort,
                this.filePropertiesRetrieverSecondaryPort
        );
    }

    @Test
    @DisplayName("Should run smoothly well when everything cooperates")
    void shouldRunSmoothlyWhenEverythingCooperates(){
        Mockito.when(this.filePropertiesRetrieverSecondaryPort.usePort()).thenReturn(this.fileProperties);
        Mockito.when(this.fileProperties.loadFile()).thenReturn(this.file);
        Mockito.when(this.fileUploaderProviderSecondaryPort.usePort()).thenReturn(this.fileUploader);
        Mockito.doNothing().when(this.fileUploader).upload(this.file);
        Assertions.assertDoesNotThrow(this.uploadFileUseCaseActivity::execute);
        Mockito.verify(this.filePropertiesRetrieverSecondaryPort, Mockito.times(1)).usePort();
        Mockito.verify(this.fileUploaderProviderSecondaryPort, Mockito.times(1)).usePort();
        Mockito.verify(this.fileUploader, Mockito.times(1)).upload(ArgumentMatchers.any());
        Mockito.verify(this.fileProperties, Mockito.times(1)).loadFile();
    }

    @Test
    @DisplayName("Should throw FileUploadRuntimeException when FileUploader throws an exception")
    void shouldThrowFileUploadRuntimeExceptionWhenFileUploaderThrowsException(){
        Mockito.when(this.filePropertiesRetrieverSecondaryPort.usePort()).thenReturn(this.fileProperties);
        Mockito.when(this.fileProperties.loadFile()).thenReturn(this.file);
        Mockito.when(this.file.getName()).thenReturn("someName.txt");
        Mockito.when(this.fileUploaderProviderSecondaryPort.usePort()).thenReturn(this.fileUploader);
        Mockito.doThrow(new RuntimeException("")).when(this.fileUploader).upload(this.file);
        Assertions.assertThrows(FileUploadRuntimeException.class, this.uploadFileUseCaseActivity::execute);
    }

    @Test
    @DisplayName("Should throw FileUploaderNotProvidedException when FileUploaderProviderSecondaryPort returns null")
    void shouldThrowFileUploaderNotProvidedExceptionWhenFileUploaderProviderSecondaryPortReturnsNull(){
        Mockito.when(this.filePropertiesRetrieverSecondaryPort.usePort()).thenReturn(this.fileProperties);
        Mockito.when(this.fileProperties.loadFile()).thenReturn(this.file);
        Mockito.when(this.fileUploaderProviderSecondaryPort.usePort()).thenReturn(null);
        Assertions.assertThrows(FileUploaderNotProvidedException.class, this.uploadFileUseCaseActivity::execute);
    }

    @Test
    @DisplayName("Should throw FilePropertiesNotProvidedException when FilePropertiesRetrieverSecondaryPort returns null")
    void shouldThrowFilePropertiesNotProvidedExceptionWhenFilePropertiesRetrieverSecondaryPortReturnsNull(){
        Mockito.when(this.filePropertiesRetrieverSecondaryPort.usePort()).thenReturn(null);
        Assertions.assertThrows(FilePropertiesNotProvidedException.class, this.uploadFileUseCaseActivity::execute);
    }
}
