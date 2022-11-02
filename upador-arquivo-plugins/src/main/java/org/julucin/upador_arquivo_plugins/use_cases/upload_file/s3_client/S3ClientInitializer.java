package org.julucin.upador_arquivo_plugins.use_cases.upload_file.s3_client;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.julucin.upador_arquivo_plugins.use_cases.upload_file.env_var_keys.UploadFilesUseCaseEnvVarRetriever;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class S3ClientInitializer {

    public static S3Client initializeClient(){
        return S3Client.builder()
                .region(Region.of(UploadFilesUseCaseEnvVarRetriever.getAwsRegionEnvVar()))
                .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
                .build();
    }

}
