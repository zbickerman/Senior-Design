module "dynamodb" {
  source     = "../../modules/dynamodb"
  table_name = "work-orders-dev"

  tags = {
    Environment = "dev"
    Owner       = "Frank"
  }
}