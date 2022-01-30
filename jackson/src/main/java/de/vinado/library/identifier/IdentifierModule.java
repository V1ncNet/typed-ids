package de.vinado.library.identifier;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * {@link com.fasterxml.jackson.databind.Module} registering {@link com.fasterxml.jackson.databind.JsonSerializer}s and
 * {@link com.fasterxml.jackson.databind.JsonDeserializer}s for reading or writing {@link Identifier} types to or from a
 * JSON tree.
 *
 * @author Vincent Nadoll
 */
public class IdentifierModule extends SimpleModule {

    private static final long serialVersionUID = -1818622609743081303L;

    public static final Version VERSION = VersionUtil.parseVersion(
        "0.1.0-SNAPSHOT", "de.vinado.library", "identifier-jackson"
    );

    public IdentifierModule() {
        super(VERSION);

        addSerializer(Identifier.class, new IdentifierSerializer());
    }
}
