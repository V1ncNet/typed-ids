# :muscle: Typed Identifier Value Objects

This project is a collection of Value Objects that encourages the use of
strong typed identifiers. It also provides integrations for serialization
libraries such as Jackson.

## Use Case

Imagine a service or repository, and you want to query an entity with two
distinct IDs. Let's say they're both UUIDs. There's no other possibility than to
differentiate between the IDs via the name of the argument.

```java
public Entity query(UUID fooId, UUID barId) {
    ...
}
```

There are three options to minimize the risk to confound the arguments of
the method above.

0. Be perfect and make no mistakes
1. Verify the correctness with tests
2. Change code design
3. Use different argument types

Although I'd recommend option 1 and 2, it's never a bad idea to be extra sure
and avoid misuse from the start. Strong typing and extensive use of Value
Objects helps to improve readability and encourages self documenting code.


## Usage

The library can be used as is, but the real benefits only come when you
derive the identifier for each domain entity. Let's assume you hava an entity
called Person. Your code could read something like this.

```java
public class Person {

    private final Person.Id id;
    private String name;

    // constructor, getter and setter omitted for brevity

    public static final class Id extends UuidIdentifier {

        public Id(UUID value) {
            super(value);
        }
    }
}
```


## Modules

None of the modules below will ship transitive dependencies. Unless you are
using a Spring Boot Starter Parent, you want to make sure to include the
dependencies yourself.

### API

The API module contains the core code base. Other modules are built on top of
the API.  The usage is pretty self-explanatory. It contains the identifier,
factories and basic subtypes. The `Identifiable` interface is for convenience
may be implemented by any domain entities.

```xml
<dependency>
    <groupId>de.vinado.library</groupId>
    <artifactId>identifier-api</artifactId>
    <version>1.0.1</version>
</dependency>
```

### Jackson

This module contains JSON deserializers for all generic base identifiers and a
generic serializer that delegates to the ID value's serializer. Their purpose is
to unwrap the value object into a plain JSON value. So the JSON tree stays clean
and familiar to existing APIs (or at least to you and your OCDs).

If you want to derive from a basic identifier, you also need to implement a
custom deserializer. The following example shows the amount of work that is
necessary. Not much right?

```java
@JsonDeserialize(using = Id.Deserializer.class)
public final class Id extends UuidIdentifier {

    public Id(UUID value) {
        super(value);
    }

    private static final class Deserializer extends UuidIdentifierDeserializer<Id> {

        private Deserializer() {
            super(Id::new);
        }
    }
}
```

---

```xml
<dependency>
    <groupId>de.vinado.library</groupId>
    <artifactId>identifier-jackson</artifactId>
    <version>1.0.1</version>
</dependency>

<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>${jackson.version}</version>
</dependency>
```

### Spring

The Spring module contains generic identifier (reading) converters. They are
capable of converting any compatible value to the corresponding identifier
**and subtypes**. This is especially useful for Spring Web applications and you
want to query resources by their identifier, like the following example shows.

```java
@GetMapping("/{id}")
public ResponseEntity<Person> retrieve(@PathVariable Person.Id id) {
    ...
}
```

The identifier instantiation is performed via Java reflection. Therefor subtypes
must provide an accessible constructor that takes exactly on argument of the
type the identifier encapsulates.

---

```xml
<dependency>
    <groupId>de.vinado.spring</groupId>
    <artifactId>identifier-convert</artifactId>
    <version>1.0.1</version>
</dependency>

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>${spring.version}</version>
</dependency>
```

### Spring Boot

In case you wish to integrate strong typed identifiers into your Spring Boot
application you may want to use the zero-conf Spring Boot Starter.

```xml
<dependency>
    <groupId>de.vinado.boot</groupId>
    <artifactId>identifier-spring-boot-starter</artifactId>
    <version>1.0.1</version>
</dependency>
```

## Licence

Apache License 2.0 - [Vinado](https://vinado.de) - Built with :heart: in Dresden
