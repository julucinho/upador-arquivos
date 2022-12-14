# upador-arquivos (in development)
Repository for articulating knowledges about Clean Arch and integrations with Cloud Services. Java is being used as the background programming language.

## High level architecture

![high level architecture image](https://raw.githubusercontent.com/julucinho/upador-arquivos/main/Desenhos/upadorArquivoDesenho-Arquitetura%20alto%20n%C3%ADvel.drawio.png)

This application is designed to periodically be triggered by an external service to execute the use case of uploading a local file to a remote storage location. 

## V1 - Low level architecture (AWS)
![low level architecture imagem; aws case](https://raw.githubusercontent.com/julucinho/upador-arquivos/main/Desenhos/upadorArquivoDesenho-Arquitetura%20baixo%20n%C3%ADvel.drawio.png)

The V1 lower level of abstraction to the solution is represented in the image above. The services being used from the current Cloud Provider (AWS) are 5:

- IAM
- EventBridge
- ECR
- Lambda
- S3

The structure of this project is organized sorting the components by the following types:

- Architectural drawings
- AWS Services
    - IaC
    - Environment variables
    - Script for provisioning
- Application Code

This way we have the following diagram:
    
    
    upador-arquivos/
    ├── Desenhos/
    │   ├── upadorArquivoDesenho-Arquitetura alto nível.drawio.png
    │   ├── upadorArquivoDesenho-Arquitetura alto nível.drawio.png
    |   └── upadorArquivoDesenho.drawio
    ├── ECR/
    │   └── scripts-hom.txt
    ├── EventBridge/
    |   ├── iac.yaml
    |   ├── parameters-hom.json
    |   └── scripts-hom.txt
    ├── IAM
    |   ├── EventRuleExecution
    |   |   ├── iac.yaml
    |   |   ├── parameters-hom.json
    |   |   └── scripts-hom.txt
    |   ├── LambdaExecution
    |   |   ├── iac.yaml
    |   |   ├── parameters-hom.json
    |   |   └── scripts-hom.txt
    ├── LambdaFunction
    |   ├── iac.yaml
    |   ├── parameters-hom.json
    |   └── scripts-hom.txt
    ├── S3
    |   ├── iac.yaml
    |   ├── parameters-hom.json
    |   └── scripts-hom.txt
    ├── upador-arquivo-core (java application)
    |   └── ...
    └── upador-arquivo-plugins (java application)
        └── ...
    

## Components

### IAM
IAM is used to provision instances of Roles that grant access to the EventBridge and Lambda Function resources to interact with other services.

Its IaC files can be found at: 
> ./IAM/

### EventBridge
The component implemented using this service was meant to be responsibile for starting up the workflow, triggering the execution of the application periodically at a constant rate. For this resource to work properly it is necessary to have an IAM Role, granting access to the Lambda Function Invoking action and logs actions.

Its IaC files can be found at:
> ./EventBridge/

### Lambda
For Lambda we have a Java application running. Its component architecture is based on the hexagonal and clean architectures. It is because of this that there are two Java projects: the core and the plugins layers, being connected with ports and adapters via dependency management.

#### Core Layer
This layer is where the core-logic of the application lives at. The core-logic is more of a code-version of the high level architecture of the solution: it materializes the basic workflow with its intrinsic details, which means that it will only change when the logic of the workflow itself changes. Until that happens, the core layer will remain the same. 

Issues such as what kinds of service are being integrated with the solution don't really matter to this layer. Currently we use AWS, in the future we might use Azure... to this layer it doesn't change a thing. 

#### Plugins Layer
This is where the outside of the workflow is at. Components like S3 clients, Lambda request handlers, REST endpoint controllers, Kafka consumer listeners and many more, could all be found here. Those elements are considered outsiders to the core layer because they don't really affect it, they just exist as if they were extensions to it. If the core requests to upload a file, the plugins layer will extend the core layer to perform that behavior, in this case making use of its S3 client component in order to upload the file to a specific bucket. 

Furthermore, if we wish to switch that client plugin component with another client to a different cloud provider, such as CloudStorage from Google Cloud instead of S3 from AWS, we do this in this layer, without having to touch anything at the core and its workflow will still work, as if nothing changed at all.

Its IaC files can be found at:
>./LambdaFunction/

The application files can be found in two different directories:
- Core layer
> ./upador-arquivo-core/
- Plugins layer
> ./upador-arquivo-plugins/

_The two application artifacts have 100% of test coverage._

### ECR
The deployment package type for the Lambda Function is container image: in order to deploy the code into the Lambda service, an image is built and uploaded to the ECR repository resource. From there the Lambda service can pull it and provision the Function resource instantiating the container.

The Dockerfile can be found at:
>./upador-arquivo-plugins/Dockerfile

The script to build and then upload the image to ECR can be found at:
>./ECR/

### S3
S3 is being used to provision the target location for the file storage. Simple as it is.

Its IaC files can be found at:
>./S3/
