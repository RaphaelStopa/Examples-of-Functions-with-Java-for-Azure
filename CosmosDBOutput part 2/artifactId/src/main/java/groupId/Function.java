package groupId;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.*;

import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {

    @FunctionName("getItem")
    //    A CosmosDBOutput do Azure Cosmos DB permite gravar um novo documento em um banco de dados do Azure Cosmos DB usando a API SQL.
    @CosmosDBOutput(name = "orders",
            databaseName = "orders",
            collectionName = "items",
            connectionStringSetting = "AzureCosmosDBConnection")
    public String CosmosDbQueryById(
            //O QueueTrigger executa uma função à medida que as mensagens são adicionadas ao Armazenamento de Filas do Azure
            @QueueTrigger(name = "msg",
                    queueName = "myqueue-items",
                    connection = "AzureWebJobsStorage")
                    String message,
            final ExecutionContext context)  {

        return "{ id: \"" + System.currentTimeMillis() + "\", Description: " + message + " }";
    }


// Fazer este tambem
//    @FunctionName("QueueTriggerMetadata")
//    public void QueueTriggerMetadata(
//            @QueueTrigger(name = "message", queueName = "test-input-java-metadata", connection = "AzureWebJobsStorage") String message,@BindingName("Id") String metadataId,
//            @QueueOutput(name = "output", queueName = "test-output-java-metadata", connection = "AzureWebJobsStorage") OutputBinding<TestData> output,
//            final ExecutionContext context
//    ) {
//        context.getLogger().info("Java Queue trigger function processed a message: " + message + " with metadaId:" + metadataId );
//        TestData testData = new TestData();
//        testData.id = metadataId;
//        output.setValue(testData);
//    }
//

}
