<b>Valores de chaves criados de forma randômica por proteção. Precisa ter o Maven para rodar.</b>

---

<b>Doc de como funciona</b>: 

https://docs.microsoft.com/en-us/azure/azure-functions/functions-integrate-store-unstructured-data-cosmosdb?tabs=csharp

-----

<b>Comandos e dicas</b>:
1. Comece o projeto
   * mvn archetype:generate -DarchetypeGroupId=com.microsoft.azure -DarchetypeArtifactId=azure-functions-archetype -DjavaVersion=8
2. Rode o projeto local
    * mvn clean package azure-functions:run
3. Mande para o Azure
    * mvn clean package azure-functions:deploy
---

Por que utilizar tecnologias como Serverless?

https://blog.accurate.com.br/serverless/

---

<b>Geralmente é estes parâmetros</b>:
AccountKey

storageAccountName

AccountName

DefaultEndpointsProtocol

listKeys

storageAccountid

---
https://github.com/azure-samples/azure-cosmos-java-sql-api-samples

https://medium.com/@middha.nishant173/improve-query-performance-with-azure-cosmosdb-java-sdk-v4-db1fc54cb484

https://github.com/Azure/azure-cosmosdb-java

https://github.com/Azure-Samples/azure-cosmos-db-sql-api-async-java-getting-started

https://thewindowsupdate.com/2020/03/12/create-a-java-azure-cosmos-db-function-trigger-using-visual-studio-code-in-2-minutes/

https://www.codeproject.com/Articles/5328021/Streaming-at-Scale-with-Azure-Event-Hubs-Azure-F-2

https://docs.microsoft.com/en-us/azure/azure-functions/functions-event-hub-cosmos-db?tabs=bash


