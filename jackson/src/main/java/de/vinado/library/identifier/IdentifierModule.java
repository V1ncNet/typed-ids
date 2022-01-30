package de.vinado.library.identifier;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.module.SimpleModule;
import de.vinado.library.identifier.string.StringIdentifier;
import de.vinado.library.identifier.string.StringIdentifierDeserializer;
import de.vinado.library.identifier.uuid.UuidIdentifier;
import de.vinado.library.identifier.uuid.UuidIdentifierDeserializer;

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

        addDeserializer(StringIdentifier.class, new StringIdentifierDeserializer<>());
        addDeserializer(UuidIdentifier.class, new UuidIdentifierDeserializer<>());

        addSerializer(Identifier.class, new IdentifierSerializer());
    }
}
