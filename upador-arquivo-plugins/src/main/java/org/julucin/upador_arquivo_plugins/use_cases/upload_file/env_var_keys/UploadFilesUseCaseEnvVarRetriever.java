package org.julucin.upador_arquivo_plugins.use_cases.upload_file.env_var_keys;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.julucin.upador_arquivo_plugins.use_cases.upload_file.env_var_keys.exceptions.NoSuchEnvVarRuntimeException;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UploadFilesUseCaseEnvVarRetriever {

    public static String getBucketNameEnvVar(){
        return getEnvVar(EnvVarKeys.BUCKET_NAME);
    }

    public static String getDesiredFileNameEnvVar(){
        return getEnvVar(EnvVarKeys.DESIRED_FILE_NAME);
    }

    public static String getAwsRegionEnvVar(){
        return getEnvVar(EnvVarKeys.AWS_REGION);
    }

    public static String getFullPathToFile() {
        return getEnvVar(EnvVarKeys.FULL_PATH_TO_FILE);
    }

    private static String getEnvVar(String envVarKey) {
        return Optional.ofNullable(System.getenv(envVarKey))
                .orElseThrow(() -> new NoSuchEnvVarRuntimeException(envVarKey));
    }
}
