package org.julucin.upador_arquivo_plugins.use_cases.upload_file.secondary_port_adapters;

import org.julucin.upador_arquivo_plugins.use_cases.upload_file.secondary_port_adapters.FileUploaderProviderSecondaryPortAdapter.S3FileUploader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.File;

@ExtendWith(MockitoExtension.class)
class FileUploaderProviderSecondaryPortAdapterTest {

    @Test
    @DisplayName("Should Return Not Null Instance Of FileUploader")
    void shouldReturnNotNullInstanceOfFileUploader(){
        Assertions.assertNotNull(new FileUploaderProviderSecondaryPortAdapter().usePort());
    }

    @Test
    @DisplayName("Should Have S3Client Attribute Properly Instantiated")
    void shouldHaveS3ClientAttributeProperlyInstantiated(){
        var fileUploader = new FileUploaderProviderSecondaryPortAdapter().usePort();
        Assertions.assertNotNull(((S3FileUploader) fileUploader).getS3Client());
    }

    @Test
    @DisplayName("Shoud Not Throw Anything When Running Upload Method And S3Client Doesnt Throw Anything")
    void shoudNotThrowAnythingWhenRunningUploadMethodAndS3ClientDoesntThrowAnything(){
        var s3ClientMock = Mockito.mock(S3Client.class);
        this.makeS3MockReturnPutObjectResponseMockWhenCallingUploadMethod(s3ClientMock);
        var s3Fileuploader = new S3FileUploader(s3ClientMock);
        var file = this.instantiateValidFileObject();
        Assertions.assertDoesNotThrow(() -> s3Fileuploader.upload(file));
    }

    private void makeS3MockReturnPutObjectResponseMockWhenCallingUploadMethod(S3Client s3ClientMock) {
        Mockito.when(s3ClientMock.putObject(mockValueOf(PutObjectRequest.class), mockValueOf(RequestBody.class)))
                .thenReturn(PutObjectResponse.builder().build());
    }

    private static <T> T mockValueOf(Class<T> targetType){
        return ArgumentMatchers.any(targetType);
    }

    private File instantiateValidFileObject() {
        return new FilePropertiesRetrieverSecondaryPortAdapter().usePort().loadFile();
    }

}
