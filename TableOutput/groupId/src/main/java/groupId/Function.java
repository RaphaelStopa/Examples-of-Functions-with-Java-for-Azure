package groupId;

import com.azure.cosmos.*;
import com.azure.cosmos.implementation.Database;
import com.azure.cosmos.models.*;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.*;
import com.sun.security.ntlm.Client;

import java.util.Collections;
import java.util.Optional;

//    https://docs.microsoft.com/pt-br/azure/azure-functions/functions-bindings-storage-queue-trigger?tabs=java
//    https://docs.microsoft.com/pt-br/azure/azure-functions/functions-bindings-cosmosdb-v2-output?tabs=java
//    https://docs.microsoft.com/en-us/azure/azure-functions/functions-bindings-storage-table-output?tabs=in-process%2Cstorage-extension&pivots=programming-language-java

public class Function {

    // Mapeamento
    public class Orders {
        private String PartitionKey;
        private String RowKey;
        private String Name;
        public String getPartitionKey() {return this.PartitionKey;}
        public void setPartitionKey(String key) {this.PartitionKey = key; }
        public String getRowKey() {return this.RowKey;}
        public void setRowKey(String key) {this.RowKey = key; }
        public String getName() {return this.Name;}
        public void setName(String name) {this.Name = name; }
    }




