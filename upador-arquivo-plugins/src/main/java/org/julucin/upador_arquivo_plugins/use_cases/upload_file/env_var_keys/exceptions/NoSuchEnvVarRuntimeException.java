package org.julucin.upador_arquivo_plugins.use_cases.upload_file.env_var_keys.exceptions;

public class NoSuchEnvVarRuntimeException extends RuntimeException {
    public NoSuchEnvVarRuntimeException(String envVarKey) {
        super("No such environment variable called '".concat(envVarKey).concat("'"));
    }
}
