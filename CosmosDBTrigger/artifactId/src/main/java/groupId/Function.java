package groupId;

import com.azure.cosmos.*;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.models.PartitionKey;
import com.azure.cosmos.util.CosmosPagedIterable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.*;

import java.util.Optional;



public class Function {

    @FunctionName("cosmosDBMonitor")
    public void cosmosDbPocessor(
            @CosmosDBTrigger(name = "items",
                    databaseName = "orders", collectionName = "orders",
                    createLeaseCollectionIfNotExists= true,
                    connectionStringSetting = "AzureCosmosDBConnection") String[] items,
            final ExecutionContext context) throws NoSuchFieldException, JsonProcessingException {


        //converte para json
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(items[0]);
        System.out.println(rootNode.get("shareholder_participants").get("administrator").get("countryCode"));

        rootNode.get("shareholder_participants").get("administrator").get("countryCode").toString();

    }
}