    @FunctionName("addOrder")
    public HttpResponseMessage get(
            @HttpTrigger(name = "postOrders", methods = {HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS, route="order/{partitionKey}/{rowKey}") HttpRequestMessage<Optional<Orders>> request,
            @BindingName("partitionKey") String partitionKey,
            @BindingName("rowKey") String rowKey,
            @TableOutput(name="orders", partitionKey="{partitionKey}", rowKey = "{rowKey}", tableName="orders", connection="AzureWebJobsStorage") OutputBinding<Orders> orders,
            final ExecutionContext context) {

//        CosmosClient client = new CosmosClientBuilder()
//                .endpoint(AccountSettings.HOST)
//                .key(AccountSettings.MASTER_KEY)
//                //  Setting the preferred location to Cosmos DB Account region
//                //  West US is just an example. User should set preferred location to the Cosmos DB region closest to the application
//                .preferredRegions(Collections.singletonList("West US"))
//                .consistencyLevel(ConsistencyLevel.EVENTUAL)
//                .buildClient();
//
//
//
//        CosmosDatabaseResponse cosmosDatabaseResponse = client.createDatabaseIfNotExists(databaseName);
//        CosmosDatabase database = client.getDatabase(cosmosDatabaseResponse.getProperties().getId());
//
//
//        CosmosContainerProperties containerProperties =
//                new CosmosContainerProperties(containerName, "/lastName");
//
////  Create container with 400 RU/s
//        CosmosContainerResponse cosmosContainerResponse =
//                database.createContainerIfNotExists(containerProperties, ThroughputProperties.createManualThroughput(400));
//        CosmosContainer container = database.getContainer(cosmosContainerResponse.getProperties().getId());



        CosmosQueryRequestOptions queryOptions = new CosmosQueryRequestOptions();

        CosmosPagedIterable<Order> familiesPagedIterable = container.queryItems(
                "SELECT * FROM c WHERE c.id = d29d326e-d1e6-477d-8235-05e86ac6540c", queryOptions, Order.class);


//        Orders outOrders = new Orders();
//        outOrders.setPartitionKey(partitionKey);
//        outOrders.setRowKey(rowKey);
//        outOrders.setName(request.getBody().get().getName());
//
//        orders.setValue(outOrders);

//        orders.setValue();

        return request.createResponseBuilder(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(nha)
                .build();
    }





    String nha = "{\n" +
//            "    \"id\": \"d29d326e-d1e6-477d-8235-05e86ac6540c\",\n" +
            "    \"operation_date\": \"13/08/2021\",\n" +
            "    \"inclusion_date\": \"2021-08-12T17:25:47.890-0300\",\n" +
            "    \"shareholder\": {\n" +
            "        \"document\": \"63.577.769/0001-97\",\n" +
            "        \"name\": \"aqui\"\n" +
            "    },\n" +
            "    \"shareholder_participants\": {\n" +
            "        \"administrator\": {\n" +
            "            \"code\": 0,\n" +
            "            \"countryCode\": 105,\n" +
            "            \"id\": \"c196ca1f-8a9f-4ea2-9d4c-22bdc592750d\",\n" +
            "            \"name\": \"Banco BMG\",\n" +
            "            \"nickname\": \"BMG\",\n" +
            "            \"document\": \"15195555000103\",\n" +
            "            \"is_checked\": false,\n" +
            "            \"is_prior_authorization\": false\n" +
            "        },\n" +
            "        \"manager\": {\n" +
            "            \"code\": 0,\n" +
            "            \"id\": \"353894e2-dcba-4fe8-8a4c-53c6e6104bbb\",\n" +
            "            \"name\": \"Teste 2 Dominios S.A.\",\n" +
            "            \"nickname\": \"Teste 2 Dominios\",\n" +
            "            \"document\": \"69165588000130\",\n" +
            "            \"is_checked\": false,\n" +
            "            \"is_prior_authorization\": false\n" +
            "        },\n" +
            "        \"custodian\": {\n" +
            "            \"code\": 0,\n" +
            "            \"id\": \"c196ca1f-8a9f-4ea2-9d4c-22bdc592750d\",\n" +
            "            \"name\": \"Banco BMG\",\n" +
            "            \"nickname\": \"BMG\",\n" +
            "            \"document\": \"15195555000103\",\n" +
            "            \"is_checked\": false,\n" +
            "            \"is_prior_authorization\": false\n" +
            "        },\n" +
            "        \"liability_controller\": {\n" +
            "            \"code\": 0,\n" +
            "            \"id\": \"52aed8b3-5fcd-41a4-be4c-4b1f1358201c\",\n" +
            "            \"name\": \"Antônio Carlos\",\n" +
            "            \"nickname\": \"Carlos\",\n" +
            "            \"document\": \"48740678000137\",\n" +
            "            \"is_checked\": false,\n" +
            "            \"is_prior_authorization\": false\n" +
            "        },\n" +
            "        \"asset_controller\": {\n" +
            "            \"code\": 0,\n" +
            "            \"id\": \"353894e2-dcba-4fe8-8a4c-53c6e6104bbb\",\n" +
            "            \"name\": \"Teste 2 Dominios S.A.\",\n" +
            "            \"nickname\": \"Teste 2 Dominios\",\n" +
            "            \"document\": \"69165588000130\",\n" +
            "            \"is_checked\": false,\n" +
            "            \"is_prior_authorization\": false\n" +
            "        }\n" +
            "    },\n" +
            "    \"operation_type\": \"AP\",\n" +
            "    \"counterparty\": {\n" +
            "        \"document\": \"63.577.769/0001-97\",\n" +
            "        \"name\": \"dasd asdasd\"\n" +
            "    },\n" +
            "    \"counterparty_participants\": {\n" +
            "        \"administrator\": {\n" +
            "            \"code\": 0,\n" +
            "            \"countryCode\": 105,\n" +
            "            \"id\": \"c196ca1f-8a9f-4ea2-9d4c-22bdc592750d\",\n" +
            "            \"name\": \"Banco BMG\",\n" +
            "            \"nickname\": \"BMG\",\n" +
            "            \"document\": \"15195555000103\",\n" +
            "            \"is_checked\": false,\n" +
            "            \"is_prior_authorization\": false\n" +
            "        },\n" +
            "        \"manager\": {\n" +
            "            \"code\": 0,\n" +
            "            \"id\": \"353894e2-dcba-4fe8-8a4c-53c6e6104bbb\",\n" +
            "            \"name\": \"Teste 2 Dominios S.A.\",\n" +
            "            \"nickname\": \"Teste 2 Dominios\",\n" +
            "            \"document\": \"69165588000130\",\n" +
            "            \"is_checked\": false,\n" +
            "            \"is_prior_authorization\": false\n" +
            "        },\n" +
            "        \"custodian\": {\n" +
            "            \"code\": 0,\n" +
            "            \"id\": \"c196ca1f-8a9f-4ea2-9d4c-22bdc592750d\",\n" +
            "            \"name\": \"Banco BMG\",\n" +
            "            \"nickname\": \"BMG\",\n" +
            "            \"document\": \"15195555000103\",\n" +
            "            \"is_checked\": false,\n" +
            "            \"is_prior_authorization\": false\n" +
            "        },\n" +
            "        \"liability_controller\": {\n" +
            "            \"code\": 0,\n" +
            "            \"id\": \"52aed8b3-5fcd-41a4-be4c-4b1f1358201c\",\n" +
            "            \"name\": \"Antônio Carlos\",\n" +
            "            \"nickname\": \"Carlos\",\n" +
            "            \"document\": \"48740678000137\",\n" +
            "            \"is_checked\": false,\n" +
            "            \"is_prior_authorization\": false\n" +
            "        },\n" +
            "        \"asset_controller\": {\n" +
            "            \"code\": 0,\n" +
            "            \"id\": \"353894e2-dcba-4fe8-8a4c-53c6e6104bbb\",\n" +
            "            \"name\": \"Teste 2 Dominios S.A.\",\n" +
            "            \"nickname\": \"Teste 2 Dominios\",\n" +
            "            \"document\": \"69165588000130\",\n" +
            "            \"is_checked\": false,\n" +
            "            \"is_prior_authorization\": false\n" +
            "        }\n" +
            "    },\n" +
            "    \"code_anbima\": \"\",\n" +
            "    \"operation_value\": \"112312300,15\",\n" +
            "    \"number_quotas\": \"1234,123457\",\n" +
            "    \"settlement_type\": \"TED\",\n" +
            "    \"beneficiary\": {\n" +
            "        \"name\": \"Fundo Favorecido ABC\",\n" +
            "        \"document\": \"\",\n" +
            "        \"account\": {\n" +
            "            \"bank\": \"123\",\n" +
            "            \"agency\": \"\",\n" +
            "            \"account_number\": \"12345678\",\n" +
            "            \"account_digit\": \"1\"\n" +
            "        },\n" +
            "        \"cetip\": {\n" +
            "            \"code_shareholder\": \"1234567\",\n" +
            "            \"code_fund\": \"777861912GG\",\n" +
            "            \"code_counterparty\": \"1234567\",\n" +
            "            \"modality\": \"Bruta\",\n" +
            "            \"command\": \"Abc1234567\"\n" +
            "        }\n" +
            "    },\n" +
            "    \"order_status\": {\n" +
            "        \"code\": 8,\n" +
            "        \"name\": \"Cotizada\",\n" +
            "        \"description\": \"Cotizada\",\n" +
            "        \"assigned_to\": null,\n" +
            "        \"is_final\": true,\n" +
            "        \"date_updated\": \"2021-10-08T13:12:12.198-0300\",\n" +
            "        \"updated_by_user\": \"Sistema\"\n" +
            "    },\n" +
            "    \"history\": [\n" +
            "        {\n" +
            "            \"code\": 11,\n" +
            "            \"name\": \"Ag.Cons.CPassivo\",\n" +
            "            \"user_id\": null,\n" +
            "            \"date_updated\": \"2021-09-14T09:55:33.703-0300\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"code\": 13,\n" +
            "            \"name\": \"Ag.Cons.CAtivo\",\n" +
            "            \"user_id\": \"64342966-d2bf-4943-9c2c-5764c061356f\",\n" +
            "            \"date_updated\": \"2021-09-14T13:30:56.364-0300\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"code\": 6,\n" +
            "            \"name\": \"Expirada\",\n" +
            "            \"user_id\": null,\n" +
            "            \"date_updated\": \"2021-10-02T23:12:12.538-0300\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"observations\": \"aqui\",\n" +
            "    \"billeting\": {\n" +
            "        \"id\": \"998d6b0a-5789-4575-b488-f3eaf1df1135\",\n" +
            "        \"is_partial\": true\n" +
            "    },\n" +
            "    \"errors\": [\n" +
            "        \"Fora do horário limite de boletagem\"\n" +
            "    ],\n" +
            "    \"id_origem\": null,\n" +
            "    \"is_checked\": false,\n" +
            "    \"user_id\": null,\n" +
            "    \"is_prior_authorization\": false,\n" +
            "    \"file_processed\": null,\n" +
            "    \"observation_notes\": [],\n" +
            "    \"liquidation_date\": \"08/10/2021\",\n" +
            "    \"quota_date\": null,\n" +
            "    \"operating_quotas\": null,\n" +
            "    \"withdraw_value\": null,\n" +
            "    \"code_denial_reason\": null,\n" +
            "    \"cancel_description\": null,\n" +
            "    \"_rid\": \"O3MXAI8rtgoBAAAAAAAAAA==\",\n" +
            "    \"_self\": \"dbs/O3MXAA==/colls/O3MXAI8rtgo=/docs/O3MXAI8rtgoBAAAAAAAAAA==/\",\n" +
            "    \"_etag\": \"\\\"3b009fc7-0000-0b00-0000-623de0100000\\\"\",\n" +
            "    \"_attachments\": \"attachments/\",\n" +
            "    \"_ts\": 1648222224\n" +
            "}";




//    @FunctionName("processSensorData")
//    public void processSensorData(
//            @EventHubTrigger(
//                    name = "msg",
//                    eventHubName = "", // blank because the value is included in the connection string
//                    cardinality = Cardinality.ONE,
//                    connection = "EventHubConnectionString")
//                    TelemetryItem item,
//            @CosmosDBOutput(
//                    name = "databaseOutput",
//                    databaseName = "TelemetryDb",
//                    collectionName = "TelemetryInfo",
//                    connectionStringSetting = "CosmosDBConnectionString")
//                    OutputBinding<TelemetryItem> document,
//            final ExecutionContext context) {
//
//        context.getLogger().info("Event hub message received: " + item.toString());
//
//        if (item.getPressure() > 30) {
//            item.setNormalPressure(false);
//        } else {
//            item.setNormalPressure(true);
//        }
//
//        if (item.getTemperature() < 40) {
//            item.setTemperatureStatus(status.COOL);
//        } else if (item.getTemperature() > 90) {
//            item.setTemperatureStatus(status.HOT);
//        } else {
//            item.setTemperatureStatus(status.WARM);
//        }
//
//        document.setValue(item);
//    }

}
