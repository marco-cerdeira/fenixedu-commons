package org.fenixedu.commons.json;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class UserSpecificCreator implements JsonCreator<User> {

    @Override
    public User create(JsonElement jsonElement, JsonBuilder ctx) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        final String name = jsonObject.get("name").getAsString();
        final String password = Base64.encodeBase64String(jsonObject.get("password").getAsString().getBytes());
        final String number = jsonObject.get("number").getAsString();
        return new User(name, password, number);
    }
}
