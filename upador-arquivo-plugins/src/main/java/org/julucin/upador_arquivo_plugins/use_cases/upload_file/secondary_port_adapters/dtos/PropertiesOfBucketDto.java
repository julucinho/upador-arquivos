package org.julucin.upador_arquivo_plugins.use_cases.upload_file.secondary_port_adapters.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PropertiesOfBucketDto {

    private final String bucketName;
    private final String desiredFileName;

}

