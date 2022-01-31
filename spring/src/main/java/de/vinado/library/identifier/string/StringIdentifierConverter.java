package de.vinado.library.identifier.string;

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
import java.util.Collections;
import java.util.Set;

/**
 * {@link ReadingConverter} wrapping a string value into a new instance of {@link StringIdentifier}.
 *
 * @author Vincent Nadoll
 */
@ReadingConverter
public class StringIdentifierConverter implements ConditionalGenericConverter {

    protected static final TypeDescriptor STRING_TYPE = TypeDescriptor.valueOf(String.class);
    protected static final TypeDescriptor IDENTIFIER_TYPE = TypeDescriptor.valueOf(StringIdentifier.class);

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return sourceType.isAssignableTo(STRING_TYPE) && targetType.isAssignableTo(IDENTIFIER_TYPE);
    }

    @Nullable
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class, StringIdentifier.class));
    }

    @Nullable
    @Override
    public Object convert(@Nullable Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (null == source) {
            return null;
        }

        return convertNonNull(source, sourceType, targetType);
    }

    private StringIdentifier convertNonNull(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        try {
            Class<?> targetClass = targetType.getType();
            Constructor<?> constructor = ReflectionUtils.accessibleConstructor(targetClass, String.class);
            return (StringIdentifier) InstantiationUtils.instantiate(constructor, from(source, sourceType, targetType));
        } catch (NoSuchMethodException
            | SecurityException
            | IllegalArgumentException
            | IdentifierInstantiationException e) {
            throw new ConversionFailedException(TypeDescriptor.forObject(source), targetType, source, e);
        }
    }

    private static String from(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Class<?> sourceClass = sourceType.getType();
        if (sourceClass.isAssignableFrom(String.class) && source instanceof String) {
            return (String) source;
        }

        throw new ConverterNotFoundException(sourceType, targetType);
    }
}
