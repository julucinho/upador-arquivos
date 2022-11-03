package org.julucin.upador_arquivo_plugins.use_cases.upload_file.env_var_keys;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class EnvVarKeys {

    public static final String BUCKET_NAME = "BucketName";
    public static final String DESIRED_FILE_NAME = "DesiredFileName";
    public static final String AWS_REGION = "AwsRegion";
    public static final String FULL_PATH_TO_FILE = "FullPathToFile";
}
