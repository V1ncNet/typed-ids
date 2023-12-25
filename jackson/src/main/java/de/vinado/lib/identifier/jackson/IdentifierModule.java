package de.vinado.lib.identifier.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.module.SimpleModule;
import de.vinado.lib.identifier.Identifier;
import de.vinado.lib.identifier.basic.NumericIdentifier;
import de.vinado.lib.identifier.basic.StringIdentifier;
import de.vinado.lib.identifier.basic.UuidIdentifier;
import de.vinado.lib.identifier.jackson.basic.NumericIdentifierDeserializer;
import de.vinado.lib.identifier.jackson.basic.StringIdentifierDeserializer;
import de.vinado.lib.identifier.jackson.basic.UuidIdentifierDeserializer;

import java.io.Serial;

/**
 * {@link com.fasterxml.jackson.databind.Module} registering {@link com.fasterxml.jackson.databind.JsonSerializer}s and
 * {@link com.fasterxml.jackson.databind.JsonDeserializer}s for reading or writing {@link Identifier} types to or from a
 * JSON tree.
 *
 * @author Vincent Nadoll
 */
public class IdentifierModule extends SimpleModule {

    @Serial
    private static final long serialVersionUID = -1818622609743081303L;

    public static final Version VERSION = VersionUtil.parseVersion(
        "2.0.1", "de.vinado.lib", "identifier-jackson"
    );

    public IdentifierModule() {
        super(VERSION);

        addDeserializer(NumericIdentifier.class, new NumericIdentifierDeserializer<>());
        addDeserializer(StringIdentifier.class, new StringIdentifierDeserializer<>());
        addDeserializer(UuidIdentifier.class, new UuidIdentifierDeserializer<>());

        addSerializer(Identifier.class, new IdentifierSerializer());
    }
}
