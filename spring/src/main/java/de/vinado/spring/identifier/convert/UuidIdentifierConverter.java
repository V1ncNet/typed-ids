package de.vinado.spring.identifier.convert;

import de.vinado.library.identifier.basic.UuidIdentifier;
import de.vinado.library.identifier.reflection.IdentifierInstantiationException;
import de.vinado.library.identifier.reflection.InstantiationUtils;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.lang.Nullable;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link ReadingConverter} wrapping an {@link UUID}-like value into a new instance of {@link UuidIdentifier}.
 *
 * @author Vincent Nadoll
 */
@ReadingConverter
public class UuidIdentifierConverter implements ConditionalGenericConverter {

    protected static final TypeDescriptor STRING_TYPE = TypeDescriptor.valueOf(String.class);
    protected static final TypeDescriptor UUID_TYPE = TypeDescriptor.valueOf(UUID.class);
    protected static final TypeDescriptor IDENTIFIER_TYPE = TypeDescriptor.valueOf(UuidIdentifier.class);

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return (sourceType.isAssignableTo(STRING_TYPE) || sourceType.isAssignableTo(UUID_TYPE))
            && targetType.isAssignableTo(IDENTIFIER_TYPE);
    }

    @Nullable
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Stream.of(
            new ConvertiblePair(String.class, UuidIdentifier.class),
            new ConvertiblePair(UUID.class, UuidIdentifier.class)
        ).collect(Collectors.toSet());
    }

    @Nullable
    @Override
    public Object convert(@Nullable Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (null == source) {
            return null;
        }

        return convertNonNull(source, sourceType, targetType);
    }

    protected UuidIdentifier convertNonNull(Object source, TypeDescriptor sourceType, TypeDescriptor targetType)
        throws ConversionFailedException {
        try {
            Class<?> targetClass = targetType.getType();
            Constructor<?> constructor = ReflectionUtils.accessibleConstructor(targetClass, UUID.class);
            return (UuidIdentifier) InstantiationUtils.instantiate(constructor, from(source, sourceType, targetType));
        } catch (NoSuchMethodException
            | SecurityException
            | IllegalArgumentException
            | IdentifierInstantiationException e) {
            throw new ConversionFailedException(TypeDescriptor.forObject(source), targetType, source, e);
        }
    }

    private static UUID from(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Class<?> sourceClass = sourceType.getType();
        if (sourceClass.isAssignableFrom(UUID.class) && source instanceof UUID) {
            return (UUID) source;
        } else if (sourceClass.isAssignableFrom(String.class) && source instanceof String) {
            return UUID.fromString((String) source);
        }

        throw new ConverterNotFoundException(sourceType, targetType);
    }
}
