package org.julucin.upador_arquivo_core.entities.impl;

import org.julucin.upador_arquivo_core.entities.FileProperties;
import org.julucin.upador_arquivo_core.entities.impl.exceptions.NoSuchFileRuntimeException;

import java.io.File;

public class FilePropertiesImpl extends FileProperties {

    @Override
    public File loadFile() {
        var file = new File(this.getFullPathToFile());
        if (file.exists())
            return file;
        throw new NoSuchFileRuntimeException(this.getFullPathToFile());
    }
}
