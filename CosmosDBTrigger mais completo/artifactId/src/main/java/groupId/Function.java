package groupId;

import com.azure.cosmos.*;
import com.azure.cosmos.models.*;
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

import java.util.Collections;
import java.util.Optional;

public class Function {

    String value;

    private CosmosClient client;

    private final String databaseName = "orders";
    private final String containerName = "orders";

    private CosmosDatabase database;
    private CosmosContainer container;


    @FunctionName("cosmosDBMonitor")
    public void cosmosDbPocessor(
            @CosmosDBTrigger(name = "items",
                    databaseName = "orders", collectionName = "orders",
                    createLeaseCollectionIfNotExists= true,
                    connectionStringSetting = "AzureCosmosDBConnection") String[] items,
            final ExecutionContext context) throws NoSuchFieldException, JsonProcessingException {

        client = new CosmosClientBuilder()
                .endpoint("https://dev-cosmos-cliente-001.documents.azure.com:443/")
                .key("VGkYDySU4uraZqBGWu29U1libdbNYKh6hQfffRiOfs3ABxEVqRddZxQpD9mTzyQsl3s5nuQxZ9T8gsKHiDiLqbnNZFNg==")
                //  Setting the preferred location to Cosmos DB Account region
                //  West US is just an example. User should set preferred location to the Cosmos DB region closest to the application
                .preferredRegions(Collections.singletonList("Brazil South"))
                .consistencyLevel(ConsistencyLevel.EVENTUAL)
                .buildClient();

        CosmosDatabase cosmosDatabaseResponse = client.getDatabase(databaseName);
        database = client.getDatabase(cosmosDatabaseResponse.getId());

        CosmosContainerProperties containerProperties =
                new CosmosContainerProperties(containerName, "/lastName");


        CosmosContainer cosmosContainerResponse =
                database.getContainer(containerProperties.getId());

        container = database.getContainer(cosmosContainerResponse.getId());
        CosmosQueryRequestOptions queryOptions = new CosmosQueryRequestOptions();


        CosmosPagedIterable<String> familiesPagedIterable = container.queryItems(
                "SELECT * FROM c", queryOptions, String.class);

        //converte para json
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(items[0]);
        System.out.println(rootNode.get("shareholder_participants").get("administrator").get("countryCode"));


        value = rootNode.get("shareholder_participants").get("administrator").get("countryCode").toString();

    }
}

//    @TableInput(name = "item", tableName = "items", partitionKey = "Example", rowKey = "{id}", connection = "AzureWebJobsStorage") TestInputData inputData,


//        @FunctionName("cosmosDBMonitor")
//        public void cosmosDbProcessor(
//                @CosmosDBTrigger(name = "items",
//                        databaseName = "database", collectionName = "collection1",
//                        createLeaseCollectionIfNotExists = true,
//                        connectionStringSetting = "AzureCosmosDBConnection") String[] items,
//                final ExecutionContext context) {
//
//
//            ConnectionPolicy policy = new ConnectionPolicy();
//            policy.setConnectionMode(ConnectionMode.Direct);
//
//            AsyncDocumentClient asyncClient = new AsyncDocumentClient.Builder()
//                    .withServiceEndpoint(HOST)
//                    .withMasterKeyOrResourceToken(MASTER_KEY)
//                    .withConnectionPolicy(policy)
//                    .withConsistencyLevel(ConsistencyLevel.Eventual)
//                    .build();
//
//            Document doc = new Document(String.format("{ 'id': 'doc%d', 'counter': '%d'}", 1, 1));
//
//            Observable<ResourceResponse<Document>> createDocumentObservable =
//                    asyncClient.createDocument(collectionLink, doc, null, false);
//            createDocumentObservable
//                    .single()           // we know there will be one response
//                    .subscribe(
//
//                            documentResourceResponse -> {
//                                System.out.println(documentResourceResponse.getRequestCharge());
//                            },
//
//                            error -> {
//                                System.err.println("an error happened: " + error.getMessage());
//                            });
//
//
//        }