package org.julucin.upador_arquivo_plugins.use_cases.upload_file.env_var_keys;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.Supplier;

@ExtendWith(MockitoExtension.class)
class UploadFilesUseCaseEnvVarRetrieverTest {

    @Test
    @DisplayName("Should Return Expected Value For Env Var AWS_REGION")
    void shouldReturnExpectedValueForEnvVarAwsRegion(){
        var result = this.validateIfItIsReturningEnvVarValueProperly(
                EnvVarKeys.AWS_REGION,
                UploadFilesUseCaseEnvVarRetriever::getAwsRegionEnvVar
        );
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Should Return Expected Value For Env Var DESIRED_FILE_NAME")
    void shouldReturnExpectedValueForEnvVarDesiredFileName(){
        var result = this.validateIfItIsReturningEnvVarValueProperly(
                EnvVarKeys.DESIRED_FILE_NAME,
                UploadFilesUseCaseEnvVarRetriever::getDesiredFileNameEnvVar
        );
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Should Return Expected Value For Env Var FULL_PATH_TO_FILE")
    void shouldReturnExpectedValueForEnvVarFullPathToFile(){
        var result = this.validateIfItIsReturningEnvVarValueProperly(
                EnvVarKeys.FULL_PATH_TO_FILE,
                UploadFilesUseCaseEnvVarRetriever::getFullPathToFile
        );
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Should Return Expected Value For Env Var BUCKET_NAME")
    void shouldReturnExpectedValueForEnvVarBucketName(){
        var result = this.validateIfItIsReturningEnvVarValueProperly(
                EnvVarKeys.BUCKET_NAME,
                UploadFilesUseCaseEnvVarRetriever::getBucketNameEnvVar
        );
        Assertions.assertTrue(result);
    }

    Boolean validateIfItIsReturningEnvVarValueProperly(String envVarKey, Supplier<String> getter){
        var value = System.getenv(envVarKey);
        return value.equals(getter.get());
    }

}
