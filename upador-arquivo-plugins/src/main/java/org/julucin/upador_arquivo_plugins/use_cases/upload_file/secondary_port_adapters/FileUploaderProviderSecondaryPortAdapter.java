package org.julucin.upador_arquivo_plugins.use_cases.upload_file.secondary_port_adapters;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.contracts.FileUploader;
import org.julucin.upador_arquivo_core.use_cases.upload_file.impl.secondary_ports.FileUploaderProviderSecondaryPort;
import org.julucin.upador_arquivo_plugins.use_cases.upload_file.env_var_keys.UploadFilesUseCaseEnvVarRetriever;
import org.julucin.upador_arquivo_plugins.use_cases.upload_file.s3_client.S3ClientInitializer;
import org.julucin.upador_arquivo_plugins.use_cases.upload_file.secondary_port_adapters.dtos.PropertiesOfBucketDto;
import org.julucin.upador_arquivo_plugins.use_cases.upload_file.secondary_port_adapters.exceptions.UploadingFileToS3RuntimeException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;

@Slf4j
public class FileUploaderProviderSecondaryPortAdapter implements FileUploaderProviderSecondaryPort {

    @Override
    public FileUploader usePort() {
        log.info("Instantiating the S3Client provider for the Core layer.");
        return new S3FileUploader(S3ClientInitializer.initializeClient());
    }

    @Slf4j
    @Getter
    public record S3FileUploader(S3Client s3Client) implements FileUploader {

        @Override
        public void upload(File file) {
            log.info("Starting S3 uploading process.");
            var putObjectRequest = this.initializePutObjectRequest();
            try {
                this.s3Client.putObject(putObjectRequest, RequestBody.fromFile(file));
            } catch (Exception exception) {
                throw new UploadingFileToS3RuntimeException(file.getName(), exception.getMessage());
            }
        }

        private PutObjectRequest initializePutObjectRequest() {
            log.info("Instantiating PutObject request to S3.");
            var propertiesOfBucketToUploadIn = this.getPropertiesOfBucketToUploadIn();
            return PutObjectRequest.builder()
                    .bucket(propertiesOfBucketToUploadIn.getBucketName())
                    .key(propertiesOfBucketToUploadIn.getDesiredFileName())
                    .build();
        }

        private PropertiesOfBucketDto getPropertiesOfBucketToUploadIn() {
            log.info("Retrieving environment variables for bucket name and desired file name.");
            var bucketName = UploadFilesUseCaseEnvVarRetriever.getBucketNameEnvVar();
            var desiredFileName = UploadFilesUseCaseEnvVarRetriever.getDesiredFileNameEnvVar();
            return new PropertiesOfBucketDto(bucketName, desiredFileName);
        }


    }
}
