# !/usr/bin/env bash
set -euo pipefail

modules=(
  account
  account-service
  auth
  auth-service
  gateway-service
  order
  order-service
  product
  product-service
)

for dir in "${modules[@]}"; do
  echo
  echo "→ Building $dir … \n"
  if [[ "$dir" == *-service ]]; then
    (cd "./api/$dir" && mvn clean package)
  else
    (cd "./api/$dir" && mvn clean install)
  fi
done

echo
echo "✅ All modules built successfully!"