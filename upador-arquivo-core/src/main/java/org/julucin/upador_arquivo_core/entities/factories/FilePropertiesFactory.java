package org.julucin.upador_arquivo_core.entities.factories;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.julucin.upador_arquivo_core.entities.FileProperties;
import org.julucin.upador_arquivo_core.entities.impl.FilePropertiesImpl;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FilePropertiesFactory {

    public static FileProperties makeFileProperties(){
        return new FilePropertiesImpl();
    }

}
