output "table_name" {
  value = aws_dynamodb_table.work_orders.name
}

output "table_arn" {
  value = aws_dynamodb_table.work_orders.arn
}

output "table_id" {
  value = aws_dynamodb_table.work_orders.id
}