package de.vinado.spring.identifier.convert;

import de.vinado.lib.identifier.basic.NumericIdentifier;
import de.vinado.lib.identifier.basic.StringIdentifier;
import de.vinado.lib.identifier.reflection.IdentifierInstantiationException;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.lang.Nullable;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static de.vinado.lib.identifier.reflection.InstantiationUtils.instantiate;

/**
 * {@link ReadingConverter} wrapping a string value into a new instance of {@link StringIdentifier}.
 *
 * @author Vincent Nadoll
 */
@ReadingConverter
public class NumericIdentifierConverter implements ConditionalGenericConverter {

    protected static final TypeDescriptor STRING_TYPE = TypeDescriptor.valueOf(String.class);
    protected static final TypeDescriptor INTEGER_TYPE = TypeDescriptor.valueOf(Integer.class);
    protected static final TypeDescriptor LONG_TYPE = TypeDescriptor.valueOf(Long.class);
    protected static final TypeDescriptor IDENTIFIER_TYPE = TypeDescriptor.valueOf(NumericIdentifier.class);

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return (sourceType.isAssignableTo(STRING_TYPE)
            || sourceType.isAssignableTo(INTEGER_TYPE)
            || sourceType.isAssignableTo(LONG_TYPE))
            && targetType.isAssignableTo(IDENTIFIER_TYPE);
    }

    @Nullable
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Stream.of(
            new ConvertiblePair(String.class, NumericIdentifier.class),
            new ConvertiblePair(Integer.class, NumericIdentifier.class),
            new ConvertiblePair(Long.class, NumericIdentifier.class)
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

    private NumericIdentifier convertNonNull(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        try {
            Class<?> targetClass = targetType.getType();
            Constructor<?> constructor = ReflectionUtils.accessibleConstructor(targetClass, Long.class);
            return (NumericIdentifier) instantiate(constructor, from(source, sourceType, targetType));
        } catch (NoSuchMethodException
                 | SecurityException
                 | IllegalArgumentException
                 | IdentifierInstantiationException e) {
            throw new ConversionFailedException(TypeDescriptor.forObject(source), targetType, source, e);
        }
    }

    private static Long from(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Class<?> sourceClass = sourceType.getType();
        if (sourceClass.isAssignableFrom(Integer.class) && source instanceof Integer) {
            return Long.valueOf((Integer) source);
        } else if (sourceClass.isAssignableFrom(Long.class) && source instanceof Long) {
            return (Long) source;
        } else if (sourceClass.isAssignableFrom(String.class) && source instanceof String) {
            return Long.parseLong(String.valueOf(source));
        }

        throw new ConverterNotFoundException(sourceType, targetType);
    }
}
