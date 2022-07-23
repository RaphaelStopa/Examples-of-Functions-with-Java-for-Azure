package groupId;

import com.azure.cosmos.*;
import com.azure.cosmos.models.CosmosContainerProperties;
import com.azure.cosmos.models.CosmosContainerResponse;
import com.azure.cosmos.models.CosmosDatabaseResponse;
import com.azure.cosmos.models.CosmosItemResponse;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.models.PartitionKey;
import com.azure.cosmos.models.ThroughputProperties;
import com.azure.cosmos.util.CosmosPagedFlux;
import com.azure.cosmos.util.CosmosPagedIterable;
import groupId.entities.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Collections;
import java.util.stream.Collectors;

//https://docs.microsoft.com/pt-br/azure/cosmos-db/sql/create-sql-api-java?tabs=async
public class Function {

//    private CosmosClient client;
//
//    private final String databaseName = "AzureSampleFamilyDB";
//    private final String containerName = "FamilyContainer";
//
//    private CosmosDatabase database;
    private CosmosContainer container;
//
//
//
//
    private void queryItems() {
        //  <QueryItems>
        // Set some common query options
        CosmosQueryRequestOptions queryOptions = new CosmosQueryRequestOptions();
        //queryOptions.setEnableCrossPartitionQuery(true); //No longer necessary in SDK v4
        //  Set query metrics enabled to get metrics around query executions
        queryOptions.setQueryMetricsEnabled(true);

        CosmosPagedIterable<Order> familiesPagedIterable = container.queryItems(
                "SELECT * FROM c WHERE c.id = d29d326e-d1e6-477d-8235-05e86ac6540c", queryOptions, Order.class);

        familiesPagedIterable.iterableByPage(10).forEach(cosmosItemPropertiesFeedResponse -> {
            System.out.println (
                    cosmosItemPropertiesFeedResponse.getResults().size());

            System.out.println (cosmosItemPropertiesFeedResponse.getRequestCharge());

            System.out.println("Item Ids {}" + cosmosItemPropertiesFeedResponse
                    .getResults()
                    .stream()
                    .map(Order::getId)
                    .collect(Collectors.toList()));
        });
        //  </QueryItems>
    }
}
