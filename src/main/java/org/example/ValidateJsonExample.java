package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;

public class ValidateJsonExample {
    public static void main(String[] args) throws IOException, ProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Read schema.json as a JsonNode
        JsonNode schemaNode = objectMapper.readTree(new File("src/main/java/org/example/schema.json"));
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();

        // Convert schemaNode to a JsonSchema
        JsonSchema schema = factory.getJsonSchema(schemaNode);

        // Read user.json as a JsonNode
        JsonNode jsonData = objectMapper.readTree(new File("src/main/java/org/example/user.json"));

        // Validate JSON
        ProcessingReport report = schema.validate(jsonData);
        System.out.println(report.isSuccess() ? "Valid JSON" : "Invalid JSON");
        System.out.println(report);  // Prints detailed validation errors if any
    }
}
