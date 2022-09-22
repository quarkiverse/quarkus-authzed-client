
package io.quarkiverse.authzed;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.authzed.api.v1.Core.ObjectReference;
import com.authzed.api.v1.Core.Relationship;
import com.authzed.api.v1.Core.SubjectReference;

public class Tuples {

    // <tuple> ::= <object>'#'<relation>'@'<user>
    // <object> ::= <namespace>':'<object_id>
    // <user> ::= <user_id> | <userset>
    // <userset> ::= <object>'#'<relation>

    private static final Pattern TUPLE_PATTERN = Pattern.compile("(?<object>[^ ]+)#(?<relation>[^ ]+)@(?<user>[^ ]+)");

    public static Optional<String> matchObject(String text) {
        return match(text, "object");
    }

    public static Optional<String> matchRelation(String text) {
        return match(text, "relation");
    }

    public static Optional<String> matchUser(String text) {
        return match(text, "user");
    }

    public static Optional<String> match(String text, String id) {
        Matcher m = TUPLE_PATTERN.matcher(text);
        if (m.matches()) {
            return Optional.of(m.group(id));
        }
        return Optional.empty();
    }

    public static Relationship parseRelationship(String tuple) {
        String object = Tuples.matchObject(tuple)
                .orElseThrow(() -> new IllegalStateException("Failed to parse object / resource from: [" + tuple + "]."));
        String user = Tuples.matchUser(tuple)
                .orElseThrow(() -> new IllegalStateException("Failed to parse user / subject from: [" + tuple + "]."));
        String relation = Tuples.matchRelation(tuple)
                .orElseThrow(() -> new IllegalStateException("Failed to parse relation from: [" + tuple + "]."));

        ObjectReference resource = Tuples.parseObject(object);
        SubjectReference subject = Tuples.parseUser(user);
        return Relationship.newBuilder()
                .setResource(resource)
                .setRelation(relation)
                .setSubject(subject)
                .build();
    }

    public static SubjectReference parseUser(String text) {
        String[] parts = text.split(Pattern.quote("#"));
        if (parts.length == 1) {
            String user = parts[0];
            return SubjectReference.newBuilder().setObject(parseObject(user)).build();
        }
        if (parts.length == 2) {
            String object = parts[0];
            String relation = parts[1];
            return SubjectReference.newBuilder().setObject(parseObject(object)).setOptionalRelation(relation).build();
        }
        throw new IllegalArgumentException("User does not follow <user_id> | <<object>'#'<relation>>  format!");
    }

    public static ObjectReference parseObject(String text) {
        String[] parts = text.split(Pattern.quote(":"));
        if (parts.length == 1) {
            String objectId = parts[0];
            return ObjectReference.newBuilder()
                    .setObjectId(objectId)
                    .build();
        }
        if (parts.length == 2) {
            String namespace = parts[0];
            String objectId = parts[1];
            return ObjectReference.newBuilder()
                    .setObjectType(namespace)
                    .setObjectId(objectId)
                    .build();
        }
        throw new IllegalArgumentException("Object does not follow <namespace>':'<object_id> format!");
    }
}
