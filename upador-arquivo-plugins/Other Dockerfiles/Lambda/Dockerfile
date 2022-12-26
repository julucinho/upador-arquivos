FROM public.ecr.aws/lambda/java:11

COPY ../../target/classes ${LAMBDA_TASK_ROOT}
COPY target/dependency/* ${LAMBDA_TASK_ROOT}/lib/

CMD ["org.julucin.upador_arquivo_plugins.use_cases.upload_file.lambda_handler.LambdaHandler::handleRequest"]