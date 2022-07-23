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

    //Bind binary inputs or outputs to byte[], by setting the dataType field in your function.json to binary:
    @FunctionName("BlobTrigger")
    @StorageAccount("AzureWebJobsStorage")
    public void blobTrigger(
            @BlobTrigger(name = "content", path = "myblob/{fileName}", dataType = "binary") byte[] content,
            @BindingName("fileName") String fileName,
            final ExecutionContext context
    ) {
        context.getLogger().info("Java Blob trigger function processed a blob.\n Name: " + fileName + "\n Size: " + content.length + " Bytes");
    }

}
