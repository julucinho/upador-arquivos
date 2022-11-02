package org.julucin.upador_arquivo_plugins.use_cases.upload_file.env_var_keys;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class EnvVarKeys {

    public static final String BUCKET_NAME = "BUCKET_NAME";
    public static final String DESIRED_FILE_NAME = "DESIRED_FILE_NAME";
    public static final String AWS_REGION = "AWS_REGION";
    public static final String FULL_PATH_TO_FILE = "FULL_PATH_TO_FILE";
}
