# upador-arquivos
Repository for articulating knowledges about Clean Arch and integrations with Cloud Services. Java is being used as the background programming language.

## High level architecture

![high level architecture image](https://raw.githubusercontent.com/julucinho/upador-arquivos/main/Desenhos/upadorArquivoDesenho-Arquitetura%20alto%20n%C3%ADvel.drawio.png)

This application is designed to periodically be triggered by an external service to execute the use case of uploading a local file to a remote storage location. 

## V1 - Low level architecture (AWS)
![low level architecture imagem; aws case](https://raw.githubusercontent.com/julucinho/upador-arquivos/main/Desenhos/upadorArquivoDesenho-Arquitetura%20baixo%20n%C3%ADvel.drawio.png)

The V1 lower level of abstraction to the solution is represented in the image above. The services being used from the current Cloud Provider (AWS) are 5:
- EventBridge
- ECR
- IAM
- Lambda
- S3

### Lambda
For Lambda we have a Java application running. Its component architecture is based on the hexagonal and clean architectures. It is because of this that there are two Java projects: the core and the plugins layers, being connected with ports and adapters via dependency management.

#### Core Layer
This layer is where the core-logic of the application lives at. The core-logic is more of a code-version of the high level architecture of the solution: it materializes the basic workflow with its intrinsic details, which means that it will only change when the logic of the workflow itself changes. Until then, the core layer will remain the same. Issues such as what kind of services are being integrated with the solution don't really matter to this layer. Today we use AWS, tomorrow we might use Azure... to this layer it doesn't change a thing. 

#### Plugins Layer
This is where the outside of the workflow is at. Components like S3 clients, Lambda request handlers, REST endpoint controllers, Kafka consumer listeners and much more, could all be found here. Those elements are considered outsiders to the core layer because they don't really affect it, they just exist as if they were extensions to it. If the core requests to upload a file, the plugins layer will extend it, making it integrate with the S3 client component, uploading the file to some specific bucket. Furthermore if we wish to switch that S3 client plugin component with another client to a different cloud provider such as CloudStorage from Google Cloud instead of AWS S3, we do this in this layer, without having to touch anything at the core.

--- Continue ---
