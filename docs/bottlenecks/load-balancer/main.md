For the Load Balancer, I used the **NGINX Ingress Controller**, which is a popular choice for managing ingress traffic in Kubernetes clusters. It acts as a reverse proxy and load balancer, being the only pod exposed and routing traffic to the gateway thats inside the cluster.

The NGINX Ingress Controller is deployed as a kubernetes pod of type LoadBalancer in the minikube cluster.

In the project, the setup file it located as follows:

```
gateway-service/
    ├── k8s/
    │   └── ingress-gateway.yaml
```

```yaml
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: gateway-ingress
  namespace: default
spec:
  ingressClassName: nginx
  rules:
  - host: loja.local
    http:
      paths:
      - path: /
        pathType: Prefix
        backend:
          service:
            name: gateway
            port:
              number: 8080
```

## Request flow

![](./img/traffic-logic.png)

## Visualizing on the terminal

![](./img/describe.png){width="100%"}