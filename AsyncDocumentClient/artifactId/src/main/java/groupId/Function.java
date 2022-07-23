package groupId;

import com.microsoft.azure.cosmosdb.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.cosmosdb.rx.AsyncDocumentClient;
import com.microsoft.azure.functions.*;
import rx.Observable;

import java.util.Optional;


public class Function {


//    {
//        "IsEncrypted": false,
//            "Values": {
//        "AzureWebJobsStorage": "UseDevelopmentStorage=true",
//                "AzureCosmosDBConnection": "<PRIMARY CONNECTION STRING for Cosmos DB in Azure portal>",
//                "FUNCTIONS_WORKER_RUNTIME": "java",
//                "targeturi": "<URI for target database/collection from Portal>",
//                "targeturikey": "<PRIMARY KEY for target database/collection from Portal>"
//    }
//    }

    private final String databaseName = "orders";
    private final String collectionId = "orders";
    private AsyncDocumentClient asyncClient;
    private final String targeturi = System.getenv("https://dev-cosmos-client-001.documents.azure.com:443/");
    private final String targeturikey = System.getenv("Password");

    ConnectionPolicy connectionPolicy = new ConnectionPolicy();

    public Function() {
        asyncClient = new AsyncDocumentClient.Builder().withServiceEndpoint(targeturi)
                .withMasterKeyOrResourceToken(targeturikey).withConnectionPolicy(connectionPolicy)
                .withConsistencyLevel(ConsistencyLevel.Session).build();

    }
//
//    @FunctionName("cosmosDBMonitor")
//    public void cosmosDbProcessor(
//            @CosmosDBTrigger(name = "items", databaseName = "orders", collectionName = "orders", createLeaseCollectionIfNotExists = true, connectionStringSetting = "AzureCosmosDBConnection") String[] items,
//            final ExecutionContext context) {
//        System.out.println("sdafdsf");
//        connectionPolicy.setConnectionMode(ConnectionMode.Direct);
//        for (String string : items) {
//            Document doc = new Document(nha);
//            asyncClient.createDocument("dbs/" + databaseName + "/colls/" + collectionId, doc, null, false).toBlocking().single().getResource();
//            System.out.println("moved document: "+string);
//        }
//    }



//        @FunctionName("cosmosDBMonitor")
//        public void cosmosDbProcessor(
//                @CosmosDBTrigger(name = "items",
//                        databaseName = "database", collectionName = "collection1",
//                        createLeaseCollectionIfNotExists = true,
//                        connectionStringSetting = "AzureCosmosDBConnection") String[] items,
//                final ExecutionContext context) {
//            for (String string : items) {
//                System.out.println(string);
//            }
//            context.getLogger().info(items.length + "item(s) is/are changed.");
//        }



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





    String nha = "{\n" +
            "    \"id\": \"d29d326e-d1e6-477d-8235-05e86ac6540c\",\n" +
            "    \"operation_date\": \"13/08/2021\",\n" +
            "    \"inclusion_date\": \"2021-08-12T17:25:47.890-0300\",\n" +
            "    \"shareholder\": {\n" +
            "        \"document\": \"63.577.769/0001-97\",\n" +
            "        \"name\": \"mudou aqui\"\n" +
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


}


