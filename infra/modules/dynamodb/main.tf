resource "aws_dynamodb_table" "work_orders" {
  name         = var.table_name
  billing_mode = "PAY_PER_REQUEST"
  hash_key     = "work_order_id"


  attribute {
    name = "work_order_id"
    type = "S"
  }


  tags = merge(var.tags, {
    ManagedBy = "Terraform"
  })
}