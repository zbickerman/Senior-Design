# Workorder Processor

This service is a Java-based AWS Lambda function used for processing work orders.

---

## Overview

The Lambda is already deployed via Terraform.
Your responsibility as a developer is to:

* Build the Lambda code
* Invoke it using the AWS CLI
* Begin extending the handler logic

---

## Prerequisites

Make sure you have the following installed and configured:

* Java (JDK 17 or 21)
* Maven
* AWS CLI
* AWS credentials with permission to invoke the Lambda

---

## Build the Lambda

From the `services/workorder-processor` directory:

```bash
mvn clean package
```

This will generate the deployable artifact:

```text
target/workorder_processor.jar
```

---

## Lambda Configuration

* Runtime: `java21`
* Handler: `handler.Handler::handleRequest`

---

## Test the Lambda

Run the following command:

```bash
aws lambda invoke \
  --function-name workorder-processor-dev \
  --cli-binary-format raw-in-base64-out \
  --payload '"hello"' \
  output.json
```

Then view the result:

```bash
cat output.json
```

---

## Expected Output

```text
"Processed: hello"
```

---

## Troubleshooting

If the invocation fails, check:

* AWS CLI is installed (`aws --version`)
* AWS credentials are configured (`aws configure`)
* You are using the correct region (e.g., `us-east-1`)
* You have permission to invoke the Lambda (`lambda:InvokeFunction`)
* The build completed successfully and the JAR exists in `target/`

---

## Notes

* Terraform and infrastructure are managed separately
* Do NOT commit the `target/` folder
* CI/CD for automated builds and deployments will be added next

---

## Next Steps

* Extend the handler to process real events (e.g., SQS messages)
* Add business logic for work order processing
* Integrate with downstream services (e.g., DynamoDB, notifications)
